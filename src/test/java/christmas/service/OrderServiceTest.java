package christmas.service;

import static org.junit.jupiter.api.Assertions.*;

import christmas.exception.InvalidDateException;
import christmas.exception.InvalidOrderException;
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
    @DisplayName("유효한 날짜와 주문 항목으로 주문 생성이 가능함")
    void processOrderWithValidInput() {
        int validDay = 15; // 12월의 유효한 날짜
        String validOrderItemsString = "해산물파스타-2,레드와인-1"; // 유효한 주문 항목 문자열
        assertDoesNotThrow(() -> orderService.processOrder(validDay, validOrderItemsString));
    }

    @Test
    @DisplayName("유효하지 않은 날짜 입력 시 InvalidDateException 발생")
    void processOrderWithInvalidDate() {
        int invalidDay = 32; // 12월의 유효하지 않은 날짜
        String validOrderItemsString = "해산물파스타-2,레드와인-1"; // 유효한 주문 항목 문자열
        IllegalArgumentException thrown = assertThrows(InvalidDateException.class,
                () -> orderService.processOrder(invalidDay, validOrderItemsString));
        assertEquals("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.", thrown.getMessage());
    }

    @Test
    @DisplayName("잘못된 메뉴 문자열 입력 시 InvalidOrderException 발생")
    void processOrderWithInvalidMenuString() {
        int validDay = 15; // 12월의 유효한 날짜
        String invalidOrderItemsString = "잘못된메뉴-2"; // 유효하지 않은 주문 항목 문자열
        InvalidOrderException thrown = assertThrows(InvalidOrderException.class,
                () -> orderService.processOrder(validDay, invalidOrderItemsString));
        assertEquals("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.", thrown.getMessage());
    }

    @Test
    @DisplayName("중복된 메뉴 입력 시 InvalidOrderException 발생")
    void processOrderWithDuplicateMenuItems() {
        int validDay = 15; // 유효한 날짜
        String duplicateOrderItemsString = "해산물파스타-2,해산물파스타-1"; // 중복된 메뉴
        InvalidOrderException thrown = assertThrows(InvalidOrderException.class,
                () -> orderService.processOrder(validDay, duplicateOrderItemsString));
        assertEquals("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.", thrown.getMessage());
    }

    @Test
    @DisplayName("메뉴 수량이 1 미만일 경우 InvalidOrderException 발생")
    void processOrderWithInvalidQuantity() {
        int validDay = 15; // 유효한 날짜
        String invalidQuantityString = "해산물파스타-0"; // 수량이 1 미만
        InvalidOrderException thrown = assertThrows(InvalidOrderException.class,
                () -> orderService.processOrder(validDay, invalidQuantityString));
        assertEquals("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.", thrown.getMessage());
    }

    @Test
    @DisplayName("주문 형식이 잘못되었을 경우 InvalidOrderException 발생")
    void processOrderWithInvalidFormat() {
        int validDay = 15; // 유효한 날짜
        String invalidFormatString = "해산물파스타"; // 올바르지 않은 형식
        InvalidOrderException thrown = assertThrows(InvalidOrderException.class,
                () -> orderService.processOrder(validDay, invalidFormatString));
        assertEquals("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.", thrown.getMessage());
    }
}