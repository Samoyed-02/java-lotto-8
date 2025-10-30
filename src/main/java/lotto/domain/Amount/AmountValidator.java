
package lotto.domain.Amount;

import java.util.List;
import lotto.domain.validation.AmountValidation.AmountValidationRule;

public class AmountValidator {

    private final List<AmountValidationRule> rules;

    public AmountValidator(List<AmountValidationRule> rules) {
        this.rules = rules;
    }

    public void validate(Integer amount) {
        for (AmountValidationRule rule : rules) {
            rule.validate(amount);
        }
    }
}