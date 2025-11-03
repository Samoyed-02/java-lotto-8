package lotto.Service;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.result.LottoRank;
import lotto.domain.result.LottoResult;
import lotto.service.LottoResultService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultServiceTest {

    @Test
    void 로또_등수_판정() {
        Lotto purchasedLotto = Lotto.create(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));
        Lotto inputLotto = Lotto.create(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(8),
                new LottoNumber(9),
                new LottoNumber(10)));
        List<Lotto> purchasedLottos = List.of(purchasedLotto);
        int testBonusNumber = 7;
        LottoNumber bonusLottoNumber = new LottoNumber(testBonusNumber);
        int testInvestmentAmount = 1000;
        LottoResultService lottoResultService = new LottoResultService();
        WinningLotto winningLotto = new WinningLotto(inputLotto, bonusLottoNumber);
        LottoResult testMap = lottoResultService.analyze(purchasedLottos, winningLotto, testInvestmentAmount);
        assertThat(testMap.getRankCounts().get(LottoRank.FIFTH).intValue()).isEqualTo(1);
    }
}


