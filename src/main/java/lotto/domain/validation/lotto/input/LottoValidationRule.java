package lotto.domain.validation.lotto.input;

import java.util.List;
import lotto.domain.lotto.LottoNumber;

public interface LottoValidationRule {
    void validate(List<LottoNumber> numbers);
}