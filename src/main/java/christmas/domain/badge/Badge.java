package christmas.domain.badge;

import java.util.Arrays;

public enum Badge {

    SANTA(20_000, "산타"),
    TREE(10_000, "트리"),
    STAR(5_000, "별");

    private final int standardAmount;
    private final String name;

    Badge(int standardAmount, String name) {
        this.standardAmount = standardAmount;
        this.name = name;
    }

    public static Badge getBadgeForTotalBenefitAmount(int amount) {
        return Arrays.stream(Badge.values())
                .filter(badge -> amount >= badge.standardAmount)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return name;
    }
}
