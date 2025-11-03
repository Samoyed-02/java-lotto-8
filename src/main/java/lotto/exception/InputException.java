
package lotto.exception;

public enum InputException {
    AMOUNT_INDIVISIBLE("[ERROR] 금액이 1000원의 배수가 아닙니다. 다시 작성해주세요."),
    AMOUNT_OVER("[ERROR] 최대 금액을 초과했습니다.(최대 100,000원) 다시 작성해주세요."),
    AMOUNT_ZERO_MINUS("[ERROR] 금액이 0원이거나 잘못되었습니다. 다시 작성해주세요."),
    LOTTO_SIZE_LESS_OR_OVER("[ERROR] 로또 번호는 6개 작성해주세요. 다시 작성해주세요."),
    LOTTO_NUMBER_MIN_MAX("[ERROR] 로또 번호는 1~45사이의 수를 작성해주세요."),
    LOTTO_NUM_DUPLICATION("[ERROR] 로또 번호가 중복되었습니다. 다시 작성해주세요."),
    LOTTO_NUM_HAVE_SPACE("[ERROR] 로또 번호에 띄어쓰기가 포함되어있습니다. 다시 작성해주세요"),
    TEXT_IS_EMPTY("[ERROR] 입력 칸이 비었습니다. 다시 작성해주세요."),
    TEXT_IS_NO_NUMBER("[ERROR] 숫자를 입력해주세요."),
    BONUS_NUM_DUPLICATION("[ERROR] 로또 번호와 보너스 번호가 중복되었습니다. 다시 작성해주세요.");

    private final String message;

    InputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}