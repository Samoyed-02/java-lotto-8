package lotto.domain.validation.lotto;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.InputException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberConverterTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   "})
    void 문자열_입력_없으면_예외(String input) {
        LottoNumberConverter lottoNumberConverter = new LottoNumberConverter();
        assertThatThrownBy(() -> lottoNumberConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputException.TEXT_IS_EMPTY.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,,3,4,5", "1,2,3,,4,5"})
    void 구분자_중간에_없으면_예외(String input) {
        LottoNumberConverter lottoNumberConverter = new LottoNumberConverter();
        lottoNumberConverter.convert(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {" 1,2,3,4,5,6", "1,2,3,4,5,6 "})
    void 앞뒤_공백은_정상_처리(String input) {
        String testInput = "1,2,3,4,5,6";
        LottoNumberConverter lottoNumberConverter = new LottoNumberConverter();
        assertThat(lottoNumberConverter.convert(input)).isEqualTo(lottoNumberConverter.convert(testInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   "})
    void 보너스_입력_없으면_예외(String input) {
        LottoNumberConverter lottoNumberConverter = new LottoNumberConverter();
        assertThatThrownBy(() -> lottoNumberConverter.bonusConvert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputException.TEXT_IS_EMPTY.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" 1", "1 "})
    void 보너스_앞뒤_공백은_정상_처리(String input) {
        String testInput = "1";
        LottoNumberConverter lottoNumberConverter = new LottoNumberConverter();
        assertThat(lottoNumberConverter.bonusConvert(input)).isEqualTo(lottoNumberConverter.bonusConvert(testInput));
    }
}
