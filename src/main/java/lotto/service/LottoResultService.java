package lotto.service;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.result.LottoRank;
import lotto.domain.result.LottoResult;
import lotto.domain.lotto.WinningLotto;

public class LottoResultService {

    public LottoResult analyze(List<Lotto> purchasedLottos, WinningLotto winningLotto, int investmentAmount) {

        LottoResult result = new LottoResult(investmentAmount);

        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.matchCount(winningLotto.winningNumbers());
            boolean isBonusMatch = lotto.contains(winningLotto.bonusNumber());
            LottoRank rank = determineRank(matchCount, isBonusMatch);
            result.addRankCount(rank);
        }
        return result;
    }

    private LottoRank determineRank(int matchCount, boolean isBonusMatch) {
        if (matchCount == 6) {
            return LottoRank.FIRST;
        }
        if (matchCount == 5 && isBonusMatch) {
            return LottoRank.SECOND; // 5개 일치 + 보너스 번호 일치
        }
        if (matchCount == 5) {
            return LottoRank.THIRD;
        }
        if (matchCount == 4) {
            return LottoRank.FOURTH;
        }
        if (matchCount == 3) {
            return LottoRank.FIFTH;
        }
        return LottoRank.NONE;
    }
}
