# 오프라인 코딩테스트 - 영화 예매

## 요구사항 분석

### 기능 요구사항
* 주어진 영화 항목에 따라 여러 영화를 예매하고, 결제를 진행하여 최종 예매 금액을 보여준다.
* 예매가 불가능한 경우 이유를 보여주고 다시 예매할 수 있도록 한다.
* 결제 유형에 따라 할인률이 달라지고, 결제에 기 적립된 포인트를 사용할 수 있어야 한다.
  * 포인트는 무제한이라고 가정

### 프로그래밍 요구사항
* 리포지토리에서 제시한 코드를 바탕으로 작성해야 한다.
  * `Movie` 객체
  * `PlaySchedule` 객체
* `MovieApplication`의 `main()` 함수에서 구현을 시작한다.
* `MovieRepository`에는 조회용 메소드 추가만 가능하다.
* 영화 상영 시간이 1시간 이내인지를 판단하는 메소드가 유틸리티로 제공된다.
* 들여쓰기 깊이는 1까지만 허용하되, 어쩔 수 없다고 판단될 경우에는 예외적으로 2까지 허용한다.
  * 예를 들어 `for`문 안의 `if`문은 들여쓰기 깊이 2이다.
* 각 메소드의 길이는 10줄을 넘기지 않아야 한다. 
  * 이 제한에서 `main()` 함수는 제외된다.
  * 이 길이 제한은 빈 줄과 주석을 포함한다.
  * 주석은 가급적이면 메소드 바깥 또는 코드 오른쪽에 추가하도록 한다.
* 메소드의 인자 수는 3개까지만 허용한다.
* `else`를 사용하지 않는다.
* `switch/case`를 사용하지 않는다.
* 접근 제어자를 용도에 맞게 사용한다.
* Java 코드 컨벤션을 준수한다.
* 각 메소드 구현이 완료될 때마다 `git commit`을 수행한다.
* 소스 코드의 인코딩은 UTF-8로 통일한다.

## 구현 초안

## 해야할 일 (TODO)
* 요구사항 분석
* 기존에 제시된 코드 분석
* 구현 초안 짜기
* 실제로 작동하는 초기 버전 메소드 작성
* 실제로 작동하는 초기 버전 프로그램 완성
* 프로그래밍 요구사항 준수를 위한 수정
* 비정상적인 입력에 대한 처리
* 제출을 위한 Github Push