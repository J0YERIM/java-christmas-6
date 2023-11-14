package christmas.domain.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 고객의 전체 주문을 나타내는 클래스입니다.
 */
public class Order {

    private final LocalDate orderDate;
    private final List<OrderItem> orderItems = new ArrayList<>();

    public Order(LocalDate orderDate) {
        validateOrderDate(orderDate);
        this.orderDate = orderDate;;
    }

    private void validateOrderDate(LocalDate orderDate) {
        // TODO: 주문 날짜가 유효한지 검증하는 로직을 구현합니다.
    }

    private void validateOrderItem(OrderItem orderItem) {
        // TODO: 주문 상품이 해당 주문에 추가 가능한지 검증하는 로직을 구현합니다.
    }

    public void isAddableOrderItem(OrderItem orderItem) {
        validateOrderItem(orderItem);
    }
}
