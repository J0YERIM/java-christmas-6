package christmas.domain.discount;

import christmas.domain.menu.MenuCategory;
import christmas.domain.order.Order;
import christmas.util.Constants;
import christmas.util.DateUtils;
import java.time.LocalDate;

/**
 * 평일 할인 정책을 나타내는 클래스입니다.
 */
public class WeekdayDiscount extends DiscountPolicy {

    public WeekdayDiscount() {
        super(LocalDate.of(Constants.CURRENT_YEAR, Constants.DECEMBER, Constants.START_DAY),
                LocalDate.of(Constants.CURRENT_YEAR, Constants.DECEMBER, Constants.END_DAY));
    }

    @Override
    public int calculateDiscountAmount(Order order) {
        return order.getOrderItems().stream()
                .filter(item -> item.getMenu().getCategory() == MenuCategory.DESSERT)
                .mapToInt(item -> item.getQuantity() * Constants.WEEKDAY_DISCOUNT_AMOUNT)
                .sum();
    }

    @Override
    public boolean isSpecificDiscountable(Order order) {
        return !DateUtils.isWeekend(order.getOrderDate());
    }

    @Override
    public String toString() {
        return "평일 할인";
    }
}
