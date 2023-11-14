package christmas.service;

import christmas.domain.discount.DiscountPolicy;
import christmas.domain.order.Order;
import java.util.List;

/**
 * 할인 정책과 관련된 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
public class DiscountService {

    private List<DiscountPolicy> discountPolicies;

    public DiscountService(List<DiscountPolicy> discountPolicies) {
        this.discountPolicies = discountPolicies;
    }

    public List<DiscountPolicy> findAvailableDiscountPolicies(Order order) {
        // TODO: 주문에 적용할 수 있는 모든 할인 정책을 순차적으로 검사하고, 해당되는 정책들을 리스트로 반환
        return null;
    }

    public int calculateDiscountAmountForPolicy(Order order, DiscountPolicy discountPolicy) {
        // TODO: 주어진 할인 정책에 따라 주문에 적용될 할인 금액을 계산하여 반환
        return 0;
    }

    public int calculateTotalDiscountAmount(Order order, List<DiscountPolicy> discountPolicies) {
        // TODO: 주어진 주문에 적용 가능한 모든 할인 정책을 순차적으로 검사하고, 총 할인 금액을 계산하여 반환
        return 0;
    }
}
