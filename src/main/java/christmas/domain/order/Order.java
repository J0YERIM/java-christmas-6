package christmas.domain.order;

import christmas.exception.InvalidDateException;
import christmas.util.Constants;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 * 고객의 전체 주문을 나타내는 클래스입니다.
 */
public class Order {

    private final LocalDate orderDate;
    private final List<OrderItem> orderItems = new ArrayList<>();

    public Order(int orderDate) {
        validateOrderDate(orderDate);
        this.orderDate = convertToDate(orderDate);
    }

    private void validateOrderDate(int orderDate) {
        YearMonth yearMonth = YearMonth.of(Constants.CURRENT_YEAR, Constants.DECEMBER);
        if (!yearMonth.isValidDay(orderDate)) {
            throw new InvalidDateException();
        }
    }

    private LocalDate convertToDate(int orderDate) {
        return LocalDate.of(Constants.CURRENT_YEAR, Constants.DECEMBER, orderDate);
    }

    private void validateOrderItem(OrderItem orderItem) {
        // TODO: 주문 상품이 해당 주문에 추가 가능한지 검증하는 로직을 구현합니다.
    }

    public void isAddableOrderItem(OrderItem orderItem) {
        validateOrderItem(orderItem);
    }
}
