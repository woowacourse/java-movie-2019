## 우아한테크코스 : 영화예매
- 우아한 테크코스 3번째 미션 "로또" 를 구현한 프로젝트 입니다.
- "로또" 게임이란 사용자가 로또를 여러장 구매한 후, 로또의 당첨번호를 입력해 수익률을 확인할수있는 간단한 게임입니다.

## 기능 요구사항
1. 영화 기본 정보로 아래의 항목이 주어진다.
2. 영화는 한번에 여러 영화를 예매할 수 있다.

## 바람직한 입/출력 예시

## 폴더 구조
```
|-- main
|   -- java
|       -- controller
|           |-- DataReceiver.java       유저로부터 데이터를 받는 로직 담당
|           |-- LottoGame.java          게임 전체 진행 담당
|           |-- Validator.java          데이터의 유효성 체크 담당
|       -- database
|           |-- GameSetting.java        게임 세팅데이터 담당
|           |-- UserViewData.java       게임 출력데이터 담당
|       -- lottodata
|           |-- Lotto.java              로또 1장 객체
|           |-- Rank.java               로또 1장 당첨결과 객체
|           |-- WinningLotto.java       당첨로또 객체
|       -- Main.java
```
## 구현로직 분류
- [x] 메인로직 1: 사용자로 부터 영화 번호 입력 받고 그에 맞는 영화 출력하기
    - [x] 서브로직 1-1: 입력이 정수로 변환가능한지 확인
    - [x] 서브로직 1-2: 입력이 영화 목록에 있는 번호인지 확인
    - [x] 서브로직 1-3: 이때 첫 예매가 아니라면 기존 예매와 시작 시간의 차이가 1시간 이상 날 수 없다.
- [x] 메인로직 2: 사용자로 부터 예약할 시간표를 선택하기 위해 정수를 입력받기(첫번째 상영 시간이 1번)
    - [x] 서브로직 2-1: 입력이 정수로 변환가능한지 확인
    - [x] 서브로직 2-2: 입력이 선택가능한 상영 시간인지 확인
- [x] 메인로직 3: 사용자로부터 예약할 인원을 입력 받기
    - [x] 서브로직 3-1: 입력이 정수로 변환가능한지 확인
    - [x] 서브로직 3-2: 해당 영화의 시간표에 충분한 잔여 인원이 있는지 확인
- [x] 메인로직 4: 사용자로부터 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번 입력 받기
    - [x] 서브로직 4-1: 입력이 정수로 변환가능한지 확인
    - [x] 서브로직 4-2: 입력이 1~2의 숫자인지 확인
    - [x] 서브로직 4-3: 1번일시 결제 로직 실행, 2번일시 로직1부터 반복
    - [x] 서브로직 4-4: 1번일시 예약 내역 출력하기
- [x] 메인로직 5: 사용자로부터 포인트 사용 금액을 입력 받기. 포인트가 없으면 0 입력
    - [x] 서브로직 5-1: 입력이 정수로 변환가능한지 확인
    - [x] 서브로직 5-2: 입력 받은 포인트만큼 결제 금액에서 차감
- [x] 메인로직 6: 사용자로부터 신용카드, 현금 선택 입력 받기
    - [x] 서브로직 6-1: 입력이 정수로 변환가능한지 확인
    - [x] 서브로직 6-2: 할인율에 따른 결제금액 계산 로직 만들기
    - [x] 서브로직 6-3: 최종 예매 금액 출력하기
- [x] 메인로직 7: 전체 게임 진행 로직 구현

## 클래스별 세부 기능

|LottoGame|로또게임 진행을 담당|
|---|---|
|getLottoCountFromUser|유저로부터 로또갯수 입력받기|
|createLottos| 특정갯수의 로또객체를 생성해 반환|
|printLottos|특정갯수의 로또객체정보를 출력|
|createWinningLotto|당첨로또 생성|
|transformWinningNumberInputToIntegerList|유저로부터 받은 로또넘버6개 입력을 리스트로 변환해서 반환|
|createInitializedRankCounter|로또 당첨결과 계산하기위한 자료구조(Map)생성 후 반환|
|calculateLottoMatch|로또 당첨결과를 계산|
|calculateProfitRate|수익률 계산|
|printLottoResult|로또 당첨 결과를 출력(당첨로또 현황, 수익률)|
|playGame|게임 실행 함수|

|Lotto|로또 1장 객체|
|---|---|
|getNumbers|로또넘버 반환|
|getCountOfMatch|로또넘버 일치갯수 반환|
|checkNumberContain|입력된 로또넘버 포함 여부 반환|
|createPossibleNumbers|로또넘버로 가능한 숫자들을 반환|
|createRandomLotto|랜덤하게 로또한개를 생성해 반환|
|printLottoNumbers|로또넘버를 출력|

|WinningLotto|당첨 로또 객체|
|---|---|
|match|특정 로또객체의 당첨결과를 반환|

|Rank|당첨결과 객체|
|---|---|
|printRank|당첨결과 출력|

|Validator|값이 에러를 갖는지 확인하는 로직을 담당|
|---|---|
|checkIsInteger|정수로 변환가능한지 확인|
|checkIsLottoNumberInRange|범위안에 있는 값인지 확인|
|checkNumbersLengthIsValid|당첨로또입력의 갯수 확인|
|checkEachStringIsInteger|당첨로또입력의 모든숫자가 정수로 변환가능한지 확인|
|checkEachStringInRange|당첨로또입력의 모든숫자가 1~45인지 확인|
|checkEachStringDontOverlap|당첨로또입력이 중복 없는지 확인|
|checkIsAlreadyInLottoNumbers|입력이 이미 로또번호에 포함된 번호인지 확인해 반환|
|checkInputLottoMoneyIsUnderMinvalue|인풋 금액이 로또1장금액보다 낮은지 체크|
|checkWinningLottoNumbers|당첨로또번호 입력에 오류가있는지 종합 체크|

|GameSetting|게임의 세팅데이터 담당|
|---|---|

|UserViewData|게임의 출력데이터 담당|
|---|---|

|DataReceiver|유저로부터 데이터 입력받는 로직 담당|
|---|---|
|getLottoMoneyFromUser|유저로부터 로또구입금액을 입력받음|
|getWinningLottoNumbersFromUser|유저로부터 유효한 로또넘버 6개를 받음|
|getBonusNumberFromUser|유저로부터 보너스넘버를 입력받음|