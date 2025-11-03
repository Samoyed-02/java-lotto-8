package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.InputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @DisplayName("로또 숫자 범위를 벗어나면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    void 범위_관리(int testNumber) {
        assertThatThrownBy(() -> new LottoNumber(testNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputException.LOTTO_NUMBER_MIN_MAX.getMessage());
    }
}
