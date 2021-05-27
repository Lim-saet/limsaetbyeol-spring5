#### 20210527 목 작업예정
-3장 객체과 클래스 부터 시작

#### 20210527 목
- 3장 객체와 클래스부터 시작
- 스프링에서는 클래스 extends 상속보다는 인터페이스 implements를 더 많이 사용함
- abstract 클래스(추상클래스): 구현내용 없이 메소드 명만 있는 클래스
- 메소드명만 있기 때문에(구현내용이 없기 때문에) 객체로 만들 수 없는 클래스 
- 부모로서 자식에세 상속만(메서드 이름만)해서 상속 재사용만 가능하게 됌
- 객체로 만들 수 없다? 실행가능한 클래스로 사용 못하지만 프로그램을 구조화 시킬때 필요
- Step1 aaa = new Step1();//이렇게 생성자로 객체를 만들지 못함 
- final 클래스: 부모가 될 수 없는 클래스 = 상속해서 재사용이 불가능한 클래스 
- 접근제어자: public(패키지위치에 상관업시 접근-제일많이 사용),
- public 클래스 안에서 멤버변수는 private을 제일 많이 사용(보안성을 갖추기 때문)
- public 클래스 안에 멤버메서드는 public을 많이 사용 (외부 다른 클래스의 메서드를 사용) 대신, 변수가 private이기 때문에 직접수정x 실행만ㅇ
- 인스턴스(클라우드에서 주로 사용) = 오브젝트(자바) = 객체 = 실행중인 클래스
- 클래스 자료형(int, long, String 처럼)는 멤버변수, 멤버메서드, 서브클래스 등등 포함 할 수 있습니다

** 이클립스에서 커밋이나 푸시가 안될때 커밋팝업창 하단의 force 어쩌구 항목 체크 


#### 20210526 수
- 스프링 MVC 프로젝트: ModelViewController 약자(웹프로그램구조)
- src/test/java 폴더 만듦: 테스트작업은 이 폴더에서 하라는 약속 
- src/main/java 폴더가 진짜 프로그램 작업을 하는 폴더  
- javac HelloWorld.java -encoding UTF-8 (한글내용도 컴파일됨)
- 위 java 컴파일러로 실행한 결과 -> HelloWorld.class 실행파일 생성됨
- 주의), 클래스파일은 실행 패키지의 루트(최상위)에서 실행해야 함 
- kr.or.test 패키지 root폴더 src/test/java 폴더에서 실행 해야함
- java kr.or.test.HelloWorld 클래스 실행하게 됨
- 이클립스 나오기 전, 25년 전 javac 컴파일에서 class 프로그램을 만들었음
- 지금은 터미널에서 javac 사용하지 않고 이클립스에서 바로 실행
- java c: 자바앱 컴파일러 -> 클래스 실행파일을 만듦 .class(바이트코드) (자바환경JVM실행) 
- 메이븐(maven): 웹프로그램 컴파일러 -> 웹프로그램(앱) 실행파일을 만듦 .war(톰캣에서 실행)
- 메이븐이 컴파일할때, 자바소스만 컴파일하는 것이 아니고 외부 라이브러리도 가져와서 바인딩(묶어줌)하게 됌 = 패키징 =.war(와르)파일로 패키징됨
- 메이븐이 관리하는 외부 라이브러리 파일(lib) 목록을 저장하는 pom.xml입니다
- pom.xml에서 자바버전을 1.6->1.8 변경 후 메이븐을 업데이트 한다
- 외부 라이브러리 파일을 참조하는 방식을 영어로 dependecy디펜던시
- jar파일: JavaArchive자바아카이브 = 자바 앱을 패키징한 파일 
- 변하지 않는 변수=상수=PI=3.141592=변수명을 대문자(PI)
- 보통 상수 변수는 클래스의 제일 상단에 위치함
- 기본형(정수자료형-소문자로 시작): byte<short<int<long, 10L(롱타입변수) 
- 기본형(실수자료형-소수점,소문자로 시작): float<double , 12.34f(실수형숫자)
- 기본형(문자형-'a'단따옴표 값을 입력해야 에러가 나지 않음): char, 1개문자만 입력
- 문자형에서 유니코드 /u숫자입니다 
- 참조형 (불린형-참,거짓): boolean (0|1)
- 참조형 (대문자로 시작): 참조형 변수의 대표적인 변수 클래스 입니다.
- 클래스 변수(저장된 상태)-> 실행가능하게 되었을때, 인스턴스 변수(메모리 로드된 상태)
- 인스턴스라는 말보다는 오브젝트라는 말을 더 많이 사용 
- String(문자열 클래스변수): 대문자로 시작
- 상수변수를 명시적으로 만들때: final int MAX =100;
- for-each 반복문전까지 실습
- 추상화(Abstract): 오프라인 업무-> 대표 업무만 뽑아낸  = 추상클래스
- 클래스는 멤버변수 + 멤버 메서드(실행) + 서브클래스
- 객체(Object)와 클래스 : 클래스형 자료를 실행 가능하게 만든것을 오브젝트(객체)
- OOP: 자바를 객체지향(클래스를 실행가능하게하는) 프로그래밍
- 객체 = 오브젝트 = 인스턴스 = 실행가능한 클래스
- 붕어빵 : 빵틀(클래스)-> 붕어빵이 구워져서 나오면 오브젝트(객체)

#### 20210525 화 작업
- 자바 기초 실습
- 자바 .java클래스파일을 컴파일해서 .class파일 실행하는 구조
- 파이썬/자바스크립트는 인터프리터 방식으로 실행
- 자바스크립트는 함수기반의 프로그래밍 = Function(함수)
- 자바는 객체지향프로그래밍(Object Oriented Program)
- 오브젝트(객체) = 실행가능한 Class(클래스)
- 아스키, 유니코드(UnicodeTypeFormat-8)
- 아스키 코드는 IOT에서 데이커 전송시 필수로 확인해야 함 0,1을 전송->48,49값을 받음
- IOT 프로그램시 하드웨어 값을 주고받을 때 if(var1 == 48) {구현내용}
- 공유기가 하위로 가질 수 있는  사설 IP는 공유기 자기IP + 255개(여유분) =256개 인터넷이 가능
- 영어인코딩은 아스키코드로 다 표현이 가능 
- 단, 한글 인코딩, 영어 인코딩, 중국어/일본어 인코딩등등은 아스키코드로 다 표현을 못함 그래서 유니코드 등장
- Hex(16진수), Dec(10진수), Char(문자) = 127개 =아스키 문자의 크기(컴퓨터문자와 사람의 문자를 1:1매칭)
- Oct(8진수), Bit(2진수)
- 아스키코드 7비트코드(127글자) -> ANISI코드-8비트(256글자) -> Unicode(65636글자)-UTF8
- UTF8mb4(이모지까지 포함: 이모티콘+이미지)
- 자바언어를 한다는 것은 컴파일 후 실행이 된다는 것 
- 자바스크립트(파이썬)는 그냥 실행해서 프로그램을 만듦 ->실습예정