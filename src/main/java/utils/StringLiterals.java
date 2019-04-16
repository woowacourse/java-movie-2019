package utils;

public enum StringLiterals {
    MOVIE_ID_STATEMENT ("## 예약할 영화를 선택하세요."),
    MOVIE_ID_ERROR ("영화 리스트를 참고하여 해당 영화를 정수로 입력해주세요."),
    MOVIE_TIME_STATEMENT ("## 예약할 시간표를 선택하세요. (첫 번째 상영 시간이 1번)"),
    MOVIE_TIME_ERROR ("시간표를 참고하여 상영 시간 범위의 정수를 입력해주세요."),
    NUMBER_OF_PERSON_STATEMENT ("## 예약할 인원을 입력하세요."),
    NUMBER_OF_PERSON_ERROR ("영화를 보실 인원수를 예약가능인원 수 내에서 0 이상의 정수로 입력해주세요."),
    FINISH_SELECTION_STATEMENT ("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번"),
    FINISH_SELECTION_ERROR ("1, 2 중에서 하나를 입력해주세요."),
    POINT_STATEMENT ("포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력"),
    POINT_ERROR ("포인트를 0 이상의 정수로 입력해주세요."),
    PAY_METHOD_SELECTION_STATEMENT ("신용카드는 1번, 현금은 2번"),
    PAY_METHOD_SELECTION_ERROR ("1, 2 중에서 하나를 입력해주세요.");

    private final String name;

    private StringLiterals(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
