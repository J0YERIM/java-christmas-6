package christmas.service;

import christmas.domain.order.Order;

/**
 * 주문 관련 비즈니스 로직을 담당하는 클래스입니다.
 */
public class OrderService {

    public Order createOrderFromString(String orderString) {
        // TODO: 주문 문자열을 파싱하여 Order 객체를 생성하는 로직을 구현합니다.
        // Service 계층에 적절한지 검토
        return null;
    }

    public int calculateTotalAmount(Order order) {
        // TODO: 주문의 총 금액을 계산하는 로직을 구현합니다.
        return 0;
    }

    public int calculateTotalDiscountAmount(Order order) {
        // TODO: DiscountService를 이용하여 주문의 총 할인 금액을 계산하는 로직을 구현합니다.
        return 0;
    }

    public int calculatePayAmount(Order order) {
        // TODO: 총 주문 금액에서 총 할인 금액을 뺀 최종 결제 금액을 계산하는 로직을 구현합니다.
        return 0;
    }
}
