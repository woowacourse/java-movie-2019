# 우아한 테크코스 프리코스 오프라인 코딩테스트

## 미션 리스트
우아한 테크코스 과정에 참여하기 위해 Delf(이상훈)가 3주간 주어진 미션을 열심히 수행하는 저장소입니다.
- 1주차 미션 - [과정 및 느낀점](https://github.com/Delf-Lee/study-archive/blob/master/woowacourse/tech-corce-mission-1.md) / [repository](https://github.com/Delf-Lee/java-baseball/tree/delf)
- 2주차 미션 - [과정 및 느낀점](https://github.com/Delf-Lee/study-archive/blob/master/woowacourse/tech-corce-mission-2.md) / [repository](https://github.com/Delf-Lee/java-racingcar/tree/delf)
- 3주차 미션 - [과정 및 느낀점](https://github.com/Delf-Lee/study-archive/blob/master/woowacourse/tech-corce-mission-3.md) / [repository](https://github.com/Delf-Lee/java-lotto/tree/delf)

# 주제
오프라인 코딩 테스트 - 영화 애매
# 요구사항
## 기능 요구사항
1. 영화 기본정보로 아래의 항목이 주어진다.
    - 영화 아이디
    - 영화 제목
    - 요금
    - 상영 시작시간
    - 상영시간별 예매가능 인원
2. 영화는 한번에 여러 영화를 예매할 수 있어야 한다.
    - 단, 일행이 각자의 취향에 따라 다른 영화를 예매한다고 가정한다.
    - 따라서 여러 영화를 예매할 경우 각 영화의 시작 시간 차이가 1시간 이상 차이가 날 수 없다.
3. 예매가 가능한 상태이면 결제를 진행한다.
4. 예매가 불가능한경우 그 이유를 보여주고,다시 예매할 수 있도록 해야한다.
    - 상영 시작시간이 이미 지난 영화를 선택하는 경우
    - 예매 가능 인원을 초과하는 경우
    - 두 영화의 시간차이가 1시간 이내가 아닌 경우
    - 상영 목록에 없는 영화를 선택한 경우
5. 결제유형에 따라 할인율이 달라지고,포인트를 사용할 수 있다.
    - 결제할 때 적립되어있는 포인트를 사용할 수 있다.
    - 신용카드는 5%, 현금결제는2% 할인된다. 할인은 포인트를 제외한 금액에 적용한다.
6. 최종예매금액을보여준다.

## 프로그래밍 요구사항
- 객체 구현 - `Lotto`, `WinningLotto`
    - 기본 생성자 금지
    - 접근 지정자 변경 금지
    - 필드 추가 금지
- 자바 컨벤션 지키지
- `else` 사용 금지
- 메서드의 길이 10라인 초과 금지
- indent depth 2 초과 금지
- 메서드 인자 4개 이상 금지

# 구현 목록
- 영화 정보 꺼내와ㅘ 서 출력
  - 영화 id로 영화 객체 얻기
- 사용자 입력에 따라 영화 예매 정보 생성
  - 영화 id
    - 숫자만 입력하게 한다.
    - 존재하는 id만 입력하게 한다.
  - 인원
    - 남은 좌석 이하의 인원만 입력하게 한다.
- 