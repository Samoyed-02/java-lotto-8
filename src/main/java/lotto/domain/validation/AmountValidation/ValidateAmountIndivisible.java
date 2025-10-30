package lotto.domain.validation.AmountValidation;

import lotto.exception.InputException;

public class ValidateAmountIndivisible implements AmountValidationRule {

    @Override
    public void validate(Integer amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(InputException.AMOUNT_INDIVISIBLE.getMessage());
        }
    }
}