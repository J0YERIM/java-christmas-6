package christmas.domain.discount;

import christmas.domain.order.Order;
import java.time.LocalDate;

public class WeekendDiscount extends DiscountPolicy {

    public WeekendDiscount(LocalDate startDate, LocalDate endDate) {
        super(startDate, endDate);
    }

    @Override
    public int calculateDiscountAmount(Order order) {
        // TODO: 할인 금액을 계산하는 로직을 구현합니다.
        return 0;
    }

    @Override
    public boolean isDiscountable(Order order) {
        // TODO: 할인 가능한지 검증하는 로직을 구현합니다.
        return false;
    }
}
