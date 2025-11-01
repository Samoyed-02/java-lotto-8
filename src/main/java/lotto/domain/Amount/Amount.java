package lotto.domain.Amount;

import java.util.List;
import lotto.domain.validation.AmountValidation.AmountValidationRule;

public class Amount {

    private final int amount;

    private Amount(int amount, AmountValidator validator) {
        this.amount = amount;
        validator.validate(amount);
    }

    //Controller의 책임 해소와 test코드를 위한 메서드
    public static Amount create(int amount) {
        List<AmountValidationRule> rules = AmountRuleRegistry.getAmountRules();
        AmountValidator validator = new AmountValidator(rules);
        return new Amount(amount, validator);
    }

    public int getAmount() {
        return amount;
    }
}