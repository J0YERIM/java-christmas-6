package christmas.domain.discount;

import christmas.domain.order.Order;
import java.time.LocalDate;
import java.util.List;

/**
 * 할인 정책을 나타내는 추상 클래스입니다.
 */
public abstract class DiscountPolicy {

    protected LocalDate startDate;
    protected LocalDate endDate;

    public DiscountPolicy(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * 주문에 적용할 할인 금액을 계산합니다.
     * @param order 주문 객체
     * @return 할인 금액
     */
    public abstract int calculateDiscountAmount(Order order);

    /**
     * 주문이 할인 정책에 적합한지 확인합니다.
     * @param order 주문 객체
     * @return 할인 가능 여부
     */
    public abstract boolean isDiscountable(Order order);
}
