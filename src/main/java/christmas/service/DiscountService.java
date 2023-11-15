package christmas.service;

import christmas.domain.badge.Badge;
import christmas.domain.discount.DiscountPolicy;
import christmas.domain.order.Order;
import java.util.List;

/**
 * 할인 정책과 관련된 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
public class DiscountService {

    private final List<DiscountPolicy> discountPolicies;
    private final DiscountPolicy giftEventPolicy;

    public DiscountService(List<DiscountPolicy> discountPolicies, DiscountPolicy giftEventPolicy) {
        this.discountPolicies = discountPolicies;
        this.giftEventPolicy = giftEventPolicy;
    }

    public int calculateTotalDiscountAmount(Order order) {
        return discountPolicies.stream()
                .mapToInt(policy -> policy.calculateDiscountAmountIfDiscountable(order))
                .sum();
    }

    public int calculateTotalBenefitAmount(Order order) {
        int totalDiscountAmount = calculateTotalDiscountAmount(order);
        int giftEventAmount = giftEventPolicy.calculateDiscountAmountIfDiscountable(order);
        return totalDiscountAmount + giftEventAmount;
    }

    public Badge determineBadgeForOrder(Order order) {
        int totalBenefitAmount = calculateTotalBenefitAmount(order);
        return Badge.getBadgeForTotalBenefitAmount(totalBenefitAmount);
    }
}
