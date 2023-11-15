package christmas.domain.discount;

import christmas.domain.menu.MenuCategory;
import christmas.domain.order.Order;
import christmas.util.Constants;
import christmas.util.DateUtils;
import java.time.LocalDate;

public class WeekendDiscount extends DiscountPolicy {

    public WeekendDiscount() {
        super(LocalDate.of(Constants.CURRENT_YEAR, Constants.DECEMBER, Constants.START_DAY),
                LocalDate.of(Constants.CURRENT_YEAR, Constants.DECEMBER, Constants.END_DAY));
    }

    @Override
    public int calculateDiscountAmount(Order order) {
        return order.getOrderItems().stream()
                .filter(item -> item.getMenu().getCategory() == MenuCategory.MAIN_DISH)
                .mapToInt(item -> item.getQuantity() * Constants.WEEKEND_DISCOUNT_AMOUNT)
                .sum();
    }

    @Override
    public boolean isSpecificDiscountable(Order order) {
        return DateUtils.isWeekend(order.getOrderDate());
    }
}
