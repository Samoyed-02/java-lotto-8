package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPriceTest {

    @DisplayName("계산이 올바르게 되는지 확인")
    @Test
    void 로또_장수_계산() {
        int testAmount = 8000;
        int testLottoPrice = 8;
        int lottoPrice = LottoPrice.calculatePrice(testAmount);
        assertThat(lottoPrice).isEqualTo(testLottoPrice);
    }
}
