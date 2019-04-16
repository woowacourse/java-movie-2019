- class MovieRespository

    - getMovie() : 특정 id를 입력 받으면 그 영화의 정보만 반환하는 메서드
    - playScheduleOfMovieOfNum() : 특정 id의 영화에서 특정 순서를 입력 받으면 그 입력된 순서의 영화 상영시간을 반환하는 메서드

- class Movie

    - getId() : movie의 id를 반환하는 메서드
    - getPlaySchedule() : movie의 상영 시간표를 반환하는 메서드

- class OutputView

    - printMovie() : 특정 영화의 정보를 출력하는 메서드
    - printReservation() : 영화 예매 정보를 출력하는 메서드

- class InputView

    - inputMovieScheduleNum() : 상영 시간표에서 특정 시간을 선택했을 때 그 시간표의 번호를 입력받는 메서드
    - inputPeopleWatchingMovie() : 영화를 보는 인원 수를 입력받는 메서드

- class PartialApplication

    - appOfOne() : 한 번의 예매 상황을 구현하는 메서드
    - checkIfTooMuchPeople() : 잔여 좌석 수보다 더 많이 예매하면 true를 반환하는 메서드
    - updateMovieForTooMuch() : 예매한 인원이 잔여 좌석보다 많을 때 영화 상영표를 업데이트 하는 메서드
    - updateMovieForLess() : 예매한 인원이 잔여 좌석보다 적을 때 영화 상영표를 업데이트 하는 메서드