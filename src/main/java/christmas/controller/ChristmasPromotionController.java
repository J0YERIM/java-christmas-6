package christmas.controller;

import christmas.service.DiscountService;
import christmas.service.OrderService;

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

    // TODO: Controller의 로직이 복잡해지거나, Service 계층에 다른 Service를 주입해야 할 경우, 파사드 패턴을 고려합니다.
    public void run() {
        // TODO: 사용자 입력 받기
        // TODO: 주문 처리
        // TODO: 할인 처리
        // TODO: 결과 출력
    }

    private void inputDate() {
        // TODO: InputView를 통해 사용자로부터 날짜를 입력받는다.
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
