package lotto.AppConfig;

import lotto.controller.AmountController;
import lotto.controller.GameController;
import lotto.controller.LottoController;
import lotto.controller.WinningLottoController;
import lotto.domain.validation.amount.AmountNumberConverter;
import lotto.domain.validation.lotto.LottoNumberConverter;
import lotto.domain.validation.lotto.generate.LottoGenerator;
import lotto.domain.validation.lotto.generate.RandomLottoNumber;
import lotto.service.AmountService;
import lotto.service.LottoResultService;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public AmountNumberConverter amountNumberConverter() {
        return new AmountNumberConverter();
    }

    public LottoNumberConverter lottoNumberConverter() {
        return new LottoNumberConverter();
    }

    public LottoGenerator getLottoGenerator() {
        return new RandomLottoNumber();
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public AmountController amountController() {
        return new AmountController(inputView(), amountNumberConverter());
    }

    public AmountService amountService() {
        return new AmountService();
    }

    public LottoService lottoService() {
        return new LottoService(getLottoGenerator());
    }

    public LottoResultService lottoResultService() {
        return new LottoResultService();
    }

    public LottoController lottoController() {
        return new LottoController(lottoService(), outputView(), amountService());
    }

    public WinningLottoController winningLottoController() {
        return new WinningLottoController(lottoResultService(), outputView(), inputView(), lottoNumberConverter());
    }

    public GameController gameController() {
        return new GameController(amountController(), lottoController(), winningLottoController());
    }
}
