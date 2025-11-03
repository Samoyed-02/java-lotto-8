package lotto.controller;

import java.util.List;
import lotto.domain.amount.Amount;
import lotto.domain.lotto.Lotto;
import lotto.service.AmountService;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final OutputView outputView;
    private final AmountService amountService;

    public LottoController(LottoService lottoService, OutputView outputView,
                           AmountService amountService) {
        this.lottoService = lottoService;
        this.outputView = outputView;
        this.amountService = amountService;
    }

    public List<Lotto> buyDisplayLottos(Amount amountValue) {
        int totalTicket = amountService.buyLotto(amountValue);
        List<Lotto> purchasedLottos = lottoService.getLottos(totalTicket);
        outputView.printLotto(purchasedLottos);
        return purchasedLottos;
    }
}

