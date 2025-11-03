package lotto.controller;

import java.util.List;
import lotto.domain.amount.Amount;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;

public class GameController {

    private final AmountController amountController;
    private final LottoController lottoController;
    private final WinningLottoController winningLottoController;

    public GameController(AmountController amountController,
                          LottoController lottoController,
                          WinningLottoController winningLottoController) {
        this.amountController = amountController;
        this.lottoController = lottoController;
        this.winningLottoController = winningLottoController;
    }

    public void startLotto() {
        Amount amount = amountController.runAmount();
        List<Lotto> purchasedLottos = lottoController.buyDisplayLottos(amount);
        int totalInvestment = amount.getAmount();
        WinningLotto winningLotto = winningLottoController.runWinningLotto();
        winningLottoController.resultDisplayLottos(purchasedLottos, winningLotto, totalInvestment);
    }
}
