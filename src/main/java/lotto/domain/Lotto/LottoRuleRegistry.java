package lotto.domain.Lotto;

import java.util.List;
import lotto.domain.validation.LottoValidation.LottoValidationRule;
import lotto.domain.validation.LottoValidation.ValidateLottoNumDuplication;
import lotto.domain.validation.LottoValidation.ValidateLottoNumOver;
import lotto.domain.validation.LottoValidation.ValidateLottoNumShort;
import lotto.domain.validation.LottoValidation.ValidateLottoSizeOver;

public class LottoRuleRegistry {
    private final static List<LottoValidationRule> LOTTO_RULES = List.of(
            new ValidateLottoNumShort(),
            new ValidateLottoNumDuplication(),
            new ValidateLottoNumOver(),
            new ValidateLottoSizeOver()
    );

    public static List<LottoValidationRule> getLottoRules() {
        return LOTTO_RULES;
    }
}
