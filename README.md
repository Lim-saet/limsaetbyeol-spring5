####작업예정
-


#### 20210601 화 작업
- 에러 404(file not found 경로 이상일때), 500(자바프로그램에러)
- 프로젝트 버전 올리기 -> 외부라이브러리 부분의 버전을 올림 - 메이븐 컴파일러 -> pom.xml 버전을 관리  메이븐은 수정 및 추가-> maven 메뉴에서 maven update
- Controller클래스에서 생성한 변수 사용(자바)model객체전송(스프링) return home -> board_list.jsp 출력 
- 출력하는 방식 1: 25년전부터 있던 EL(Express Language)방식출력-${변수} , <%= ${변수} %>
- 많이 사용하는 방식 JSTL방식(*표준) 사용. 출력, 반복, 조건 등등 다양한 방식 존재 
- 언어를 배우는 순서: 주석> 디버그하는방법> 변수> 메서드(함수)> 클래스  > MVC모델
- 디버그하는방법: 자바(System.out 이용해서 콘솔창에 출력)
- 스프링에서는 logger(로거)를 사용해서 디버그 내용을 출력 
- 스프링이 관리하는 클래스(빈))의 종류 3가지 (사용법은 개발자가 만드는 클래스명 상단에 입력)
- 1. @Controller 클래스 빈: 라우터역할 메서드를 만듦 (라우터역할의 클래스 가능)
- 2. @Service 클래스빈: 비지니스로직 메서드를 만듦(개발자위주의 기능)
- 3. @Repository 클래스빈: Model처리 메서드를 만듦(DB핸들링외부클래스사용)
- 위 3가지의 @를 사용하는 클래스는 DI(객체생성-의존성주입), AOP, Ioc(제어의 역전-자동메모리관리)
- 4장패키지와 예외처리실습
- 프론트 개발자가 작업한 결과를 백엔드 개발자가 확인
- 일괄 바꾸기 1 "/home -> "/resources/home 
- 일괄 바꾸기 2 '/home -> '/resources/home


- ERD기준으로 게시판UI마무리
- VS code 작업한 html를 이클립스에 배치(프론트개발자가 작업한 결과를 백엔드개발자가 받아서 배치)
- resources 폴더에 static 컨텐츠(html,css,js,font) 배치
- 오늘부터 VS code-> 이클립스에서 작업시작
- 관리자단 AdminLTE적용-스프링시간 선택 후 아래 작업진행예정
- (회원관리CRUD-jsp, 게시판생성관리 CRUD-jsp)
- html을 분해(1개의 페이지를 2개로 분해 1.header.jsp, 2.footer.jsp)
- 이클립스로 작업한 html 내용을 -> response 폴더(admin,home,root파일까지)로 배피
- 스프링 작업의 시작

#### 20210531 월 작업예정
- 토드(sql디벨러퍼와 비슷한 상용)에서는 버튼으로 포워드엔지니어링이 처리
- 무료 sql디벨러퍼에서는 버튼x DDL문을 실행해서 포워드엔지니어링을 처리 
- 참고, mysql용 워크벤치는 무료이지만 버튼으로 포워드 엔지니어링이 가능
- sql 쿼리 3가지로 분류
- 초기 DDL문: Data Definition Language 데이터 정의 언어 Create table문
- DCL문: Data Control Language 데이터 제어언어 commit, rollback
- DNL문 : Data Manufacture Language 데이터 조작언어 CRUD 쿼리
- ERD 그림을 만든 것을 물리테이블로 FORWARD: forward 엔지니어링
- 데이터 딕셔너리를 모델과 동시화: 자료사전(데이터의 데이터)을 DB테이블과 동기화
- 데이터 딕셔너리는 메타데이터와 동일
- 물리테이블을 ERD 그림으로 만드는 것: reverse 엔지니어링(기존DB분석시 사용)
- 스프링 시큐리티는 2단계  구현예정
- 1.인증 로그인인증(ENABLED) : AUTHENTICATION (로그인x글쓰기x관리자x)
- 2.권한체(levels): AITHORITY (관리자-admin,URL 접근가능, 일반회원은 사용자 홈페이지에서 공지사항x. 갤러리만 사용가능)
- 1:n관계 = 게시물1개에 댓글은 n개가 달릴수있음
- E-R다이어그램은 그림일뿐, 물리DB(테이블)은 ERD기준으로 생성가능
- PK를 AI(Auto Increment 자동증가)로 만들기: 오라클(시퀸스객체로 기능구현), Mysql(AI라는 필드속성으로 처리)
- ERD에서 Relation 생성: 게시판타입테이블(부)과 게시물관리테이블(자)의 관계를 생성 
- 부자의 관계는 부모의 PK를 기준,자식에게는 FK(Foreign Key)로 관계를 맺음
- 게시판타입: notice, gallery 2가지가 존재한다면,
- Relation 관계가 필요한 이유: 게시물은 공지사항이나 갤러리 게시판이 아니면, 개발자가 예외처리를 하지 않아도 다른 게시판으로 등록하는 상황이 발생 되지않게됌 
- 데이터 무결성 유지하는 역할 (외래키 관계)
- 필드데이터형3: Timestamp(시간도장) 년월일시분초밀리초, Date(년월일까지)
- 필드데이터형2: CLOB(CHAR LONG BYTE) 글 내용이 많을 때 사용하는 데이터 형태 
- 필드 데이터형: VARCHAR2(2바이트를 1글자-한글), VARCHAR(1바이트 1글자-영문전용)
- 테이블 구성: 필드(컬럼,열)=테이블의 세부 멤버변수(자바vo클래스의 멤버변수)
- 필드구성: Primary(주키,기본키,고유키)=테이블영역에서 고유한 ID를 말함(중복되지 않는 값)
- PK 예시(개인을 식별할 수 있는 값): 로그인ID, 개인이메일주소, 주민번호 등, 게시판 타입
- RDBMS(Relation Data Base Management System): 관계형데이터베이스관리 시스템 
- 오라클: 테이블스페이스(TableSpace) = 스키마(Schema:Mysql) = 데이터베이스(DB)-MS-SQL
- 설치시 암호는 apmsetup으로 통일 
- EntityRelationDiagram(ERD-객체관계그림) : Entity = 테이블
- 데이터 모델: Model Object를 형상화 시킨것을 모델이라고 함 데이터베이스를 말함
- MVC 스프링프로젝트에서 M이 Model이고, 스프링프로젝트 구성중에 DB를 가리킴
- 참고로 V는 view고 jsp를 말함
- 참고로 C는 Controller고 클래스를 말함


#### 2021-05-28 금
- 추상클래스 실습은 오늘, 인터페이스 실습은 스프링에서
- extends 관계클래스에서 this.(현재클래스), super.(부모클래스)
- 다형성? 메서드 @오버라이드(상속), 메서드 오버로드(동일함수명의 파라미터의 개수, 종류 틀린 메서드)
- 오버라이드: 상속받아서 재정의 메서드 @오버라이드 = 다형성 구현했음
- 오라클 11g ExpressEdition 설치예정
- SQL(structured query language): 구조화된 질의 언어(오라클서버) -> 답변 
- QueryString: URL에서 전송하는 값(서버에 질의문)을 문장으로 저장한 내용  ?로 시작 
- CommandLineInterface : SQL*Plus 터미널화면으로 SQL쿼리실행 x
- GraphicUserInterface: SQL디벨러퍼 윈도우화면 에디터에서 SQL쿼리 실행 O
- SQL Developer 프로그램으로 ERD 다이어그램그림으로 프로젝트 구조 제작 예정
- EtityRelationDiagram: 테이블 관계도형(아래)
- 프로젝트 진행: 발주(클라이언트) -> 수주(개발사) ->디자인UI(Client-Dev)->ERD(이사,팀장) -> 코딩시작(ERD보면서+UI소스프로그램입히기)
- ERD에서 SQL쿼리가 생성-> 물리테이블을 생성
- 첨부파일->게시판테이블(부모)<-댓글테이블(자식)
- 자바앱에서는 객체를 생성 후 사용이 끝나면 메모리에서 삭제하는 명령어 필수 
- 객체를 메모리에서 삭제하는 법:  Object = null; 
- 스프링에서는 내장된 가비지컬렉터(쓰레기모음)가 자동실행 사용하지 않는 객체를 자동으로 지워줌 
- 위와 같이 개발자가 하던 메모리관리를 스프링의 대신 = IoC(Inversion Of Control)제어의 역전
- 스프링 특징 3가지 (IoC, API,DI)
- 수업시작전, static메서드와 객체의 멤버매서드 비교설명
- Step2클래스에서 MeberService 클래스에 직접접근해서 메서드를 실행하려면 static으로 변경(컴파일시 실행가능한 상태로됨=메모리에 로딩)해야 함. 대신, memberServie객체을 이용해서 메서드에 접근할때는 (호출시=런타임시 실행이가능한 상태로됨=메모리에 로딩)
- 클래스와 상속에 대해서 이론 및 실습
- https://github.com/miniplugin/spring5-kimilguk/blob/master/src/test/java/kr/or/test/ClassApp.java

#### 20210527 목 작업예정
-3장 객체과 클래스 부터 시작

#### 20210527 목
- 3장 객체와 클래스부터 시작
- 스프링에서는 클래스 extends 상속보다는 인터페이스 implements를 더 많이 사용함
- abstract 클래스(추상클래스): 구현내용 없이 메서드 명만 있는 클래스
- 메서드명만 있기 때문에(구현내용이 없기 때문에) 객체로 만들 수 없는 클래스 
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