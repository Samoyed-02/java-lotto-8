package lotto.controller;

import lotto.domain.amount.Amount;
import lotto.domain.validation.amount.AmountNumberConverter;
import lotto.exception.InputException;
import lotto.view.InputView;

public class AmountController {

    private final InputView inputView;
    private final AmountNumberConverter amountNumberConverter;

    public AmountController(InputView inputView, AmountNumberConverter amountNumberConverter) {
        this.inputView = inputView;
        this.amountNumberConverter = amountNumberConverter;
    }

    public Amount runAmount() {
        while (true) {
            try {
                return createAmountFromInput();
            } catch (NumberFormatException e) {
                System.out.println(InputException.TEXT_IS_NO_NUMBER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Amount createAmountFromInput() {
        String input = inputView.inputAmount();
        int value = amountNumberConverter.convert(input);
        return Amount.create(value);
    }
}