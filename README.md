# 기능 요구사항

  1. 영화 기본 정보로 아래의 항목이 주어진다.
      * 영화 아이디
      * 영화 제목
      * 요금
      * 상영 시작 시간
      * 상영 시간별 예매 가능 인원

  2. 영화는 한번에 여러 영화를 예매할 수 있어야 한다.
      * 단, 일행이 각자의 취향에 따라 다른 영화를 예매한다고 가정한다.
      * 따라서 여러 영화를 예매할 경우 각 영화의 시작 시간 차이가 1시간 이상 차이가 날 수 없다.

  3. 예매가 가능한 상태이면 결제를 진행한다.

  4. 예매가 불가능한 경우 그 이유를 보여주고, 다시 예매할 수 있 도록 해야 한다.
      * 상영 시작 시간이 이미 지난 영화를 선택하는 경우
      * 예매 가능 인원을 초과하는 경우
      * 두 영화의 시간 차이가 1시간 이내가 아닌 경우
      * 상영목록에 없는 영화를 선택한 경우

  5. 결제 유형에 따라 할인율이 달라지고, 포인트를 사용할 수 있다.
      * 결제할 때 적립되어 있는 포인트를 사용할 수 있다.
      * 신용카드는 5%, 현금 결제는 2% 할인된다. 할인은 포인트를 제외한 금액에 적용한다.

  6. 최종 예매 금액을 보여준다.


# 구현할 기능

- 여러 영화 예매 번호 입력받기
    * 영화 예매 번호는 영화 리포지터리에 있는 번호
    * 영화 예매 번호는 중복없어야함


- 모든 예매할 영화에 대해서
    - [x] 예매 가능 시간표 출력

    - [x] 예매 인원수 선택
        * [x] 예매 가능 인원을 초과확인


    - 예매 시간표 선택
        * 상영시간이 이미 지났는지 체크
        * [x] 영화 예매에 대한 한시간 이상 차이가 나는지 체크




- 예매 흐름 로직 구현
    * 예매가 완전히 실패한 경우 조건없이 다시 예매 시도.
    * 예매가 성공하였고 또다른 예매를 실행할 경우 결재비용 누적.
    * 예매가 성공하였고 결제를 시작할 경우 포인트 사용 및 할인 계산.


- 결제유형 enum
    * 멤버 변수: 명칭, 할인율


- 포인트 클래스
    * 0보다 크거나 같은 정수

- 결제 클래스: 주어진 예매 입력과 Move리포지터리에 있는 영화목록 그리고 포인트를 참조하여 계산을 진행한다.
    * 포인트 차감
    * 할인 계산
