package lotto.domain.validation.LottoValidation;

import java.util.List;
import lotto.exception.InputException;

public class ValidateLottoSizeOver implements LottoValidationRule {
    @Override
    public void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(InputException.LOTTO_SIZE_LESS_OR_OVER.getMessage());
        }
    }
}