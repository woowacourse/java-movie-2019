package domain;

import java.util.*;


public class ReservationBox {
    private List<Movie> listOfBoughtMovies = new ArrayList<>();
    private List<Integer>listOfMovieTimes = new ArrayList<>();
    private List<Integer> listOfPeopleCount = new ArrayList<>();
    private List<Integer> listOfPoints = new ArrayList<>();
    private List<Integer> listOfCashOrCredit = new ArrayList<>();

    public String askUserWhatMovie() {
        boolean isUserInputRight = false;
        String userInput = "error:askUserWhatMovie()";
        while (!isUserInputRight) {
            userInput = askAndReceiveInput("##예약할 영화를 선택하세요.");
            isUserInputRight = checkUserInput(userInput);
        }
        return userInput;
    }

    public static String askAndReceiveInput(String sentence) {
        System.out.println(sentence);
        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine();
        return userInput;
    }

    public static boolean checkUserInput(String userInput) {
        if (isNonNumeric(userInput) || isNotMovieNumber(userInput) || isLengthNot1(userInput)) {
            return false;
        }
        return true;
    }

    public static boolean isNonNumeric(String userInput) {
        if (userInput.matches("[0-9]+")) {
            return false;
        }
        System.out.println("숫자만 입려가능합니다. 공백이나 특수문자도 안됩니다.");
        return true;
    }

    public static boolean isNotMovieNumber(String userInput) {
        int intUserInput = Integer.parseInt(userInput);
        if (intUserInput != 1 && intUserInput != 5 && intUserInput != 7 && intUserInput != 8) {
            System.out.println("영화목록에 없는 숫자입니다. 1,5,7,8 중 선택해 주세요!");
            return true;
        }
        return false;
    }

    public static boolean isLengthNot1(String userInput) {
        if (userInput.length() != 1) {
            System.out.println("입력은 한 숫자만 해주세요!");
            return true;
        }
        return false;
    }

    public String askUserWhatTime(Movie selectedMovie) {
        boolean isUserInputRight = false;
        String userInput = "error:askUserWhatTime()";
        while (!isUserInputRight) {
            userInput = askAndReceiveInput("예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
            isUserInputRight = checkUserTime(userInput, selectedMovie);
        }
        return userInput;
    }

    public static boolean checkUserTime(String userInput, Movie selectedMovie) {
        if (isNonNumeric(userInput) || isLengthNot1(userInput) || isNotMovieTime(userInput, selectedMovie) || isNotAvailable(userInput, selectedMovie)) {
            return false;
        }
        return true;
    }

    private static boolean isNotMovieTime(String userInput, Movie selectedMovie) {
        int intUserInput = Integer.parseInt(userInput);
        if (intUserInput < 0 || intUserInput > selectedMovie.getTimeLength()) {
            System.out.println("영화시간표에 있는 시간만 입력해주세요!");
            return true;
        }
        return false;
    }

    private static boolean isNotAvailable(String userInput, Movie selectedMovie) {
        if (selectedMovie.getAvailableSeat(userInput) < 1) {
            System.out.println("좌석이 없습니다");
            return true;
        }
        return false;
    }

    public String askHowManyPeople(String whatTime, Movie selectedMovie) {
        boolean isUserInputRight = false;
        String userInput = "error:askUserWhatMovie()";
        while (!isUserInputRight) {
            userInput = askAndReceiveInput("##예약할 인원은 입력하세요");
            isUserInputRight = checkUserPeople(userInput, whatTime, selectedMovie);
        }
        return userInput;
    }

    private static boolean checkUserPeople(String userInput, String whatTime, Movie selectedMovie) {
        if (isLengthNot1(userInput) || isPeopleBiggerThanAvailalble(userInput, whatTime, selectedMovie)) {
            return false;
        }
        return true;
    }

    private static boolean isPeopleBiggerThanAvailalble(String userInput, String whatTime, Movie selectedMovie) {
        int intUserInput = Integer.parseInt(userInput);
        if (intUserInput > selectedMovie.getAvailableSeat(whatTime)) {
            System.out.println("신청인원이 빈좌석을 초과했습니다!");
            return true;
        }
        return false;
    }

    public void saveInformation(Movie selectedMovie, String whatTime, String howManyPeople) {
        listOfBoughtMovies.add(selectedMovie);
        int intWhatTime = Integer.parseInt(whatTime);
        listOfMovieTimes.add(intWhatTime);
        int intHowManyPeople = Integer.parseInt(howManyPeople);
        listOfPeopleCount.add(intHowManyPeople);
    }

    public int askUserContinue() {
        String userInput = this.askContinue();
        int intUserInput = Integer.parseInt(userInput);
        return intUserInput;
    }

    public String askContinue() {
        boolean isUserInputRight = false;
        String userInput = "error:askUserWhatMovie()";
        while (!isUserInputRight) {
            userInput = askAndReceiveInput("예약을 종료하고 결제를 진행하려면 1, 추가예약하려면 2번을 눌러주세요");
            isUserInputRight = checkUserContinue(userInput);
        }
        return userInput;
    }

    public static boolean checkUserContinue(String userInput) {
        if (isNonNumeric(userInput) || isNot1Or2(userInput)) {
            return false;
        }
        return true;
    }

    private static boolean isNot1Or2(String userInput) {
        int intUserInput = Integer.parseInt(userInput);
        if (intUserInput != 1 && intUserInput != 2) {
            System.out.println("1이나 2만 입력해주세요");
            return true;
        }
        return false;
    }
}
