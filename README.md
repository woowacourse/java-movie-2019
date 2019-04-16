영화 예매 미션
===
우아한 테크코스 오프라인 테스트

기능 요구사항
---
1. 영화 기본 정보로 아래의 항목이 주어진다.  
    • 영화 아이디  
    • 영화 제목   
    • 요금  
    • 상영 시작 시간  
    • 상영 시간별 예매 가능 인원   

2. 영화는 한번에 여러 영화를 예매할 수 있어야 한다.  
    • 단, 일행이 각자의 취향에 따라 다른 영화를 예매한다고 가정한다.  
    • 따라서 여러 영화를 예매할 경우 각 영화의 시작 시간 차이가  1시간 이상 차이가 날 수 없다.

3. 예매가 가능한 상태이면 결제를 진행한다.
4. 예매가 불가능한 경우 그 이유를 보여주고, 다시 예매할 수 있  도록 해야 한다.   
    • 상영 시작 시간이 이미 지난 영화를 선택하는 경우   
    • 예매 가능 인원을 초과하는 경우  
    • 두 영화의 시간 차이가 1시간 이내가 아닌 경우  
    • 상영목록에 없는 영화를 선택한 경우  

5. 결제 유형에 따라 할인율이 달라지고, 포인트를 사용할 수 있다.   
    • 결제할 때 적립되어 있는 포인트를 사용할 수 있다.  
    • 신용카드는 5%, 현금 결제는 2% 할인된다. 할인은 포인트를 제외한 금액에 적용한다.

6. 최종 예매 금액을 보여준다.

기능 구현목록
---
1. [x] 현재 상영 영화 목록 출력
2. [x] 예약 영화 선택 입력
    - [x] 정수만 입력
    - [x] 영화 목록 범위 밖일 시 다시 예매
3. [x] 선택 영화 시간표 출력
4. [x] 예약 시간 입력
    - [x] 정수만 입력
    - [ ] 이미 시작한 영화 일시 다시 예매
    - [ ] 앞서 선택한 영화 시간과 1시간 이내가 아닐 시 다시 예
5. [x] 예약 인원 입력
    - [x] 정수만 입력
    - [x] 예약 인원이 예매 가능 인원보다 많을 시 다시 예매
6. [x] 추가 예매 여부 입력
    - [x] 1, 2중의 정수만 
7. [x] 예약 내역 출력
8. [x] 포인트 입력
    - [x] 정수만 입력
    - [x] 포인트 금액이 사용금액보다 클 시 재입력 요구
9. [x] 신용카드 현금 여부 입력
    - [x] 1, 2중의 정수만    
    
10. [x] 최종 금액 출력