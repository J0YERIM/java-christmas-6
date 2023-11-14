package christmas.domain.badge;

public enum Badge {

    STAR(5_000),
    TREE(10_000),
    SANTA(20_000);

    private final int standardAmount;

    Badge(int standardAmount) {
        this.standardAmount = standardAmount;
    }

    public static Badge determineBadgeForAmount(int amount) {
        // TODO: 배지 조건에 따라 배지를 반환한다.
        return null;
    }
}
