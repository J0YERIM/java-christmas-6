package christmas.exception;

public class InvalidOrderException extends IllegalArgumentException {

    private static final String INVALID_ORDER_MESSAGE = "유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public InvalidOrderException() {
        super("[ERROR] " + INVALID_ORDER_MESSAGE);
    }

    public InvalidOrderException(String message) {
        super("[ERROR] " + message);
    }
}
