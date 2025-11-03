package lotto.domain.result;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int count;
    private final int rewards;

    LottoRank(int count, int reward) {
        this.count = count;
        this.rewards = reward;
    }

    public int getCount() {
        return count;
    }

    public int getRewards() {
        return rewards;
    }
}

