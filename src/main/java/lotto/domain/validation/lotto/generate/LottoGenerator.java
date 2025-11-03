package lotto.domain.validation.lotto.generate;

import java.util.List;
import lotto.domain.lotto.LottoNumber;

public interface LottoGenerator {
    List<LottoNumber> generateNumbers();
}
