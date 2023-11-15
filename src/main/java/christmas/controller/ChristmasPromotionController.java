package christmas.controller;

import christmas.domain.order.Order;
import christmas.exception.InvalidDateException;
import christmas.exception.InvalidOrderException;
import christmas.service.DiscountService;
import christmas.service.OrderService;
import christmas.view.InputView;
import christmas.view.OutputView;

/**
 * 크리스마스 프로모션 이벤트의 메인 컨트롤러입니다.
 */
public class ChristmasPromotionController {

    private final OrderService orderService;
    private final DiscountService discountService;

    public ChristmasPromotionController(OrderService orderService,
            DiscountService discountService) {
        this.orderService = orderService;
        this.discountService = discountService;
    }

    public void run() {
        OutputView.printWelcomeMessage();
        Order order = processOrder();
        displayPreview(order);
        displayOrderDetails(order);
        displayDiscounts(order);
        displayFinalResult(order);
    }

    private Order processOrder() {
        int visitDate = getValidVisitDate();
        return createOrderWithValidItems(visitDate);
    }

    private int getValidVisitDate() {
        while (true) {
            try {
                return InputView.inputVisitDate();
            } catch (InvalidDateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Order createOrderWithValidItems(int visitDate) {
        while (true) {
            try {
                String orderItemsString = InputView.inputOrderItems();
                return orderService.processOrder(visitDate, orderItemsString);
            } catch (InvalidOrderException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void displayPreview(Order order) {
        OutputView.printPreviewMessage(order.getOrderDate());
    }

    private void displayOrderDetails(Order order) {
        OutputView.printOrderDetails(order.getOrderItems());
        OutputView.printTotalPriceBeforeDiscount(orderService.calculateTotalAmount(order));
    }

    private void displayDiscounts(Order order) {
        OutputView.printGift(discountService.getGiftEvent(order));
        OutputView.printDiscountDetails(discountService.getDiscountDetails(order));
        OutputView.printTotalBenefitAmount(discountService.calculateTotalBenefitAmount(order));
    }

    private void displayFinalResult(Order order) {
        OutputView.printTotalPriceAfterDiscount(orderService.calculatePayAmount(order));
        OutputView.printBadge(discountService.determineBadgeForOrder(order));
    }
}
