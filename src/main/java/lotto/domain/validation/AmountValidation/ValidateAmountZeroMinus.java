package lotto.domain.validation.AmountValidation;

import lotto.exception.InputException;

public class ValidateAmountZeroMinus implements AmountValidationRule {

    @Override
    public void validate(Integer amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(InputException.AMOUNT_ZERO_MINUS.getMessage());
        }
    }
}