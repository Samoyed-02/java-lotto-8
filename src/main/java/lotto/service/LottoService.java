package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.validation.lotto.generate.LottoGenerator;

public class LottoService {

    private final LottoGenerator generator;

    public LottoService(LottoGenerator generator) {
        this.generator = generator;
    }

    public List<Lotto> getLottos(int totalTicket) {
        List<Lotto> purchaseLottos = new ArrayList<>();
        for (int i = 0; i < totalTicket; i++) {
            List<LottoNumber> numbers = generator.generateNumbers();
            Lotto newLotto = Lotto.create(numbers);
            purchaseLottos.add(newLotto);
        }
        return purchaseLottos;
    }
}
