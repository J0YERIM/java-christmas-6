package christmas.controller;

import christmas.domain.order.Order;
import christmas.exception.InvalidDateException;
import christmas.exception.InvalidOrderException;
import christmas.service.DiscountService;
import christmas.service.OrderService;
import christmas.view.InputView;

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
        Order order = processOrder();
        processDiscount();
        displayResult();
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

    private void processDiscount() {
        // TODO: DiscountService를 통해 할인을 처리한다.
    }

    private void displayResult() {
        // TODO: OutputView를 통해 결과를 출력한다.
    }
}
