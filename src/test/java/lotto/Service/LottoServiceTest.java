package lotto.Service;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    @Test
    void 구매한_만큼_로또_생성() {
        int totalLottos = 6;
        LottoService lottoService = new LottoService(new testGenerateNumbers());
        List<Lotto> lottos = lottoService.getLottos(totalLottos);
        assertThat(lottos).hasSize(totalLottos);
    }
}
