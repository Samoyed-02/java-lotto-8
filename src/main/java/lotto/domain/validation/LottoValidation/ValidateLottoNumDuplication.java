package lotto.domain.validation.LottoValidation;

import java.util.List;
import lotto.exception.InputException;

public class ValidateLottoNumDuplication implements LottoValidationRule {
    @Override
    public void validate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(InputException.LOTTO_NUM_DUPLICATION.getMessage());
        }
    }
}
