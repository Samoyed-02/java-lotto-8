package lotto.domain.Amount;

import java.util.List;
import lotto.domain.validation.AmountValidation.AmountValidationRule;
import lotto.domain.validation.AmountValidation.ValidateAmountIndivisible;
import lotto.domain.validation.AmountValidation.ValidateAmountOver;
import lotto.domain.validation.AmountValidation.ValidateAmountZeroMinus;

public class Amount {

    List<AmountValidationRule> rules = List.of(
            new ValidateAmountOver() ,
            new ValidateAmountZeroMinus(),
            new ValidateAmountIndivisible()
    );

    AmountValidator validator = new AmountValidator(rules);

    private int amount;

    public Amount(int amount) {
        validator.validate(amount);
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

}