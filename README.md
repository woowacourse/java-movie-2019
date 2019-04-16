# #영화 예매

* ### 프로그램 소개

  영화를 예매할 수 있는 프로그램
  

* ### 프로그램 시나리오

  1. 영화 기본 정보가 주어진다.

     * 영화 아이디
     * 요금
     * 상영 시작 시간
     * 상영 시간별 예매 가능 인원

  2. 영화를 선택한다.
     영화를 예매할 때는 여러 영화를 예매가 가능하다.
     대신 순차적으로 접근가능하다. (1번 영화를 예매한 뒤, 2번 영화 예매 가능)

  3. 예매가 가능 하다면 결제를 진행

     만약, 예매가 불가능한 상태라면 해당 이유를 보여주고 다시 예매하도록 한다.

     - 시작 시간이 지난 경우 
     - 예매 가능 인원 초과 
     - 두 영화의 시간 차이가 1시간 이내가 아닌 경우
     - 상영 목록에 없는 영화를 선택하는 경우

  4. 결제 유형에 따라 할인율이 달라지고, 포인트를 사용할 수 있다.

  5. 최종 예매 금액을 보여준다.

---



* ### 구현 기능
  * ##### 예약할 영화를 선택

    선택을 한 영화의 정보를 제공

    > 예외 상황 
    >
    > 1. 숫자가 아닌 경우
    > 2.  영화 ID가 없거나 잘못된 경우

  * ##### 예약할 시간표를 선택

    원하는 시간을 입력 받기

    > 예외 상황
    >
    > 1. 숫자가 아닌 경우
    > 2. 해당 숫자가 영화 개수를 넘어갔을 경우
    >    ex) 상영 시간이 5개인데 6을 입력하였을 때

  * ##### 결제를 진행 할지 추가 예약을 진행할지 여부 확인

    추가 예약없이 결제로 넘어갈 시 : 1, 추가 예약을 할 시 : 2
    추가 예약을 하지 않는다면 예약 정보를 출력

    > 예외 상황
    >
    > 1. 1과 2가 입력되지 않은 경우

  * ##### 결제 진행시 포인트 사용할지 여부 확인

    사용할 포인트가 있다면 해당 금액을 받는다.
    포인트가 없다면 0을 입력

    >예외 상황
    >
    >1. 숫자가 아닌 경우

  * ##### 결제 수단 정하기

    신용카드를 사용할 시 : 1, 현금을 사용할 시 : 2

    > 예외 상황
    >
    > 1. 1과 2가 입력되지 않은 경우

  * ##### 최종 내역 출력

    구매한 예매 내역 출력

  ---

  

* ##### 