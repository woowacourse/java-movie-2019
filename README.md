# 영화 예매
오프라인 코딩테스트<br>
사용자의 입력에 따라 영화 예매 서비스를 제공한다.  <br>

## 기능 요구사항
  - 영화 기본정보를 제공한다.(영화 아이디, 제목, 요금, 상영 시작시간, 상영 시간별 예매 가능인원)
  - 한번에 여러 영화를 예매할 수 있다. (단, 각 영화의 시작 시간 차이가 1시간 이상 날 수 없다.)
  - 예매가 가능한 상태이면 결제를 진행한다.
  - 예매가 불가능한 경우 그 이유를 보여준다.
     - 상영 시작 시간이 이미 지난 영화 선택
     - 예매 가능 인원 초과
     - 두 영화 시간 차이가 1시간 이내가 아닌 경우
     - 상영 목록에 없는 영화 선택
  - 결제 유형에 따라 할인율이 달라지고, 포인트를 사용할 수 있다.
     - 결제할 때 적립되어 있는 포인트를 사용할 수 있다.
     - 신용카드는 5%, 현금 결제는 2% 할인된다.
     - 할인은 포인트를 제외한 금액에 적용한다.
  - 최종 예매 금액을 보여준다.
 
## 구현 기능 목록 
 1. 예약할 영화 입력받아 영화 해당 스케쥴 출력하기
    - 영화 아이디로 예약할 영화를 입력받음
    - 아이디가 범위에 존재하지 않는 경우 재입력 받기
 2. 예약할 영화 시간 입력받기
    - 영화 시간대 목록 순서대로 1~n 까지의 숫자로 입력받기
    - 존재하지 않는 상영시간을 선택한 경우 재입력 받기
 3. 예약할 인원 입력받기
    - 예약 가능 인원 범위의 숫자를 입력하지 않은 경우 재입력 받기
 4. 추가 예약 또는 결제 진행하기
    - 1이 입력된 경우 결제를 진행
    - 2가 입력된 경우 추가 예약을 진행
    - 입력값이 1 또는 2가 아닐 경우 재입력 받기
 5. 추가 예약 과정 예외 처리하기
    - 추가 예약한 영화의 시간대가 이전에 예약한 영화와 1시간 이상 차이가 날 경우 재입력받기
 6. 포인트 사용금액 입력받기
    - 포인트가 0이상의 정수값이 아닐 경우 재입력
    - 포인트가 양의 정수일 경우 포인트만큼 할인 적용
 7. 결제 수단 입력받기
    - 1이 입력된 경우 신용카드 결제로 5% 할인 적용
    - 2가 입력된 경우 현금 결제로 2% 할인 적용
 8. 할인이 적용된 최종적인 결제 금액을 출력하기