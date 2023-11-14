package christmas.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderService();
    }

    @Test
    @DisplayName("유효한 날짜로 주문을 생성할 수 있다.")
    void createOrderWithValidDate() {
        int validDay = 15; // 12월의 유효한 날짜
        assertDoesNotThrow(() -> orderService.createOrder(validDay));
    }

    @Test
    @DisplayName("1보다 작은 날짜로 주문을 생성할 수 없다.")
    void createOrderWithInvalidDateLessThan1() {
        int invalidDay = 0; // 12월의 유효하지 않은 날짜 (0일)
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> orderService.createOrder(invalidDay));
        assertEquals("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.", thrown.getMessage());
    }

    @Test
    @DisplayName("31보다 큰 날짜로 주문을 생성할 수 없다.")
    void createOrderWithInvalidDateMoreThan31() {
        int invalidDay = 32; // 12월의 유효하지 않은 날짜 (32일)
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> orderService.createOrder(invalidDay));
        assertEquals("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.", thrown.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닌 날짜로 주문을 생성할 수 없다.")
    void createOrderWithInvalidDateNotNumber() {
        String invalidDay = "abc"; // 12월의 유효하지 않은 날짜 (숫자가 아닌 문자열)
        assertThrows(IllegalArgumentException.class, () -> orderService.createOrder(Integer.parseInt(invalidDay)));
    }
}