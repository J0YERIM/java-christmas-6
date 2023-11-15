package christmas.domain.discount;

import christmas.domain.menu.MenuCategory;
import christmas.domain.order.Order;
import christmas.util.Constants;
import christmas.util.DateUtils;
import java.time.LocalDate;

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

    protected abstract int calculateDiscountAmount(Order order);

    protected abstract boolean isSpecificDiscountable(Order order);

    protected boolean isWithinDiscountPeriod(LocalDate date) {
        return DateUtils.isWithinPeriod(date, startDate, endDate);
    }

    protected boolean isCommonDiscountable(Order order) {
        return order.calculateTotalAmount() >= Constants.MINIMUM_ORDER_AMOUNT_FOR_DISCOUNT
                && order.getOrderItems().stream()
                .anyMatch(item -> item.getMenu().getCategory() != MenuCategory.DRINK)
                && order.getOrderItems().size() <= Constants.MAXIMUM_ORDER_ITEM_COUNT;
    }

    public int calculateDiscountAmountIfDiscountable(Order order) {
        if (isWithinDiscountPeriod(order.getOrderDate()) && isCommonDiscountable(order)
                && isSpecificDiscountable(order)) {
            return calculateDiscountAmount(order);
        }
        return Constants.ZERO;
    }
}
