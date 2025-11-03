package lotto.domain.validation.lotto.generate;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoNumber;


public class RandomLottoNumber implements LottoGenerator {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;

    @Override
    public List<LottoNumber> generateNumbers() {
        List<Integer> integersNumber = Randoms.pickUniqueNumbersInRange(
                LOTTO_MIN_NUMBER,
                LOTTO_MAX_NUMBER,
                LOTTO_SIZE);

        return integersNumber.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}