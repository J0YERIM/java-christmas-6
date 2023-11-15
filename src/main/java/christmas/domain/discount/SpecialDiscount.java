package christmas.domain.discount;

import christmas.domain.order.Order;
import christmas.util.Constants;
import christmas.util.DateUtils;
import java.time.LocalDate;

/**
 * 특별 할인 정책을 나타내는 클래스입니다.
 */
public class SpecialDiscount extends DiscountPolicy {

    public SpecialDiscount() {
        super(LocalDate.of(Constants.CURRENT_YEAR, Constants.DECEMBER, Constants.START_DAY),
                LocalDate.of(Constants.CURRENT_YEAR, Constants.DECEMBER, Constants.END_DAY));
    }

    @Override
    public int calculateDiscountAmount(Order order) {
        return Constants.SPECIAL_DISCOUNT_AMOUNT;
    }

    @Override
    public boolean isSpecificDiscountable(Order order) {
        return DateUtils.isSpecialDiscountDay(order.getOrderDate());
    }

    @Override
    public String toString() {
        return "특별 할인";
    }
}
