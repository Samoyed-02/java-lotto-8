package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String INPUT_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_LOTTO_NUMBER = "보너스 번호를 입력해 주세요.";

    public String inputAmount() {
        System.out.println(INPUT_AMOUNT);
        return Console.readLine();
    }

    public String inputLottoNumber() {
        System.out.println(INPUT_LOTTO_NUMBER);
        return Console.readLine();
    }

    public String inputBonusLottoNumber() {
        System.out.println(INPUT_BONUS_LOTTO_NUMBER);
        return Console.readLine();
    }
}
