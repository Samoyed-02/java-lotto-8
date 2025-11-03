package lotto.domain.lotto;

public class LottoPrice {
    public static final int PRICE = 1000;

    public static int calculatePrice(int amount) {
        return amount / PRICE;
    }
}
