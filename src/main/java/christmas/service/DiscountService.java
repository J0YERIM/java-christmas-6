package christmas.service;

import christmas.domain.discount.DiscountPolicy;
import christmas.domain.discount.GiftEvent;
import christmas.domain.order.Order;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 할인 정책과 관련된 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
public class DiscountService {

    private final List<DiscountPolicy> discountPolicies;

    public DiscountService(List<DiscountPolicy> discountPolicies) {
        this.discountPolicies = discountPolicies;
    }

    public List<DiscountPolicy> findAvailableDiscountPolicies(Order order) {
        return discountPolicies.stream()
                .filter(policy -> policy.calculateDiscountAmountIfDiscountable(order) > 0)
                .collect(Collectors.toList());
    }

    public int calculateDiscountAmountForPolicy(Order order, DiscountPolicy discountPolicy) {
        return discountPolicy.calculateDiscountAmountIfDiscountable(order);
    }

    // 총 할인 금액 계산 로직 구현
    public int calculateTotalDiscountAmount(Order order) {
        return discountPolicies.stream()
                .mapToInt(policy -> calculateDiscountAmountForPolicy(order, policy))
                .sum();
    }

    // 총 혜택 금액 계산 로직 구현
    public int calculateTotalBenefitAmount(Order order) {
        return calculateTotalDiscountAmount(order) + discountPolicies.stream()
                .filter(policy -> policy instanceof GiftEvent)
                .mapToInt(policy -> calculateDiscountAmountForPolicy(order, policy))
                .findFirst()
                .orElse(0);
    }

    // TODO: 이벤트 배지 부여 로직 구현
}
