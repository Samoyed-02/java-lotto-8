package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.validation.lotto.LottoNumberConverter;
import lotto.exception.InputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("로또 번호와 보너스 번호가 중복되면 예외 발생")
    @Test
    void 로또_번호와_보너스_번호_중복() {
        int testBonusNumber = 6;
        LottoNumber bonusNumber = new LottoNumber(testBonusNumber);
        LottoNumberConverter convert = new LottoNumberConverter();
        String testWinningNumbers = "1,2,3,4,5,6";
        List<LottoNumber> testListNumbers = convert.convert(testWinningNumbers);
        Lotto winningNumbers = Lotto.create(testListNumbers);
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputException.BONUS_NUM_DUPLICATION.getMessage());
    }
}
