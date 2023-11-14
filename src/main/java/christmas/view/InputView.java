package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.exception.InvalidDateException;

public class InputView {

    public static int inputVisitDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new InvalidDateException();
        }
    }

    public static String inputOrderItems() {
        // TODO: 사용자로부터 주문 항목을 입력받는 로직을 구현한다.
        return null;
    }
}
