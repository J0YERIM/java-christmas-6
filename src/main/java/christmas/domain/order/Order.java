package christmas.domain.order;

import christmas.exception.InvalidDateException;
import christmas.exception.InvalidOrderException;
import christmas.util.Constants;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashSet;
import java.util.Set;

/**
 * 고객의 전체 주문을 나타내는 클래스입니다.
 */
public class Order {

    private final LocalDate orderDate;
    private final Set<OrderItem> orderItems = new HashSet<>();

    public Order(int orderDate) {
        this.orderDate = createOrderDate(orderDate);
    }

    private LocalDate createOrderDate(int orderDate) {
        validateOrderDate(orderDate);
        return LocalDate.of(Constants.CURRENT_YEAR, Constants.DECEMBER, orderDate);
    }

    private void validateOrderDate(int orderDate) {
        YearMonth yearMonth = YearMonth.of(Constants.CURRENT_YEAR, Constants.DECEMBER);
        if (!yearMonth.isValidDay(orderDate)) {
            throw new InvalidDateException();
        }
    }

    private void validateOrderItem(OrderItem orderItem) {
        if (orderItems.contains(orderItem)) {
            throw new InvalidOrderException();
        }
    }

    public void addOrderItem(OrderItem orderItem) {
        validateOrderItem(orderItem);
        orderItems.add(orderItem);
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public int calculateTotalAmount() {
        return orderItems.stream()
                .mapToInt(item -> item.getMenu().getPrice() * item.getQuantity())
                .sum();
    }
}
