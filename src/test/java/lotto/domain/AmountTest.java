package lotto.domain;

import lotto.domain.Amount.Amount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountTest {

    @DisplayName("규칙에 맞는 금액이면 정상적으로 생성")
    @Test
    void 금액_생성_테스트() {
        int testAmount = 3000;
        Amount amount = Amount.create(testAmount);

        assertThat(amount.getAmount()).isEqualTo(testAmount);
    }

    @ParameterizedTest
    @DisplayName("허용되지 않은 금액이면 예외 발생 ")
    @ValueSource(ints = {0, -100})
    void 허용안한_금액_예외_처리(int testAmount) {
        assertThatThrownBy(() -> Amount.create(testAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액 제한을 넘으면 예외 발생")
    void 금액_제한_예외_처리() {
        int testAmount = 101000;
        assertThatThrownBy(() ->Amount.create(testAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}