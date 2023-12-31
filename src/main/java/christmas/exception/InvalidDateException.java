package christmas.exception;

public class InvalidDateException extends IllegalArgumentException {

    private static final String INVALID_DATE_MESSAGE = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public InvalidDateException() {
        super("[ERROR] " + INVALID_DATE_MESSAGE);
    }

    public InvalidDateException(String message) {
        super("[ERROR] " + message);
    }
}
