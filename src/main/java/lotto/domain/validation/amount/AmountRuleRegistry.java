package lotto.domain.validation.amount;

import java.util.List;

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
