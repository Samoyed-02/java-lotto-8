package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.result.LottoRank;
import lotto.domain.result.LottoResult;

public class OutputView {

    private final static String OUTPUT_LOTTO_RESULT = "당첨 통계";
    private final static String OUTPUT_DIVISION_LINE = "---";
    private final static String OUTPUT_BUYING_LOTTO = "개를 구매했습니다.";
    private final static String DISPLAY_AGREEMENT = "%d개 일치";
    private final static String DISPLAY_BONUS_AGREEMENT = "%d개 일치, 보너스 볼 일치";
    private final static String DISPLAY_WINNINGS = "%,d원";
    private final static String DISPLAY_RETURN_RATE = "총 수익률은 %.1f%%입니다.";

    public void printLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + OUTPUT_BUYING_LOTTO);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void OutputLottoResult(LottoResult lottoResult) {
        Map<LottoRank, Integer> rankCounts = lottoResult.getRankCounts();
        String displayRate = displayReturnRate(lottoResult.returnRate());
        System.out.println(OUTPUT_LOTTO_RESULT + "\n" + OUTPUT_DIVISION_LINE);
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NONE) {
                continue;
            }
            int count = rankCounts.getOrDefault(rank, 0);
            String displayAgm = displayAgreement(rank);
            String displayWinn = displayWinning(rank.getRewards());
            System.out.printf("%s (%s) - %d개\n", displayAgm, displayWinn, count);
        }
        System.out.printf("%s", displayRate);
    }

    private String displayAgreement(LottoRank rank) {
        if (rank == LottoRank.SECOND) {
            return String.format(DISPLAY_BONUS_AGREEMENT, rank.getCount());
        }
        return String.format(DISPLAY_AGREEMENT, rank.getCount());
    }

    private String displayWinning(long reward) {
        return String.format(DISPLAY_WINNINGS, reward);
    }

    private String displayReturnRate(double rate) {
        return String.format(DISPLAY_RETURN_RATE, rate);
    }

}
