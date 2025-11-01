package lotto.domain;

import lotto.domain.Amount.AmountNumberConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountConvertTest {

    @Test
    @DisplayName("금액을 입력하면 int로 변환")
    void 텍스트_입력_테스트() {
        String testInputView = "1000";
        int except = 1000;
        AmountNumberConverter convert = new AmountNumberConverter();
        int result = AmountNumberConverter.convert(testInputView);
        assertThat(result).isEqualTo(except);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "1 1000"})
    @DisplayName("입력이 없거나 중간에 비었으면 예외 발생")
    void 텍스트_스페이스_포함(String testInputView) {
        assertThatThrownBy(() -> AmountNumberConverter.convert(testInputView))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" 1000", "1000 "})
    @DisplayName("앞뒤 공백은 정삭 작동")
    void 앞뒤_공백_처리(String testInputView) {
        int except = 1000;
        AmountNumberConverter convert = new AmountNumberConverter();
        int result = AmountNumberConverter.convert(testInputView);
        assertThat(result).isEqualTo(except);
    }
}
