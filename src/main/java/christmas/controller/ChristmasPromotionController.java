package christmas.controller;

import christmas.domain.order.Order;
import christmas.exception.InvalidDateException;
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
        // TODO: 사용자 입력 받기
        Order order = inputVisitDate();
        // TODO: 주문 처리
        // TODO: 할인 처리
        // TODO: 결과 출력
    }

    private Order inputVisitDate() {
        while (true) {
            try {
                int day = InputView.inputVisitDate();
                return orderService.createOrder(day);
            } catch (InvalidDateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputOrder() {
        // TODO: InputView를 통해 사용자로부터 주문을 입력받는다.
    }

    private void processOrder() {
        // TODO: OrderService를 통해 주문을 처리한다.
    }

    private void processDiscount() {
        // TODO: DiscountService를 통해 할인을 처리한다.
    }

    private void displayResult() {
        // TODO: OutputView를 통해 결과를 출력한다.
    }
}
