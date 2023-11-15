package christmas.config;

import christmas.domain.discount.ChristmasCountdownDiscount;
import christmas.domain.discount.DiscountPolicy;
import christmas.domain.discount.GiftEvent;
import christmas.domain.discount.SpecialDiscount;
import christmas.domain.discount.WeekdayDiscount;
import christmas.domain.discount.WeekendDiscount;
import christmas.service.DiscountService;
import christmas.service.OrderService;
import java.util.List;

public class ChristmasConfig {

    public OrderService createOrderService(DiscountService discountService) {
        return new OrderService(discountService);
    }

    public DiscountService createDiscountService() {
        List<DiscountPolicy> discountPolicies = createDiscountPolicies();
        DiscountPolicy giftEvent = createGiftEvent();
        return new DiscountService(discountPolicies, giftEvent);
    }

    private List<DiscountPolicy> createDiscountPolicies() {
        return List.of(
                new ChristmasCountdownDiscount(),
                new WeekdayDiscount(),
                new WeekendDiscount(),
                new SpecialDiscount()
        );
    }

    private DiscountPolicy createGiftEvent() {
        return new GiftEvent();
    }
}
