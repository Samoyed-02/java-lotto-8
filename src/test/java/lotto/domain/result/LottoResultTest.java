package lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("수익률 계산 올바르게 되는지 테스트")
    @Test
    void 수익률_계산() {
        int testTotalAmount = 8000;
        LottoResult lottoResult = new LottoResult(testTotalAmount);
        double testReturnRate = 62.5;
        LottoRank testRank = LottoRank.FIFTH;
        lottoResult.addRankCount(testRank);
        assertThat(lottoResult.returnRate()).isEqualTo(testReturnRate);
    }
}
