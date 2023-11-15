## 크리스마스 프로모션 기능 목록

- [x] **날짜 입력 기능**
    - [x] 사용자에게 12월 중 방문 예정 날짜를 숫자로 입력받음
    - [x] 입력된 날짜가 1 이상 31 이하인지 검증
    - [x] 유효하지 않은 날짜 입력 시 "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." 오류 메시지 출력 후 재입력 요청

- [x] **메뉴 주문 입력 기능**
    - [x] 사용자에게 메뉴명-수량 형식으로 주문 입력 받음
    - [x] 메뉴판에 없는 메뉴 입력 시 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 오류 메시지 출력
    - [x] 메뉴의 개수가 1 이상이 아닐 경우 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 오류 메시지 출력
    - [x] 입력 형식이 올바르지 않을 경우 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 오류 메시지 출력
    - [x] 중복된 메뉴 입력 시 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 오류 메시지 출력

- [x] **할인 및 증정 계산 기능**
    - [x] 날짜별 '크리스마스 디데이 할인' 계산
    - [x] 평일 및 주말에 따른 할인 계산 (디저트 평일 할인, 메인 주말 할인)
    - [x] 특별 할인(달력 별 표시 날짜) 여부 확인 및 적용
    - [x] 총주문 금액이 12만 원 이상일 경우 샴페인 증정 여부 계산

- [x] **결제 금액 계산 기능**
    - [x] 할인 전 총주문 금액 계산
    - [x] 총혜택 금액 계산 (할인 금액의 합계 + 증정 메뉴 가격)
    - [x] 할인 후 예상 결제 금액 계산

- [x] **이벤트 배지 부여 기능**
    - [x] 총혜택 금액에 따라 별, 트리, 산타 중 하나의 이벤트 배지 부여

- [ ] **결과 출력 기능**
    - [ ] 주문한 메뉴와 수량 출력
    - [ ] 할인 전 총주문 금액, 증정 메뉴, 혜택 내역, 총혜택 금액, 할인 후 예상 결제 금액 출력
    - [ ] 부여된 이벤트 배지 정보 출력

- [x] **예외 처리 및 유효성 검사**
    - [x] 모든 사용자 입력에 대한 예외 처리 및 유효성 검증
        - [x] 총 주문 금액 10,000원 이상부터 이벤트가 적용됩니다.
        - [x] 음료만 주문 시, 주문할 수 없습니다.
        - [x] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.
    - [x] 잘못된 입력에 대한 오류 메시지 출력 후 재입력 요청

---

## 크리스마스 프로모션 디렉토리 구조

```
src
├── main
│   ├── java
│   │   ├── christmas
│   │   │   ├── controller
│   │   │   ├── domain
│   │   │   ├── service
│   │   │   ├── util
│   │   │   ├── view
│   │   │   └── Application.java
│   └── resources
└── test
    └── java
    ... (생략)
```

---

## 각 패키지 및 클래스의 역할과 책임

### controller
- `ChristmasPromotionController.java` (class)
    - 설명: 크리스마스 프로모션 이벤트의 메인 컨트롤러입니다.
    - 책임 및 역할
        - 사용자 입력을 처리하고, 적절한 서비스 계층의 메소드를 호출합니다.
        - 처리 결과를 OutputView를 통해 사용자에게 출력합니다.
    - 필드
      - orderService(OrderService): 주문과 관련된 비즈니스 로직을 처리하는 서비스 계층
      - discountService(DiscountService): 할인 정책과 관련된 비즈니스 로직을 처리하는 서비스 계층
    - 메소드
      - run(): 전체적인 프로그램의 흐름을 제어합니다.
      - inputOrderDate(): InputView를 통해 주문 날짜를 입력받습니다.
      - inputOrderItems(): InputView를 통해 메뉴 주문을 입력받습니다.
      - processOrder(): 주문 처리를 위해 서비스 계층의 메소드를 호출합니다.
      - processDiscount(): 할인 처리를 위해 서비스 계층의 메소드를 호출합니다.
      - printResult(): 처리 결과를 출력합니다.

### domain
- `Menu.java` (enum)
    - 설명: 식당의 메뉴 항목 하나를 나타냅니다.
    - 필드: name(String), price(int), category(MenuCategory)
    - 책임 및 역할
        - 메뉴 항목의 이름, 가격, 카테고리를 관리합니다.
    - 메소드
      - 각 필드의 getter 메소드: 필요한지 검토 후 수정
    - 가정
        - 메뉴 항목의 이름과 가격은 변경되지 않습니다.
- `MenuCategory.java` (enum)
    - 설명: 식당 메뉴의 카테고리를 나타냅니다.
    - 필드: APPETIZER(에피타이저), MAIN_DISH(메인), DESSERT(디저트), BEVERAGE(음료)
    - 책임 및 역할
        - 메뉴 항목의 카테고리를 관리합니다.
- `Order.java` (class)
    - 설명: 고객의 전체 주문을 나타냅니다.
    - 필드
        - orderItems(List<OrderItem>): 주문한 메뉴와 수량을 관리합니다.
        - orderDate(LocalDate): 주문한 날짜를 관리합니다.
    - 책임 및 역할
        - 주문 날짜와 OrderItem 목록을 관리합니다.
        - 주문의 유효성 검사를 수행합니다.
    - 메소드
      - isAddableOrderItem(OrderItem orderItem): 주문에 메뉴 항목을 추가할 수 있는지 확인합니다.
      - validateOrderItems(): 주문 상품이 해당 주문에 추가 가능한지 검증합니다.
      - validateOrderDate(): 주문 날짜가 유효한지 검증합니다.
- `OrderItem.java` (class)
    - 설명: 주문의 개별 메뉴 항목과 수량을 나타냅니다.
    - 필드
        - menu(Menu): 주문한 메뉴 항목
        - quantity(int): 주문한 메뉴의 수량
    - 책임 및 역할
        - 주문에 대한 메뉴 항목과 수량을 관리합니다.
        - 주문 상품의 유효성 검사를 수행합니다.
    - 메소드
      - validateQuantity(): 주문 상품의 수량이 유효한지 검증합니다.
      - 각 필드의 getter 메소드: 필요한지 검토 후 수정
- `DiscountPolicy.java` (abstract class)
    - 설명: 할인 정책을 나타냅니다.
    - 책임 및 역할: 다양한 할인 정책 구현을 위한 메소드를 제공합니다.
    - 필드
        - startDate(LocalDate): 할인 정책의 시작 날짜
        - endDate(LocalDate): 할인 정책의 종료 날짜
    - 메소드
        - calculateDiscountAmount(Order order): 주문 금액을 받아 할인 금액을 계산합니다.
        - isDiscountable(Order order): 주문이 할인 정책에 적합한지 확인합니다.
- `ChristmasDayDiscount.java`, `WeekdayDiscount.java`, `WeekendDiscount.java`, `SpecialDiscount.java`,`GiftEvent.java` (class)
    - 설명: DiscountPolicy 추상 클래스를 상속하는 각각의 할인 정책 클래스입니다.
    - 책임 및 역할: 할인 정책에 따른 할인 금액을 계산합니다.
- `Badge.java` (enum)
    - 설명: 이벤트 참여자에게 배지의 종류를 제한된 값들 중 하나로 명확하게 정의합니다.
    - 필드
      - standard(int): 배지의 기준 금액
          - STAR(별): 5천 원 이상
          - TREE(트리): 1만원 이상
          - SANTA(산타): 2만원 이상
    - 책임 및 역할: 배지의 종류를 관리합니다.
    - 메소드
        - determineBadgeForAmount(int totalDiscountAmount): 총 할인 금액을 받아 배지의 종류를 반환합니다.

### service
- `OrderService.java` (class)
    - 설명: 주문과 관련된 비즈니스 로직을 처리합니다.
    - 책임 및 역할
        - 총 주문 금액을 계산합니다.
        - 총 할인 금액을 계산합니다.
        - 할인 후 예상 결제 금액을 계산합니다.
    - 메소드
        - createOrder(String orderString): 주문 문자열을 받아 Order 객체를 생성합니다.
- `DiscountService.java` (class)
    - 설명: 할인 정책과 관련된 비즈니스 로직을 처리합니다.
    - 책임 및 역할
        - 주문에 적용할 수 있는 할인 정책을 결정하고 적용합니다.
        - 각 할인 정책에 따른 할인 금액을 계산합니다.
    - 필드
        - discountPolicies(List<DiscountPolicy>): 할인 정책 목록
    - 메소드
      - createOrderFromString(String orderString): 주문 문자열을 받아 Order 객체를 생성합니다. -> Service 계층에 적절한지 검토
      - calculateTotalAmount(Order order): 주문을 받아 총 주문 금액을 계산합니다.
      - calculateTotalDiscountAmount(Order order): 주문을 받아 총 할인 금액을 계산합니다.
      - calculatePayAmount(Order order): 주문을 받아 할인 후 예상 결제 금액을 계산합니다.

### view
- `InputView.java` (class)
    - 설명: 사용자의 입력을 받습니다.
    - 책임 및 역할
        - 사용자의 입력을 받습니다.
        - 오류가 발생할 경우 오류 메시지를 출력하고 재입력을 요청합니다.
    - 메소드
      - inputVisitDate(): 방문 예정 날짜를 입력받습니다.
      - inputOrderItems(): 메뉴 주문을 입력받습니다.
- `OutputView.java` (class)
    - 설명: 사용자에게 출력합니다.
    - 책임 및 역할
        - 사용자에게 출력합니다.

### util
- `DateUtils.java` (class)
    - 설명: 날짜와 관련된 유틸리티 메소드를 제공합니다.
    - 책임 및 역할
        - 주어진 날짜가 주말인지 평일인지 판단합니다.
        - 특정 날짜 범위 내에 주어진 날짜가 포함되는지 판단합니다.
    - 메소드
        - isWeekend(LocalDate date): 날짜를 입력받아 해당 날짜의 주말 여부를 반환합니다.
        - isSpecialDiscountDay(LocalDate date): 날짜를 입력받아 해당 날짜가 특별 할인 날짜인지 여부를 반환합니다.
        - isSundayOrChristmas(LocalDate date): 날짜를 입력받아 해당 날짜가 일요일 또는 크리스마스인지 여부를 반환합니다.
        - isWithinPeriod(LocalDate date, LocalDate startDate, LocalDate endDate): 날짜를 입력받아 해당 날짜가 특정 날짜 범위 내에 포함되는지 여부를 반환합니다.

### 기타
- `Application.java` (class)
    - 애플리케이션의 진입점을 제공합니다.
    - 주요 컨트롤러를 초기화하고 실행을 시작합니다.