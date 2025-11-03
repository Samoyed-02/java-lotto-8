package lotto.domain.validation.lotto;

import java.util.List;
import lotto.domain.validation.lotto.input.LottoValidationRule;
import lotto.domain.validation.lotto.input.ValidateLottoNumDuplication;
import lotto.domain.validation.lotto.input.ValidateLottoSizeOver;

public class LottoRuleRegistry {
    private final static List<LottoValidationRule> LOTTO_RULES = List.of(
            new ValidateLottoNumDuplication(),
            new ValidateLottoSizeOver()
    );

    public static List<LottoValidationRule> getLottoRules() {
        return LOTTO_RULES;
    }
}
