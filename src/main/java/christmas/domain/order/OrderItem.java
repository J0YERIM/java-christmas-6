package christmas.domain.order;

import christmas.domain.menu.Menu;
import christmas.exception.InvalidOrderException;
import christmas.util.Constants;
import java.util.Objects;

public class OrderItem {

    private final Menu menu;
    private final int quantity;

    public OrderItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = validateQuantity(quantity);
    }

    private int validateQuantity(int quantity) {
        if (quantity < Constants.MIN_QUANTITY) {
            throw new InvalidOrderException();
        }
        return quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderItem orderItem = (OrderItem) o;
        return menu.equals(orderItem.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu);
    }
}
