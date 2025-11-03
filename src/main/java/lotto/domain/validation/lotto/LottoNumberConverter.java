package lotto.domain.validation.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoNumber;
import lotto.exception.InputException;

public class LottoNumberConverter {

    public List<LottoNumber> convert(String inputView) {
        if (inputView == null || inputView.trim().isEmpty()) {
            throw new IllegalArgumentException(InputException.TEXT_IS_EMPTY.getMessage());
        }
        List<Integer> integersNumber = Arrays.stream(inputView.trim().split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .toList();

        return integersNumber.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoNumber bonusConvert(String inputView) {
        if (inputView == null || inputView.trim().isEmpty()) {
            throw new IllegalArgumentException(InputException.TEXT_IS_EMPTY.getMessage());
        }
        int bonusValue = Integer.parseInt(inputView.trim());
        return new LottoNumber(bonusValue);
    }
}
