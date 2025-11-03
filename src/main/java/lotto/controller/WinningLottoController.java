package lotto.controller;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.result.LottoResult;
import lotto.domain.validation.lotto.LottoNumberConverter;
import lotto.exception.InputException;
import lotto.service.LottoResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningLottoController {
    private final LottoResultService lottoResultService;
    private final OutputView outputView;
    private final InputView inputView;
    private final LottoNumberConverter lottoNumberConverter;

    public WinningLottoController(LottoResultService lottoResultService, OutputView outputView, InputView inputView,
                                  LottoNumberConverter lottoNumberConverter) {
        this.lottoResultService = lottoResultService;
        this.outputView = outputView;
        this.inputView = inputView;
        this.lottoNumberConverter = lottoNumberConverter;
    }

    public WinningLotto runWinningLotto() {
        Lotto winningNumbers = getValidWinningNumbers();
        LottoNumber bonusNumber = getValidBonusNumber(winningNumbers);

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Lotto getValidWinningNumbers() {
        while (true) {
            try {
                return createLottoFromInput();
            } catch (NumberFormatException e) {
                System.out.println(InputException.TEXT_IS_NO_NUMBER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LottoNumber processValidBonusNumber(Lotto winningLotto) {
        LottoNumber bonusNumber = receiveBonusNumber();
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(InputException.LOTTO_NUM_DUPLICATION.getMessage());
        }
        return bonusNumber;
    }

    private LottoNumber getValidBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                return processValidBonusNumber(winningLotto);
            } catch (NumberFormatException e) {
                System.out.println(InputException.TEXT_IS_NO_NUMBER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto createLottoFromInput() {
        String input = inputView.inputLottoNumber();
        List<LottoNumber> numbers = lottoNumberConverter.convert(input);
        return Lotto.create(numbers);
    }

    private LottoNumber receiveBonusNumber() {
        String input = inputView.inputBonusLottoNumber();
        LottoNumberConverter lottoNumberConverter = new LottoNumberConverter();
        return lottoNumberConverter.bonusConvert(input);
    }

    public void resultDisplayLottos(List<Lotto> purchasedLottos, WinningLotto winningLotto, int investmentAmount) {
        LottoResult result = lottoResultService.analyze(purchasedLottos, winningLotto, investmentAmount);
        outputView.OutputLottoResult(result);
    }
}
