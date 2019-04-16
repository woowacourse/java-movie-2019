#영화 예매

## 기능목록
- 예약할 영화 id를 입력받는다.
- id가 숫자이고, 존재하는 id인지 검증한다.
- 해당 id의 영화의 시간표를 출력한다.

- 예약할 시간표 번호를 입력받는다.
- 숫자이고, 존재하는 번호인지 검증한다.
- 해당 시간에 예약가능 인원이 1 이상인지 검증한다.

- 예약할 인원을 입력 받는다.
- 숫자이고, 해당 시간표에 예약가능인원보다 작거나 같은지 검증한다.

- 해당 내용(영화id,시간표번호,인원)으로 User객체에 reservcation 추가.

 
- 예약 내역을 출력
- 결제 진행, 추가 예약 진행 선택을 입력 받는다.
    + 1또는 2인지 검증한다.

- 1 입력 시 (결제 진행)
    + 포인트 사용 금액 입력 받기.
        * 0 이상의 포인트인지 검증한다.
    + 신용카드 또는 현금 입력 받기.
        * 1또는 2인지 검증한다.
 
 - 2 입력 시 (추가 예약) 
    + 예약할 영화 선택으로 돌아간다.