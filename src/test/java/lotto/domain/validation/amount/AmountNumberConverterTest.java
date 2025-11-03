package lotto.domain.validation.amount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.InputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountNumberConverterTest {

    @DisplayName("빈 입력은 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   "})
    void 문자열_비면_예외(String input) {
        AmountNumberConverter converter = new AmountNumberConverter();
        assertThatThrownBy(() -> converter.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputException.TEXT_IS_EMPTY.getMessage());
    }

    @DisplayName("앞뒤 공백은 정상 처리")
    @ParameterizedTest
    @ValueSource(strings = {" 9000", "9000 "})
    void 앞뒤_공백_정상_처리(String input) {
        int testAmount = 9000;
        AmountNumberConverter amountNumberConverter = new AmountNumberConverter();
        assertThat(amountNumberConverter.convert(input)).isEqualTo(testAmount);
    }
}
