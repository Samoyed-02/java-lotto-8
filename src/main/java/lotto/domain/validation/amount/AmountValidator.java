
package lotto.domain.validation.amount;

import java.util.List;

public class AmountValidator {

    private final List<AmountValidationRule> rules;

    public AmountValidator(List<AmountValidationRule> rules) {
        this.rules = rules;
    }

    public void validate(Integer amount) {
        for (AmountValidationRule rule : this.rules) {
            rule.validate(amount);
        }
    }
}