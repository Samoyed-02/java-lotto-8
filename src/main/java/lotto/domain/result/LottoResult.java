package lotto.domain.result;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> rankCounts;
    private final int investmentAmount;

    public LottoResult(int investmentAmount) {
        this.investmentAmount = investmentAmount;
        this.rankCounts = new EnumMap<>(LottoRank.class);
    }

    public void addRankCount(LottoRank rank) {
        rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
    }

    public long calculateTotalReward() {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getRewards() * entry.getValue())
                .sum();
    }

    public double returnRate() {
        return ((double) calculateTotalReward() / investmentAmount) * 100.0;
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return rankCounts;
    }
}



