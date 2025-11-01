package lotto.domain.validation.LottoValidation;

import java.util.List;
import lotto.domain.Lotto.Lotto;
import lotto.exception.InputException;

public class ValidateLottoNumShort implements LottoValidationRule {
    @Override
    public void validate(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateSingleNumber(number);
        }
    }

    private void validateSingleNumber(Integer number) {
        if (number <= 0) {
            throw new IllegalArgumentException(InputException.LOTTO_NUMBER_ZERO_MINUS.getMessage());
        }
    }
}
