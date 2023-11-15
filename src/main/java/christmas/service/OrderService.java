package christmas.service;

import christmas.domain.menu.Menu;
import christmas.domain.order.Order;
import christmas.domain.order.OrderItem;
import christmas.exception.InvalidOrderException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 주문 관련 비즈니스 로직을 담당하는 클래스입니다.
 */
public class OrderService {

    private final DiscountService discountService;

    public OrderService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public Order processOrder(int day, String orderItemsString) {
        Order order = createOrder(day);
        List<OrderItem> orderItems = parseOrderItems(orderItemsString);
        orderItems.forEach(order::addOrderItem);
        return order;
    }

    public int calculateTotalAmount(Order order) {
        return order.calculateTotalAmount();
    }

    public int calculatePayAmount(Order order) {
        return calculateTotalAmount(order) - discountService.calculateTotalDiscountAmount(order);
    }

    private List<OrderItem> parseOrderItems(String orderItemsString) {
        return Arrays.stream(orderItemsString.split(","))
                .map(this::parseOrderItem)
                .collect(Collectors.toList());
    }

    private OrderItem parseOrderItem(String orderItemString) {
        String[] itemInfo = orderItemString.split("-");
        validateOrderItemFormat(itemInfo);
        Menu menu = parseMenu(itemInfo[0].trim());
        int quantity = parseQuantity(itemInfo[1].trim());
        return new OrderItem(menu, quantity);
    }

    private Menu parseMenu(String menuName) {
        return Menu.findByName(menuName)
                .orElseThrow(InvalidOrderException::new);
    }

    private int parseQuantity(String quantityString) {
        try {
            return Integer.parseInt(quantityString);
        } catch (NumberFormatException e) {
            throw new InvalidOrderException();
        }
    }

    private void validateOrderItemFormat(String[] itemInfo) {
        if (itemInfo.length != 2 || itemInfo[0].trim().isEmpty() || itemInfo[1].trim().isEmpty()) {
            throw new InvalidOrderException();
        }
    }

    private Order createOrder(int day) {
        return new Order(day);
    }
}
