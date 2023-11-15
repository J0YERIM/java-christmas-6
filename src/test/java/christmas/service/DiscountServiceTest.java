package christmas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.badge.Badge;
import christmas.domain.discount.ChristmasCountdownDiscount;
import christmas.domain.discount.DiscountPolicy;
import christmas.domain.discount.GiftEvent;
import christmas.domain.discount.SpecialDiscount;
import christmas.domain.discount.WeekdayDiscount;
import christmas.domain.discount.WeekendDiscount;
import christmas.domain.menu.Menu;
import christmas.domain.order.Order;
import christmas.domain.order.OrderItem;
import christmas.util.Constants;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountServiceTest {

    private DiscountService discountService;
    private Order testOrder;

    @BeforeEach
    void setUp() {
        List<DiscountPolicy> discountPolicies = List.of(
                new ChristmasCountdownDiscount(),
                new WeekdayDiscount(),
                new WeekendDiscount(),
                new SpecialDiscount()
        );
        discountService = new DiscountService(discountPolicies, new GiftEvent());

        testOrder = new Order(3);
        testOrder.addOrderItem(new OrderItem(Menu.T_BONE_STEAK, 1));
        testOrder.addOrderItem(new OrderItem(Menu.BBQ_RIPS, 1));
        testOrder.addOrderItem(new OrderItem(Menu.CHOCOLATE_CAKE, 2));
        testOrder.addOrderItem(new OrderItem(Menu.ZERO_COLA, 1));
    }

    @Test
    @DisplayName("크리스마스 디데이 할인이 올바르게 계산되는지 확인")
    void testChristmasCountdownDiscount() {

        DiscountPolicy christmasCountdown = new ChristmasCountdownDiscount();
        int discountAmount = christmasCountdown.calculateDiscountAmountIfDiscountable(testOrder);

        int expectedDiscount = 1200;
        assertEquals(expectedDiscount, discountAmount);
    }

    @Test
    @DisplayName("평일 디저트 할인이 올바르게 계산되는지 확인")
    void testWeekdayDiscount() {
        DiscountPolicy weekdayDiscount = new WeekdayDiscount();
        int discountAmount = weekdayDiscount.calculateDiscountAmountIfDiscountable(testOrder);

        assertEquals(Constants.WEEKDAY_DISCOUNT_AMOUNT * 2, discountAmount);
    }

    @Test
    @DisplayName("주말 메인 메뉴 할인이 올바르게 계산되는지 확인")
    void testWeekendDiscount() {
        DiscountPolicy weekendDiscount = new WeekendDiscount();
        int discountAmount = weekendDiscount.calculateDiscountAmountIfDiscountable(testOrder);

        assertEquals(0, discountAmount);
    }

    @Test
    @DisplayName("특별 할인이 올바르게 계산되는지 확인")
    void testSpecialDiscount() {
        DiscountPolicy specialDiscount = new SpecialDiscount();
        int discountAmount = specialDiscount.calculateDiscountAmountIfDiscountable(testOrder);

        assertEquals(Constants.SPECIAL_DISCOUNT_AMOUNT, discountAmount);
    }

    @Test
    @DisplayName("증정 이벤트가 올바르게 적용되는지 확인")
    void testGiftEvent() {
        DiscountPolicy giftEvent = new GiftEvent();
        int discountAmount = giftEvent.calculateDiscountAmountIfDiscountable(testOrder);

        assertEquals(Constants.GIFT_EVENT_DISCOUNT_AMOUNT, discountAmount);
    }

    @Test
    @DisplayName("총 혜택 금액이 올바르게 계산되는지 확인")
    void testCalculateTotalDiscountAmount() {
        int totalBenefitAmount = discountService.calculateTotalBenefitAmount(testOrder);
        int expectedDiscount = 31246;
        assertEquals(expectedDiscount, totalBenefitAmount);
    }

    @Test
    @DisplayName("해당 주문의 배지가 올바르게 계산되는지 확인")
    void testDetermineBadgeForOrder() {
        Badge badge = discountService.determineBadgeForOrder(testOrder);
        assertEquals(Badge.SANTA, badge);
    }
}