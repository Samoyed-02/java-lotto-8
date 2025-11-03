package lotto.domain.validation.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.validation.lotto.generate.RandomLottoNumber;
import org.junit.jupiter.api.Test;

class RandomLottoNumberTest {

    @Test
    void 로또_번호는_6개() {
        RandomLottoNumber randomLottoNumber = new RandomLottoNumber();
        assertThat(randomLottoNumber.generateNumbers()).hasSize(6);
    }

    @Test
    void 로또_번호의_범위는_1_45() {
        RandomLottoNumber randomLottoNumber = new RandomLottoNumber();
        assertThat(randomLottoNumber.generateNumbers())
                .allMatch(lottoNumber -> lottoNumber.getLottoNumber() >= 1 && lottoNumber.getLottoNumber() <= 45);
    }

    @Test
    void 로또_번호는_중복_없이() {
        RandomLottoNumber randomLottoNumber = new RandomLottoNumber();
        assertThat(randomLottoNumber.generateNumbers()).doesNotHaveDuplicates();
    }

    @Test
    void 로또_번호_매번_다르게() {
        RandomLottoNumber randomLottoNumber = new RandomLottoNumber();
        List<LottoNumber> first = randomLottoNumber.generateNumbers();
        List<LottoNumber> second = randomLottoNumber.generateNumbers();
        assertThat(first).isNotEqualTo(second);
    }
}
