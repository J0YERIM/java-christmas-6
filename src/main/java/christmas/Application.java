package christmas;

import christmas.config.ChristmasConfig;
import christmas.controller.ChristmasPromotionController;
import christmas.service.DiscountService;
import christmas.service.OrderService;

public class Application {

    public static void main(String[] args) {
        ChristmasConfig config = new ChristmasConfig();
        DiscountService discountService = config.createDiscountService();
        OrderService orderService = config.createOrderService(discountService);

        ChristmasPromotionController controller = new ChristmasPromotionController(orderService,
                discountService);
        controller.run();
    }
}
