package lotto.domain.validation.AmountValidation;

import lotto.exception.InputException;

public class ValidateAmountOver implements AmountValidationRule {

    @Override
    public void validate(Integer amount) {
        if (amount > 100000) {
            throw new IllegalArgumentException(InputException.AMOUNT_OVER.getMessage());
        }
    }
}