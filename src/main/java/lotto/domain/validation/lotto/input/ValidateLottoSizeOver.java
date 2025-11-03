package lotto.domain.validation.lotto.input;

import java.util.List;
import lotto.domain.lotto.LottoNumber;
import lotto.exception.InputException;

public class ValidateLottoSizeOver implements LottoValidationRule {
    @Override
    public void validate(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(InputException.LOTTO_SIZE_LESS_OR_OVER.getMessage());
        }
    }
}