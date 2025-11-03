package lotto.domain.validation.lotto;

import java.util.List;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.validation.lotto.input.LottoValidationRule;

public class LottoValidator {

    private final List<LottoValidationRule> rules;

    public LottoValidator(List<LottoValidationRule> rules) {
        this.rules = rules;
    }

    public void validate(List<LottoNumber> numbers) {
        for (LottoValidationRule rule : rules) {
            rule.validate(numbers);
        }
    }
}
