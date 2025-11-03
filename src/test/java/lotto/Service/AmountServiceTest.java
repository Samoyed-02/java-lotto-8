package lotto.Service;

import lotto.domain.amount.Amount;
import lotto.service.AmountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class AmountServiceTest {

    @DisplayName("금액만큼 로또 수가 정해진다.")
    @Test
    void 금액이_로또로_바뀜() {
        int testAmount = 8000;
        int testLotto = 8;
        Amount amount = Amount.create(testAmount);
        AmountService service = new AmountService();
        assertThat((service.buyLotto(amount))).isEqualTo(testLotto);
    }
}
