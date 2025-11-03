package lotto.domain.lotto;

import lotto.exception.InputException;

public record WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {

    public WinningLotto {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(InputException.BONUS_NUM_DUPLICATION.getMessage());
        }
    }
}
