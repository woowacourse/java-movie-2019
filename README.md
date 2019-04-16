
# 영화 예매
---
## 기능 요구사항

1. 영화 기본 정보로 여러 항목이 주어진다.
1. 영화는 한번에 여러 영화를 예매할 수 있어야 한다.
1. 예메가 가능한 상태이면 결제를 진행한다.
1. 예매가 불가능한 경우 그 이유를 보여주고, 다시 예매할 수 있도록 해야한다.
1. 결제 유형에 따라 할인율이 달리지고, 포인트를 사용할 수 있다.
1. 최종 예매 금액을 보여준다.
---
## 구성
- MovieApplication.java
- Movie.java
- MovieRepository.java
- PlaySchedule.java

---

## Class & Method 설명

| MovieApplication.java | 프로그램을 실행시키기 위한 Class  |
| ----------- | ------------ |
| private static void getSelectMovie(int no) | 영화를 선택하는 매서드 |
|  public static void selecMovieTime(int no)| 선택한 영화의 상영 시간을 선택하는 매서드 |
|private static void getPpl(int no)| 선택한 시간에 예약할 인원을 입력받는 매서드 |
|private static void printCurrentState()|현재 상태를 출력하는 매서드이다.|
|private static boolean timeGap() | 선택된 시간들의 시간차를 구하는 매서드이다.|
| private static boolean comparisonNo(int i) | acceptablePplCheck 매서드의 연산을 돕는다. |
|private static boolean acceptablePplCheck() | 수용가능 여부를 구하는 매서드.|
|private static boolean pastMovie()|현제 시간보다 지난 영화인지 확인하는 매서드|
| private static boolean payProbabilityCheck()| 결제 가능여부를 확인하는 매서드|
|private static double getTotalMoney() | 총 영화의 금액을 얻는 매서드 |
|private static void payment() |결재를 진행하는 매서드|
|private static void listInit()|List를 초기화 하는 매서드로 결재를 다시 진행할때 사용된다.|
|private static void booking() |영화 예약을 진행한다.|

| Movie.java | 영화 정보를 가지고 있는 객체|
| ----------- | ------------ |
| |  |


| MovieRepository.java | MovieRepository 객체 클래스로 Database의 역활을 한다.|
| ----------- | ------------ |
|||

|InputView|입력을 받는 클래스|
|-----------|----------|
| public static int inputTime()| 시간표를 선택하고 선택한 시간을 반환하는 매서드|
| public static int inputPpl()| 예약할 인원을 입력받는 매서드|
|public static boolean inputContinueCheak() | 예약 진행을 입력받는 매서드 |
|public static int inputPoint() | 포인트를 입력받는 매서드 |
|public static int inputPaymentMethod()| 결제 방법을 입력받는 매서드 |

---
### 프로그래머
 권경동 (fancyartisan@gmail.com / rudehd10@naver.com)
---
### 체인지로그


