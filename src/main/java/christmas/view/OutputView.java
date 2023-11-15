package christmas.view;

import christmas.domain.badge.Badge;
import christmas.domain.order.OrderItem;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class OutputView {

    private static final NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);

    public static void printWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printPreviewMessage(LocalDate visitDate) {
        System.out.println(visitDate.getMonth() + "월 " + visitDate.getDayOfMonth()
                + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void printOrderDetails(Set<OrderItem> orderItems) {
        System.out.println("<주문 메뉴>");
        orderItems.forEach(item -> System.out.println(
                item.getMenu().getName() + " " + item.getQuantity() + "개"));
    }

    public static void printTotalPriceBeforeDiscount(int totalPriceBeforeDiscount) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(formatNumber(totalPriceBeforeDiscount) + "원");
    }

    public static void printGift(String gift) {
        System.out.println("<증정 메뉴>");
        if (gift.isEmpty()) {
            System.out.println("없음");
            return;
        }
        System.out.println(gift);
    }

    public static void printDiscountDetails(Map<String, Integer> discountDetails) {
        System.out.println("<혜택 내역>");
        if (discountDetails.isEmpty()) {
            System.out.println("없음");
            return;
        }
        discountDetails.forEach((detail, amount) -> System.out.println(
                detail + " : -" + formatNumber(amount) + "원"));
    }

    public static void printTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println("<총혜택 금액>");
        System.out.println("-" + formatNumber(totalBenefitAmount) + "원");
    }

    public static void printTotalPriceAfterDiscount(int totalPriceAfterDiscount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(formatNumber(totalPriceAfterDiscount) + "원");
    }

    public static void printBadge(Badge badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }

    private static String formatNumber(int number) {
        return numberFormat.format(number);
    }
}
