package lotto.domain.lotto;

import lotto.exception.InputException;

public record LottoNumber(int number) implements Comparable<LottoNumber> {
    public LottoNumber {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(InputException.LOTTO_NUMBER_MIN_MAX.getMessage());
        }
    }

    public int getLottoNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return number - other.number;
    }
}
