
package lotto.exception;

public enum InputException {
    AMOUNT_INDIVISIBLE("금액이 1000원의 배수가 아닙니다."),
    AMOUNT_OVER("최대 금액을 초과했습니다.(최대 100,000원)"),
    AMOUNT_ZERO_MINUS("금액이 0원이거나 잘못되었습니다.");

    private String message;

    InputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}