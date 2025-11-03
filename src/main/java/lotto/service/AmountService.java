package lotto.service;

import lotto.domain.amount.Amount;
import lotto.domain.lotto.LottoPrice;

public class AmountService {

    public AmountService() {
    }

    public int buyLotto(Amount amount) {
        int rawAmount = amount.getAmount();
        return LottoPrice.calculatePrice(rawAmount);
    }
}
