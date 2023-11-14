package christmas.domain.menu;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", 6_000, MenuCategory.APPETIZER),
    TAPAS("타파스", 5_500, MenuCategory.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8_000, MenuCategory.APPETIZER),
    T_BONE_STEAK("티본스테이크", 55_000, MenuCategory.MAIN_DISH),
    BBQ_RIPS("바베큐립", 54_000, MenuCategory.MAIN_DISH),
    SEAFOOD_PASTA("해산물파스타", 35_000, MenuCategory.MAIN_DISH),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, MenuCategory.MAIN_DISH),
    CHOCOLATE_CAKE("초코케이크", 15_000, MenuCategory.DESSERT),
    ICE_CREAM("아이스크림", 5_000, MenuCategory.DESSERT),
    ZERO_COLA("제로콜라", 3_000, MenuCategory.DRINK),
    RED_WINE("레드와인", 60_000, MenuCategory.DRINK),
    CHAMPAGNE("샴페인", 25_000, MenuCategory.DRINK);

    private final String name;
    private final int price;
    private final MenuCategory category;

    Menu(String name, int price, MenuCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        // TODO: 필요한지 검토
        return name;
    }

    public int getPrice() {
        // TODO: 필요한지 검토
        return price;
    }

    public MenuCategory getCategory() {
        // TODO: 필요한지 검토
        return category;
    }
}
