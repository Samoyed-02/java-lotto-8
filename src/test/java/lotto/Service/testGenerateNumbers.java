package lotto.Service;

import java.util.List;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.validation.lotto.generate.LottoGenerator;

public class testGenerateNumbers implements LottoGenerator {

    @Override
    public List<LottoNumber> generateNumbers() {
        return List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
    }
}
