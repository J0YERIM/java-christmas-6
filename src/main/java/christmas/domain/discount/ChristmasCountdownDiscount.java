package christmas.domain.discount;

import christmas.domain.order.Order;
import christmas.util.Constants;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 크리스마스 디데이 할인 정책을 나타내는 클래스입니다.
 */
public class ChristmasCountdownDiscount extends DiscountPolicy {

    public ChristmasCountdownDiscount() {
        super(LocalDate.of(Constants.CURRENT_YEAR, Constants.DECEMBER, Constants.START_DAY),
                LocalDate.of(Constants.CURRENT_YEAR, Constants.DECEMBER, Constants.CHRISTMAS_DAY));
    }

    @Override
    protected int calculateDiscountAmount(Order order) {
        long daysFromStart = ChronoUnit.DAYS.between(startDate, order.getOrderDate());
        return Constants.CHRISTMAS_DISCOUNT_START_AMOUNT
                + Constants.CHRISTMAS_DISCOUNT_INCREMENT_AMOUNT * (int) daysFromStart;
    }

    @Override
    protected boolean isSpecificDiscountable(Order order) {
        return true;
    }

    @Override
    public String toString() {
        return "크리스마스 디데이 할인";
    }
}
