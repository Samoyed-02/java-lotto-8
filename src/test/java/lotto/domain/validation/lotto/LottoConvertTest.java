package lotto.domain.validation.lotto;

import java.util.Arrays;
import java.util.List;
import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoConvertTest {

    @DisplayName("텍스트를 입력하면 List<Integer>로 변환")
    @Test
    void 텍스트_입력_테스트() {
        String testInputView = "1,2,3,4,5,6";
        List<LottoNumber> excepted = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
        LottoNumberConverter convert = new LottoNumberConverter();
        List<LottoNumber> result = convert.convert(testInputView);
        assertThat(result).isEqualTo(excepted);
    }

    @DisplayName("중간에 하나를 안썻거나 숫자 사이에 띄움이 있을 경우 예외 발생 ")
    @ParameterizedTest
    @ValueSource(strings = {"1,,2,3,4,5", "1,2,3,4,5,4 3"})
    void 입력_비었거나_띄어쓰면_예외발생(String testInputView) {
        LottoNumberConverter convert = new LottoNumberConverter();
        assertThatThrownBy(() -> convert.convert(testInputView))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("앞뒤 공백은 정상 작동")
    @ParameterizedTest
    @ValueSource(strings = {" 1,2,3,4,5,6", "1,2,3,4,5,6 "})
    void 입력_앞뒤_공백_처리(String testInputView) {
        List<LottoNumber> excepted = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
        LottoNumberConverter convert = new LottoNumberConverter();
        List<LottoNumber> result = convert.convert(testInputView);
        assertThat(result).isEqualTo(excepted);
    }
}
