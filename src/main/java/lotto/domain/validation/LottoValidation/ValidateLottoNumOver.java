package lotto.domain.validation.LottoValidation;

import java.util.List;
import lotto.exception.InputException;

public class ValidateLottoNumOver implements LottoValidationRule {
    @Override
    public void validate(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateSingleNumber(number);
        }
    }

    private void validateSingleNumber(Integer number) {
        if (number > 45) {
            throw new IllegalArgumentException(InputException.LOTTO_NUM_SIZE_OVER.getMessage());
        }
    }
}
