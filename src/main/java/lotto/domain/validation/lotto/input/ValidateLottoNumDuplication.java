package lotto.domain.validation.lotto.input;

import java.util.List;
import lotto.domain.lotto.LottoNumber;
import lotto.exception.InputException;

public class ValidateLottoNumDuplication implements LottoValidationRule {
    @Override
    public void validate(List<LottoNumber> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(InputException.LOTTO_NUM_DUPLICATION.getMessage());
        }
    }
}
