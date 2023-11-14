package christmas.domain.order;

import christmas.domain.menu.Menu;

public class OrderItem {

    private final Menu menu;
    private final int quantity;

    public OrderItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
        validateQuantity();
    }

    private void validateQuantity() {
        // TODO: 수량이 유효한지 검증하는 로직을 구현합니다.
    }

    public Menu getMenu() {
        // TODO: 필요한지 검토
        return menu;
    }

    public int getQuantity() {
        // TODO: 필요한지 검토
        return quantity;
    }
}
