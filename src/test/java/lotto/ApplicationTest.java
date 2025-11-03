package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[1, 2, 3, 40, 41, 42]",
                            "[10, 11, 12, 13, 14, 15]",
                            "[17, 18, 19, 20, 21, 22]",
                            "[23, 24, 25, 26, 27, 28]",
                            "[29, 31, 32, 33, 34, 35]",
                            "[36, 37, 38, 39, 43, 44]",
                            "[9, 13, 22, 32, 38, 45]",
                            "[10, 12, 14, 20, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(1, 2, 3, 40, 41, 42),
                List.of(10, 11, 12, 13, 14, 15),
                List.of(17, 18, 19, 20, 21, 22),
                List.of(23, 24, 25, 26, 27, 28),
                List.of(29, 31, 32, 33, 34, 35),
                List.of(36, 37, 38, 39, 43, 44),
                List.of(9, 13, 22, 32, 38, 45),
                List.of(10, 12, 14, 20, 22, 45) // 0개 일치 (낙첨)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
