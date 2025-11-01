package lotto.domain.validation.LottoValidation;

import java.util.List;

public interface LottoValidationRule {
    void validate(List<Integer> numbers);
}