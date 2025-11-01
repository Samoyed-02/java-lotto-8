package lotto.domain.Amount;

import java.util.List;
import lotto.domain.validation.AmountValidation.AmountValidationRule;
import lotto.domain.validation.AmountValidation.ValidateAmountIndivisible;
import lotto.domain.validation.AmountValidation.ValidateAmountOver;
import lotto.domain.validation.AmountValidation.ValidateAmountZeroMinus;

public class AmountRuleRegistry {
    private static final List<AmountValidationRule> AMOUNT_RULES = List.of(
            new ValidateAmountOver(),
            new ValidateAmountZeroMinus(),
            new ValidateAmountIndivisible()
    );

    public static List<AmountValidationRule> getAmountRules() {
        return AMOUNT_RULES;
    }
}
