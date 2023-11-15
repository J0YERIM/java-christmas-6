package christmas.domain.discount;

import christmas.domain.order.Order;
import christmas.util.Constants;
import java.time.LocalDate;

/**
 * 증정 이벤트를 나타내는 클래스입니다.
 */
public class GiftEvent extends DiscountPolicy {

    public GiftEvent() {
        super(LocalDate.of(Constants.CURRENT_YEAR, Constants.DECEMBER, Constants.START_DAY),
                LocalDate.of(Constants.CURRENT_YEAR, Constants.DECEMBER, Constants.END_DAY));
    }

    @Override
    public int calculateDiscountAmount(Order order) {
        return Constants.GIFT_EVENT_DISCOUNT_AMOUNT;
    }

    @Override
    public boolean isSpecificDiscountable(Order order) {
        return order.calculateTotalAmount() >= Constants.GIFT_EVENT_STANDARD_AMOUNT;
    }

    @Override
    public String toString() {
        return "증정 이벤트";
    }
}
