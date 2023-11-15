package christmas.service;

import christmas.domain.badge.Badge;
import christmas.domain.discount.DiscountPolicy;
import christmas.domain.order.Order;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return Badge.fromAmount(totalBenefitAmount);
    }

    public String getGiftEvent(Order order) {
        if (giftEventPolicy.calculateDiscountAmountIfDiscountable(order) > 0) {
            return "샴페인 1개";
        }
        return "없음";
    }

    public Map<String, Integer> getDiscountDetails(Order order) {
        Map<String, Integer> discountDetails = new HashMap<>();
        addPolicyDiscountDetails(discountDetails, order, discountPolicies);
        addPolicyDiscountDetails(discountDetails, order, List.of(giftEventPolicy));
        return discountDetails;
    }

    private void addPolicyDiscountDetails(Map<String, Integer> details, Order order, List<DiscountPolicy> policies) {
        policies.forEach(policy -> {
            int discountAmount = policy.calculateDiscountAmountIfDiscountable(order);
            if (discountAmount > 0) {
                details.put(policy.toString(), discountAmount);
            }
        });
    }
}
