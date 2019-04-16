#우아한테크코스: java-movie

## 전체 기능 구현 목록 정의:
1. 영화중 예약할 영화를 물어본다.
2. 유저의 인풋이 맞는지 확인한다. 
<br/> 2-1.(isNonNumeric(userInput) || isNotMovieNumber(userInput) || isLengthNot1(userInput))
3. 선택한 영화의 시간표를 출력한다. 
3. 유저의 인풋이 맞다면 예약할 시간을 물어본다.
4. 유저의 인풋이 맞는지 확인한다.
<br/> 4-1. (isNonNumeric(userInput) || isLengthNot1(userInput) || isNotMovieTime(userInput, selectedMovie) || isNotAvailable(userInput, selectedMovie))
5. 예약할 인원을 물어본다.
6. 유저의 인풋이 맞는지 확인한다.
<br/> 6-1. (isLengthNot1(userInput) || isPeopleBiggerThanAvailalble(userInput, whatTime, selectedMovie))
7. 유저에게 예약을 계속 진행할 것인지 물어본다.
8. 예약속행 의지 인풋이 맞는지 확인한다.
9. 포인트 사용금액 여부를 묻는다.
10. 인풋을 확인한다.
11. 신용카드로 할 것인지 현금으로 할 것인지 묻는다.
12. 신용카드/현금 인풋을 확인한다.
13. 결제금액을 출력한다. 