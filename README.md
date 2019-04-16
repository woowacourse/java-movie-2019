기능 요구사항
================

1.영화 기본 정보로 아래의 항목이 주어진다.
• 영화아이디
• 영화제목
• 요금
• 상영시작시간
• 상영시간별예매가능인원

2. 영화는 한번에 여러 영화를 예매할 수 있어야 한다.
•단,일행이각자의취향에따라다른영화를예매한다고가정한다.
•따라서 여러 영화를 예매할 경우 각 영화의 시작 시간차이가
 1시간 이상 차이가 날 수 없다.

 3.예매가가능한상태이면결제를진행한다

 4.예매가 불가능한 경우 그 이유를 보여주고, 다시 예매할 수 있
 도록 해야 한다.
 • 상영시작시간이 이미 지난영화를 선택하는 경우
 • 예매가능인원을 초과하는경우
 • 두 영화의 시간차이가 1시간 이내가 아닌 경우
 • 상영 목록에 없는 영화를 선택한 경우

 5. 결제유형에따라할인율이달라지고,포인트를사용할수있다.
 • 결제할때 적립되어 있는 포인트를 사용할 수 있다.
 • 신용카드는5%, 현금결제는 2% 할인된다.
   할인은 포인트를 제외한 금액에 적용 한다.
 6.최종예매금액을보여준다.

 기능 구현 commit
 ----------------
 
 - [x] 마크다운 작성
 - [x] 예약할 영화 입력 받기 (검증 필요)
 - [x] 예약할 시간표 선택하기 (PlaySchedule 선택, 검증 필요)
 - [x] 예약할 인원 입력하기
 - [x] 예약 종료하기
 - [x] 포인트 사용 여부 결정하기
 - [x] 신용카드, 현금 결제 만들기 ( 할인 여부)
 - [x] 최종 금액 계산 및 출력하기
 - [x] 검증 추가
 - [ ] 추가 예약 기능 추가하기
 - [ ] 추가 예약 검증 하기