오프라인 코딩 테스트 - 영화예매
==========================

### 프로그래밍 요구사항

1. 자바 코드 컨벤션을 지키면서 프로그래밍한다.
2. indent(인덴트, 들여쓰기) depth를 1~~3~~이 넘지 않도록 구현한다. ~~2까지만 허용한다.~~
    + 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다. 
    + 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
3. 함수(또는 메소드)의 길이가 10~~15~~라인을 넘어가지 않도록 구현한다.
    + 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
4. else 예약어를 쓰지 않는다.
    + 힌트 : if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    + else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
5. public/protected/private/package 접근 제어자를 용도에 적합하게 사용해 구현한다.
6. 함수(또는 메소드)의 인자 수를 3개까지만 허용한다. 4개 이상은 허용하지 않는다.

### 기능 요구사항

1. 영화 기본 정보로 아래의 항목이 주어진다.
    + 영화 아이디
    + 영화 제목
    + 요금
    + 상영 시작 시간
    + 상영 시간별 예매 가능 인원
2. 영화는 한번에 여러 영화를 예매할 수 있어야 한다.
    + 단, 일행이 각자의 취향에 따라 다른 영화를 예매한다고 가정한다.
    + 따라서 여러 영화를 예매할 경우 각 영화의 시작 시간 차이가 1시간 이상 차이가 날 수 없다.
3. 예매가 가능한 상태이면 결제를 진행한다.
4. 예매가 불가능한 경우 그 이유를 보여주고, 다시 예매할 수 있도록 해야 한다.
    + 상영 시작 시간이 이미 지난 영화를 선택하는 경우
    + 예매 가능 인원을 초과하는 경우
    + 두 영화의 시간 차이가 1시간 이내가 아닌 경우
    + 상영목록에 없는 영화를 선택한 경우
5. 결제 유형에 따라 할인율이 달라지고, 포인트를 사용할 수 있다.
    + 결제할 때 적립되어 있는 포인트를 사용할 수 있다.
    + 신용카드는 5%, 현금 결제는 2% 할인된다.
    + 할인은 포인트를 제외한 금액에 적용한다.
6. 최종 예매 금액을 보여준다.

### 객체 요구사항

1. 객체 1
    ```java
    public class Movie {
        private static final char NEW_LINE = '\n';
        
        private final int id;
        private final String name;
        private final int price;
        private final List<PlaySchedule> playSchedules = new. ArrayList<>();
 
        public Movie(int id, String name, int price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        // 추가 기능 구현
    }
    ```
    + 다음 Movie 객체를 활용해 구현해야 한다.
    + Movie 기본 생성자를 추가할 수 없다.
    + 필드(인스턴스 변수)의 접근 제어자인 private을 변경할 수 없다.
    + Movie에 필드(인스턴스 변수)를 추가할 수 없다.

2. 객체 2
    ```java
    /**
     * 영화 상영 스케줄을 관리하는 객체
     */
    public class PlaySchedule {
        private final LocalDateTime startDateTime;
        private int capacity;
    
        public PlaySchedule(LocalDateTime startDateTime, int capacity) {
            this.startDateTime = startDateTime;
            this.capacity = capacity;
        }
        // 추가 기능 구현
    }
    ```
    + 다음 PlaySchedule 객체를 활용해 구현해야 한다.
    + PlaySchedule 기본 생성자를 추가할 수 없다.
    + startDateTime, capacity 변수의 접근 제어자인 private을 변경할 수 없다.
    + PlaySchedule에 필드(인스턴스 변수)를 추가할 수 없다.


### 기능 정리

+ 사용자에게 영화 목록을 출력한다.
+ 사용자에세 예매할 영화를 입력 받는다.
+ 사용자에게 예매할 영화의 시간을 입력 받는다.
+ 사용자에게 예매할 영화의 인원수를 입력 받는다.
+ 추가 예매 여부를 입력 받는다.
+ 사용자가 선택한 영화 모두를 결제한다.
+ 결제시 포인트를 사용 가능하다.
+ 결제 수단을 입력 받는다.
+ 최종 결제한 금액을 출력한다.
 