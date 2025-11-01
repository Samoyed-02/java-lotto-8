package lotto.domain.Amount;

import lotto.exception.InputException;

public class AmountNumberConverter {
    public static Integer convert(String inputView) {
        if (inputView == null || inputView.trim().isEmpty()) {
            throw new IllegalArgumentException(InputException.TEXT_IS_EMPTY.getMessage());
        }
        return Integer.parseInt(inputView.trim());
    }
}
