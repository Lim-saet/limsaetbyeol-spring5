#### 작업예정
-스프링프로젝트 순서
1.Junit > 마이바티스(DB핸들링)> AOP(다중게시판기능)> 페이징기능** > 검색기능 > 트랜잭션(게시판)> 첨부파일(파일업로드다운로드)기능 배열** > 스프링시큐리티(로그인인증/권한체크)** > 댓글처리(RestAPI생성)
2.>댓글처리(RestApi-백엔드,Ajax처리-프론트단) >네이버아이디로그인(외부API사용) > 해로쿠클라우드배포
3. 문서작업(화면기획서XLS 제작, 화면설계서PPT 제작)
- 헤로쿠 클라우드에 배포할때 매퍼폴더의 mysql폴더내의 쿼리에 now()를 date_add(now(3),interval 9 HOUR)변경예정

#### 0716금 작업
- 수업전 헤로쿠 배포 후 어제 작업한 결과 확인
- jsp 템플릿인 tiles(타일즈) 사용
- jsp 템플릿 tiles, siteMesh(사이트매쉬), velocity(벨로시티) 등이 있음
- 현업에서는 위 3가지 템플릿 중 1가지는 항상 사용해서 대표적으로 타일즈를 실습할 예정
- 위 3가지 구조는 비슷하기 때문에 1가지만 아셔도 다른 jsp 템플릿 적용시 응용가능
- 타일즈역할: jsp템플릿이라하고 jsp구조(레이아웃)을 체계적으로 관리하는 모듈
- include(header.jsp,footer.jsp)를 대체
작업순서:
- 1. pom.xml 타일즈 모듈 라이브러리 추가
- 2. tiles-context.xml 타일즈설정파일 추가
- 3. 위 설정파일을 기준으로 titles폴더 및 layouts폴더 생성 후 layout.jsp생성
- 4. 기존 home/include 폴더의 header.jsp 와 footer.jsp 파일 복사해서 그대로 사용
- 5. 기존 home/index.jsp 파일 그대로 복사해서 tiles/index.jsp로 복사해서 @include 삭제만 처리
- 6. servlet-context.xml 에서 타일즈용 뷰리졸버 빈 추가
- 7. HomeController 에서 기존 @RequestMapping 복사해서 타일즈용으로 추가
- -------------------------------------------------------
- 알고리즘 다이어그램기반으로 자바코딩테스트예정(깃 it강의저장소자료이용).

#### 앞으로 남은 1주일간 작업예정내용 정리.
- 사용자단 메인페이지(대시보드) 작업예정.
- 문서작업(제출용)예정.
- 사용자단 네이버아이디로그인 처리(10.외부RestAPI구현).
- 관리자대시보드에서 회원ID 이미지업로드 및 보이기 처리예정.(기술참조 https://github.com/miniplugin/kimilguk )
- jsp템플릿인 tiles(타일즈), siteMesh(사이트메쉬), velocity(벨로시티) 등이 있습니다.
- 현업에서는 위 3가지 템플릿중 1가지는 항상 사용하기 때문에 대표적으로 타일즈를 실습할 예정입니다.
- 위 3가지 구조는 비슷하기 때문에 1가지만 아셔도 다른 jsp템플릿 적용시 응용가능합니다.
- 알고리즘 다이어그램기반으로 자바코딩테스트예정(깃 it강의저장소자료이용).

#### 데이터의 이동
- VO클래스의 이동: 매퍼쿼리<->DAO<->Service<->Controller<->jsp

#### 변수값(데이터) ReplyVO데이터 클래스를 기준으로
JSON데이터: 크롬에서 부메랑으로 List형태의 데이터확인
JSON데이터구조: ArrayList(표) + HashMap(Key:Value)

```
{
    "rno": 4,
    "reply_text": "부메랑댓글 입력테스트",
    "replyer": "admin",
    "reg_date": 1626310996371,
    "update_date": 1626310996371,
    "bno": 2
},
{
    "rno": 3,
    "reply_text": "부메랑댓글 입력테스트",
    "replyer": "admin",
    "reg_date": 1626310964420,
    "update_date": 1626310964420,
    "bno": 2
}
```

ArrayList데이터형:List replyList = new ArrayList();//DB쿼리결과
위 ArrayList구조: List(인터페이스) > ArrayList(임플리먼트클래스-데이터클래스)
HashMap데이터형:Map<String,Object> mapData = new HashMap<String,Object>();
위 HashMap구조: Map(인터페이스-메서드명) > HashMap(구현클래스)
Hash해시태그: 그물망(해시)=#=좌표(x,y)=(Key:Value);

#### 20210715(목) 작업예정.
- 문서작업(제출용)예정.(설명 후 작업시간 드릴 예정, 작업시간중 네아로 않되는 분 확인)
- 관리자대시보드에서 회원ID 이미지업로드 및 보이기 처리
- D:\egov\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\limsaetbyeol-spring5\resources\profile
- URl로 접근할때는 http://localhost:8080/resources/profile/admin22 
- jsp템플릿인 tiles(타일즈) 사용.


#### 20210714(수) 작업예정.
- 네아로 로그인 부분 마무리.: 외부API이고, 네이버 개발자들이 만든내용.
- 요청 URL생성 -> 인증체크(네이버로그인컨트롤러 메서드추가) -> 성공/실패/취소시 callback URL로 이동해서 처리하는 메서드 생성
- 문서작업(제출용)예정.
- 관리자대시보드에서 회원ID 이미지업로드 및 보이기 처리예정.
-jsp템플릿인 tiles(타일즈) 사용..

####20210709 금 작업예정
- 게시물 CRUD시 본인글 인지 확인 하는 메서드를 공통으로 구현하기(많이사용하는 방향으로)
- 사용자단 댓글서비스 작업.
- Ajax소스는 프로그램이기 때문에, 디자인과 크게 관련없기때문에 admin단 board_view에 있는 ajax코드를 가져다가 사용면서 커스터마이징($.ajax에서 complete,beforeSend, async 속성들)
- ajax에서 디버그하는 방법
- 사용자단 메인페이지(대시보드) 작업예정.
- 헤로쿠 30분 지나서 휴면모드로 들어가기전, 잠깨우는 기능 추가예정.(스프링스케줄러사용)
- 순서: 외부 모듈 라이브러리 추가 (pom.xml에서) -> 메이븐업데이트 -> 
- 순서2: 스케쥴링할 메서드 생성(herokuJobmethid) -> root-context에서 스케줄링 스프링빈 생성
- 이력서 작업한 URL을 포트폴리오로 적어 놓을때, 면접관이 1분정도 대기시간이 필요.
- 헤로쿠클라우드는 처음접속시 1분정도 대기시간이 필요함(이력서에 명시)

#### 20210708 목 작업예정
- 사용자단게시물관리 CRUD중 Delete마무리 후, Update 실습
- 우리나라 스프링기반 솔루션을 만들던 시기(스프링버전2.5 - 2015년 전후) REST-Api(jsonview방식), 현재(2021년 스프링버전 5.x 사용) Rest-Api(@RestController방식)
- properties파일을 hsql,cloude를 1개 cloude로 통일
- JsonView방식(고전방식의 RestAPI처리) 실습.
- JsonView: 컨트롤러에서 뷰단을 반환할때 .jsp(생략)파일명으로 반환(View리졸버의 기본형식)
- servlet-context.xml에 위 View리졸버라는 스프링빈 설정이 있습니다
- 리퀘스트 매핑 요청에 대한 뷰단을 해석(바인딩해줍니다)
- 위 기능을 RestApi로 대체해서 뷰단을 반환할때 jsp로 반환하지 않고 Json으로 뷰를 반환하는 것을  JsonView 방식이라고 합니다
- JsonView방식 사용방법: 1. servlet설정에 스프링빈을 등록합니다(클래스는 스프링 프레임워크에 내장,pom.xml외부 라이브러리 모듈을 가져올 필요없음)
- 사용자단에서는 글수정을 글쓴 보안글만 삭제가능하게 기능추가
- 사용자단 댓글 서비스 진행예정
- 사용자단 메인페이지(대시보드) 작업예정.
- 헤로쿠 30분 지나서 휴면모드로 들어가기전, 잠깨우는 기능 추가예정.(스프링스케줄러사용)
- 이력서 작업한 URL을 포트폴리오로 적어 놓으실때, 면접관이 1분정도 대기시간이 필요.
- 헤로쿠클라우드는 처음접속시 1분정도 대기시간이 필요함(이력서에 명시)

#### 20210707 수 작업
- 헤로쿠는 30분간 아무작업이 없으면 휴면상태(컨테이너가 내려감) -> 활성상태(컨테이너가 올라감)
- 컨테이너가 올라가면, 클라우드가 자원을 차지하기 때문 휴면에서 활성화될때 무료버전은 저장소가 신규생성됌 
- 사용자단 게시물관리 CRUD작업 추가진행.
- 사용자단 메인페이지(대시보드) 작업예정.
- 헤로쿠 30분 지나서 휴먼모드로 들어가기전, 잠깨우는 기능 추가예정.(스프링스케줄러사용)
- 이력서 작업한 URL을 포트폴리오로 적어 놓을때 면접관이 1분정도 대기시간이 필요

#### 20210706 화 작업
- Hsql데이터베이스는 특징-메모리DB이기 때문에 보통서버를 리스타트하면 DB가 리셋됨(초기화)
- Hsql은 트랜젝션이 안됌
- 데모사이트나 프로그램의 프로토타입(데모프로그램) 생성시 주로 사용
- 메모리 DB를 우리프로젝트에서는 file로 변경해서, 톰캣을 리스타트해도 없어지지 않게 처리했음
- 1개 프로젝트: 3개월, 5-7명(개발인원), 1Man/1Month 금액을 산출
- 280~650: 400만= 1달 2800만/1달=3달=8400만+1년2000만 =1억 보통이상
- 7명: PM(프로젝트매니저)1명-코딩없이 클라이언트와 소통,PL(프로젝트리더)1명, 개발자(3명),디자이너(프론트엔드개발1명)+문서작업(1명)
- 실습: CRUD기본->웹프로그램을제작(구체적인것은나중에)
- 수업전 mysql폴더의 replyMapper.xml 쿼리파일에서 아래 내용대로 변경합니다.
- [수정전] limit #{pageVO.queryStartNo}, #{pageVO.queryPerPageNum}
- [수정후] limit #{queryStartNo}, #{queryPerPageNum}
- JUnit(스프링테스트방법) - 부메랑(RestApi컨트롤러테스트방법)
- 스프링백엔드단(logger,이클립스콘솔에서디버그)
- 스프링RestApi단=Ajax(로거디버거로하지않고, RestApi리턴값으로 디버그)
- 관리자단 대시보드 작업. 기반작업에 사용-사용자단 메인 최신갤러러, 최신공지사항 출력에 이용
- 컴파일 된 jsp(import 자바변수값이 들어감)와 컴파일되기전 jsp(include 자바변수값이 안들어감)
- 사용자단 게시물관리 CRUD작업
- 사용자단 메인페이지(대시보드) 작업예정. 

#### 20210705 월 작업예정
- App name = Host name = 호스트네임. herokuapp.com(호스트네임<도메인네임)
- 클라우드 콘테이너 생성시 위와 같은 방식으로 호스트네임 도메인을 부여합니다
- 헤로쿠 클라우드에서 App 생성
- Deploy에서 에러: No web processes running
- 현재 프로젝트에 클라우드용 설정파일이 필요 = 헤로쿠에서 Profile 확장자없는 설정파일이 필요
- 위 Procfile에서 web processes running 시키는 라인이 추가 되어야 함 
- 스프링에서 작업해서 배포한다는 의미 : ALL or Not ALL
- PHP는 작업한 개별차일 1개씩 수정해서 올리는 방식(워드페레스, 그누보드 등)
- 작업한 파일이 1개라도 1개만 올리는 것이 아니고 모든파일을 컴파일해서 패키징(war)한 후 업로드합니다
- hsql 외부모듈 pom.xml에 추가(자바기반 DB사용가능)
- 우리프로젝트에 HsqlDB를 생성.(메이븐에서 Hsql모듈을 업데이트하면, 사용가능)
- 오라클은 로컬에서 개발, HsqlDB는 헤로쿠 클라우드용을 개발할 수 있도록 root-context.xml에서 설정예정.
- 아래 3가지가 root-context에 추가됩니다
- 1. hsql용 jdbc
- 현재 까지 작업한 소스를 여러분 이름 도메인으로배포예정 limsaetbyeol-spring5.herokuapp.com
- 관리자단 대시보드 작업예정.
- 사용자단 게시물관리 CRUD작업예정.
- 사용자단 메인페이지(대시보드) 작업예정.

#### 20210702(금) 작업예정 
- 수정/탈퇴(마이페이지) JSP기능 추가 마무리
- 사용자단 회원가입 작업ok
- form폼에서 name은 VO/매퍼쿼리 필드명 동일, id는 선택해서 jsp(UI)단에서 제어(j쿼리)할때 사용
- 사용자단 에러 발생시 이쁘게 보이게 화면처리예정
- ------------------------------------
- 헤로쿠 클라우드에 배포작업예정
- 헤로쿠 클라우드는 미국의 회사로서 컨테이너를 제공하는 회사
- 컨테이너는 리눅스OS>톰캣WAS>자바JVM>스프링>컨테이너에 포함됨 기본
- 외부서버(DB)는 Add on 이라는 이름으로 사용가능
- 무료: PostgeresDB(조건), 마리아 DB(신용카드등록필수)
- 유료: Mysql(유료)
- HsqlDB로 연동해서 헤로쿠에 배포예정     http://hsqldb.org
- 100% Java Database: 임베디드DB, 메모리 DB, 서버를 설치할 필요x Hsql이라는 Maven모듈만 있으면 가능
- 프로토타입 작업시 주로 사용(특징: 쿼리는 Mysql과 99% 동일) 
- 관리자단 대시보드 작업예정
- 사용자간 게시물관리 CRUD작업예정
- 사용자단 메인페이지(대시보드) 작업예정
- error spring_error.jsp 만듦
- 위 jsp를 에러발생시 (Excetion) 무조건나오게 차리: AOP@ControllerAdvice로 구현됩니다
- 위 어드바이스컨트롤러에서 에러메세지를 캐쳐해서 jsp에러페이지로 보내서, 에러메세지를 이쁘게 확인
- 404에러는 컨트롤러에서 발생되지 않습니다. 그래서 별도파일을 만들어야합니다
- 톰캣서버에서 발생되는 에러코드 404이기때문에 web.xml에서 설정을 추가합니다.
- 404코드가 발생시 error_404.jsp와 바인딩되는 설정입니다.
- 홈컨트롤러에서 Get/home/error/error_404 경로추가

#### 20210701(목) 작업예정.

- 어제 작업한 security-context를 데이터 변수값의 이동기준으로 다시 설명.
- 수업 시작전 깃허브 암호정책 변경으로 토큰사용하는 방법 공유, 8월부터 변경됨.
- 람다식사용예 : https://github.com/miniplugin/SQLite-kimilguk/blob/master/app/src/main/java/com/human/sqlite_kimilguk/MainActivity.java
- 어제 시큐리티적용 부분 확인(web.xml에서 누락된 부분 모두 추가)

```
<!-- 스프링 시큐리티때문에 필터(걸러주는)추가 -->
<filter>
	<filter-name>springSecurityFilterChain</filter-name>
	<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
</filter>
<filter-mapping>
	<filter-name>springSecurityFilterChain</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>
```

- 어제 시큐리티 context 누락된 부분 추가(security-context.xml)

```
<security:authentication-provider>
	<security:password-encoder ref="passwordEncoder" />
</security:authentication-provider>
<!-- 위 쿼리에서 사용할 패스워드 암호화 id passwordEncoder 빈 클래스를 생성(아래) -->
<bean id="passwordEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder" />
```
- 스프링시큐리티 로그인및 권한체크 설정 후 사용자단 로그인 구현 예정.(관리자단 끝 이면서, 사용자단 시작): 사용자단 로그인 / 로그아웃 기능 처리ok.
- 사용자단 회원가입, 수정/탈퇴(마이페이지) JSP기능 추가예정.


#### 20210630(수) 작업예정.
- 댓글 Delete 구현 후 마무리.
- 스프링시큐리티 로그인및 권한체크 설정 후 사용자단 로그인 구현 예정.(관리자단 끝 이면서, 사용자단 시작)
- 사용자단 회원가입, 수정, 탈퇴 JSP기능 추가예정.

#### 20210629 화 작업예정
- json데이터(1개레코드:K:V무제한형태)가 자바의 List데이터(1개레코드=K:V제한형)와 대부분 같음 틀린점은 K:V 형태는 같으나 V값이 무제한,제한
- 게시물 상세보기 페이지에는 
- ㄴ게시물 관련 내용 : 컨트롤러에서 보낸 model객체에 담긴 변수값을 사용
- ㄴ댓글 관련내용: Rest 컨트롤러에서 보낸 ResponsEntity객체에 담긴 변수값을 사용
- RestAPI가 주로 사용되는 곳은 1페이지로 서비스가 이루어지는 곳에서 주로 RestAPI를 사용
- 데이터를 시각화하는 페이지에 주로사용: 구글맵,네이버맵기반의 데이터를 시각화해서 수익창출서비스
- RestAPI가 스프링과 노드js 연동하면 + 구글맵, RestAPI 실시간으로 결과 공유할 수 있게 만든 것
- 수업전 아래 내용 확인 후 진도 나갈 예정 입니다.
- reply컨트롤러에서 requestMapping 밸류값 넣을때 절대경로인 /로 시작하시는 것이 맞습니다.
- Rest컨트롤러에서 CRUD중 Delete마무리.ok
- jsp에서 1페이지만 작업하면  $.ajax를 이용해서 RestAPI서버 사용. -댓글 마무리...
- $ajax로 CRUD를 구현할때는 전송값은 json데이터(submit으로 안보냄)로 보내고 (form태그가 필요없음): submit은 폼태그가 있을때만 작동되는 브라우저 내장명령입니다. 
- , 받을때는 List(json),CUD(문자열)
- 댓글 RUD는 모달(팝업)창에서 작업시작
- 스프링시큐리티 로그인및 권한체크 설정 후 사용자단 로그인 구현 예정.(관리자단 끝 이면서, 사용자단 시작)
- 사용자단 회원가입, 수정, 탈퇴 JSP기능 추가예정.

#### 20210628 월 작업예정
댓글 VO제작->매퍼쿼리제작->DAO클래스제작->Service클래스제작/여기까지-
- -------------------------------------------------------
- >@RestController클래스제작: 일반 컨트롤러와 다르게 반환값이 body로 출력됌
- >크롬부메랑테스트(JUnit테스트대신)->JSP제작(1페이지CRUD처리Ajax이용)
- 위 작업전, 크롬 확장프로그램 중 부메랑을 한번 실습해 봅니다 id_check 메서드로
- 네트워크로 자료를 전송하는 방식: SOAP(구버전 프로토콜), REST레스트(HTTP방식으로 헤더에 자료를 담아서 보내는 방식 - 신버전)
- Endpoint: 마이크로 서비스는 RestAPI로 구현되고, 요청하는 URL을 엔드포인트라고 합니다 
- 엔드포인트(URL주소)에는 데이터를 전송할때, 쿼리스트링으로 보내지 않는 방식이 트렌드 
- 예: 옛날에는 /reply/reply_list?bno=59&
- 예: 요즘에는 /reply/reply_list/{게시물 번호값}/{페이지번호값}
- 결과, /reply/reply_list/59/1 (목적은 구글검색에 쉽게 노출시키기 위해서)
- (트렌드: 마이크로서비스, 기존 컨트롤러(게이트웨이)를 모두 RestController(Rest게이트웨이)변경이 필요)
- 스프링시큐리티 로그인및 권한체크 설정 후 사용자단 로그인 구현 예정.(관리자단 끝 이면서, 사용자단 시작)
- 사용자단 회원가입, 수정, 탈퇴 JSP기능 추가예정.


####20210626 금 작업예정
- Pull이 안되는 원인: 로컬 이클립스에서 commit할 것이 남아있으면 pull이 안됌 해결책:
- 게시물관리 Create 작업 마무리.
- 고전 CRUD 와 RestFull(API)방식 차이점: 고전(화면이 이동하면서 CRUD처리),Rest방식
- 관리자단 댓글관리 CRUD 처리(6.RestAPI서버구현,JUnit대신에 크롬부메랑으로 테스트)
- 댓글VO제작->매퍼쿼리제작->DAO클래스제작->Service클래스제작./여기까지->@RestController클래스 제작->크롬부메랑테스트->JSP제작(1페이지CRUD처리 Ajax이용)
- 스프링시큐리티 로그인및 권한체크 설정 후 사용자단 로그인 구현 예정.(관리자단 끝이면서, 사용자단 시작)
- 사용자단 회원가입, 수정, 탈퇴 JSP기능 추가예정.

#### 20210625 목 작업예정
- [복습]오늘 작업한 첨부파일 처리도 데이터 변수의 이동상태나 변수값이 제일 중요합니다.
핵심은 아래와 같습니다. Attach테이블에서 select쿼리 결과 테이터 구조는 아래와 같습니다.
List<AttachVO> delfiles = [
{"save_file_name":"abc1.jpg","real_file_name":"한글이미지1.jpg","bno":"bno10"},
{"save_file_name":"abc2.jpg","real_file_name":"한글이미지2.jpg","bno":"bno10"}
]
- file.getBytes() 설명 포함 board_update메서드 리뷰 후 수업진행.
- 작업순서: CRUD -> U 작업.ok
- Creat작업
- update: updateBoard(서비스)참조 -> board_update(컨트롤러)작업+jsp작업
- 업데이트 이후엔 파일업로드 구현 후 /download 컨트롤러 실습예정.
- 관리자단 댓글관리 CRUD 처리(6.RestAPI서버구현,JUnit대신에 크롬부메랑으로 테스트)

#### 20210624 수 작업예정
- 시큐어코딩 방지메서드: <(O|o)bject...->&lt;object (목적은 코딩태그를 특수문자로 변경하는 메서드)
- 실행되지 않는 코드가 생성됨
- 세션사용법: 겟(Get),셋(Set),삭제(Remove) 하는방법
- 세션생성법: session.setAttribute("세션변수명","값");//로그인 세션변수 생성
- 세션 값 불러오기: session.getAttribute("세션변수명");
- 세션 삭제하기: session.removeAttribute("세션변수명");//변수삭제
- 전체 세션 삭제하기: session.invalidate();//전체세션변수명을 삭제 = 세션초기화
- 수업전 작업예정: ie11이하계열에서 한글 검색 후 페이지 선택시 400에러발생(크롬계열은 문제없음)-AOP로처리.
- 작업순서: CRUD -> UC 작업예정.
- 업데이트 이후엔 파일업로드 구현 후 /download 컨트롤러 실습예정.
- update: updateBoard(서비스)참조 -> board_update(컨트롤러)작업+jsp작업
- 관리자단 댓글관리 CRUD 처리(6.RestAPI서버구현,JUnit대신에 크롬부메랑으로 테스트)

```
내일 수업전 실숩 순서는 아래와 같습니다.
아래 순서대로 하시고, 개선된 기능은 수업시 알려 드리겠습니다.^^
ie에서 한글검색과 페이징처리 함께사용시 에러상황 처리
AOP로 처리 되었습니다.
-#1 AOP에서 아래내용 추가
String search_keyword = null;
search_keyword = pageVO.getSearch_keyword();
if(search_keyword != null) {//최초로 세션변수가 발생
   session.setAttribute("session_search_keyword", search_keyword);
}
if(session.getAttribute("session_search_keyword") != null) {
   search_keyword = (String) session.getAttribute("session_search_keyword");
   if(pageVO != null) {//Set은 pageVO가 null아닐 경우만 실행되도록
      pageVO.setSearch_keyword(search_keyword);//검색목표달성:여기서 항상 값을 가져가도록 구현됩니다.
   }
}
-#2 member와 board 뷰jsp파일에서 아래 내용을 일괄 삭제
&search_keyword=${pageVO.search_keyword}
-#3 AdminController에서 아래 내용 일괄 삭제
+"&search_keyword="+pageVO.getSearch_keyword()
-#4. 기능개선 추가
AspectAdvice클래스 PageVO가 메서드매개변수 인스턴트인 조건시 추가
if(pageVO.getPage() == null) {
 session.removeAttribute(“session_search_keyworb”);
}
또는
검색창에 ${session_search_keyword}추가
그리고, include폴더 header.jsp 에 링크값에 ?search_type= 추가
```


####20210622 화 작업예정
- 정방향으로 개발시작.VO제작.->매퍼쿼리제작-> DAO클래스제작->Service 클래스 제작 -> Controller+jsp
- 작업순서: RUD -> C
- Read: readBoard(서비스) -> board_view(컨트롤러) 작업+jsp작업
- 관리자단 댓글관리 CRUD 처리(6.RestAPI서버구현,JUnit 대신에 크롬부메랑으로 테스트)
- 에러상황: ie11이하 계열에서 검색 후 페이지 선택시 400에러발생(크롬계열은 문제없음)
- 스프링시큐리티: 로그인정보가 발생=세션, 즉 로그인정보(세션)이 없으면 홈페이지 가도록 작업예정(다음주)

#### 20210621 월 작업예정
- 관리자단 게시물관리 CRUD 처리(4.파일업로드구현,5.트랜잭션구현ok)
- @Service 클래스 마무리 ok
- 정방향으로 개발시작.VO제작.->매퍼쿼리제작-> DAO클래스제작->Service 클래스 제작 -> Controller+jsp
- 트랜잭션: 여러개의 메서드를  1개의 메서드를 1개처럼 처리하게 구현하는 애노테이션(인터페이스)을 사용-목적:데이터 무결성 유지
- 1단어로 표시하면 All or NotAll(모두 실행되던지, 에러발생 모두 싱행이 되지 않던지)
- root-context와 servlet-context 설정파일에 트랜잭션과 파일업로드 설정처리
- @Controller 클래스 추가(파일업로드/다운로드구현) >jsp화면처리
- @Service 트랜잭션 기능 추가
- 관리자단 댓글관리 CRUD 처리(6.RestAPI서버구현,JUnit 대신에 크롬부메랑으로 테스트)
- AOP기능 중 Aspect기능의 설정은 servlet-context.xml에 위치필수

#### 20210618 금 작업예정
- 검색처리는 멤버쿼리에서 작성한 내용 붙여넣고, 다중게시판용 필드조회조건 추가예정
- 관리자단 게시물관리 CRUD 처리(4.파일업로드구현,5.트랜잭션구현).
- 게시물관리 시작: 다중게시판? 1개 페이지로 board_type 변수를 이용해서 공지사항,겔러리,QnA... 구별해서 사용.(쿼리스트링이 길어져서 @Aspect로 사용)
- 정방향으로 개발시작.VO제작.->매퍼쿼리제작-> DAO클래스제작->Service 클래스 제작
- 상황1: 두사람이상이 동시에 글을 쓰면서 첨부파일을 추가하는 상황
- 실행순서- 사람1:insertBoard->bno(101)-> 첨부파일을 insertAttach ->bno필요
- 사람 2- insertBoard-> bno(102) -> 위에 있는 사람1 갖다가 사용하는 경우는?
- 해결책: @Transantional을 insertBoard메서드를 감싸주면, 간단하게 해결
- 해결책2: insertBoard 쿼리에 return 값을 bno 받아서 insertAttach를 실행하게 처리
- @Service까지는 DB(테이블) CRUD합니다
- 그러면, 첨부파일은 @Controller에서 업로드/다운로드 로직 여기서 처리  그래서 코딩이 제일 지저분함
-============================================================

####20210617 목 작업예정
- [복습]: 스프링의 기능(Ioc-제어의 역전: 객체의 메모리관리 개발자가 x, 스프링이 대신), DI(의존성주입,@Injaect)
- 수업시작 전 UI디자인 과제물 확인 후 진도 나감ok
- 관리자단 게시판 생성관리 RU 페이지 마무리예정 ok.
- 관리자단 왼쪽메뉴에 게시판종류가 실시간으로 출력이 되어야 하는데 지금은 게시판 생성관리 목록 페이지에서만 보임 (문제점)
- 위 문제를 해결하는 방식으로 AOP기능을 사용합니다 
- 스프링 AspectOrientProgram 구현은  3가지 방식: @Aspect, @ControllerAdvie, intercept(가로채기)태그사용->관전지향프로그래밍을 구현
- AOP용어: 관점지향?-프로그램전체에 영향을 주는 공통의 기능을 적용하는 패턴|기법
- AOP용어: Advice(충고=>간섭)-프로세스작업 중간에 필요한 기능을 끼워넣는 것을 어드바이스라고 함
- Adivce: 포인트 컷->@Before, @After, @Around(간섭,필요한 기능을 끼워 넣는 시점)/우리는 어라운드 실습
- 게시판종류 출력: @ControllerAdvice로 구현(게시판 생성관리 CRUD작업시 실습)
- @ControllerAdvice 실행조건: 컨트롤러 클래스의 메서드에만 Advice(간섭)적용
- 검색시 pageVO처럼 board_type 값을 계속 유지하는 기능: @Aspect로 구현(게시물관리CRUD작업시 실습) 
- @Aspect 장점: 특정클래스의 특정 메서드 실행시(포인트 자동싱행되는 메서드를 지정이 가능
- @Aspect 실행조건: 컨트롤러에 더해서 서비스(실습), DAO클래스의 메서드에도 Advice가 가능 
- 보안-로그인체크,권한체크시: intercept(스프링시큐리티)태그를 사용해서 구현 (로그인기능,권한체크기능 구현시 실습)
- intercept 태그는 스프링시큐리티에서 관리 
-------------------------------------
- 오후 수업전 component-scan태그 위치확인: root-context, servelet-context
- 관리자단 게시판 생성관리 CD처리예정.(3.스프링의 AOP기능구현).
- UI디자인 과제물제출 4교시 예정.ok
- 관리자단 게시물관리 CRUD 처리(4.파일업로드구현,5.트랜잭션구현).
- 게시물관리 시작: 다중게시판이란 1개 페이지 board_type 변수를 이용해서 공지사항,갤러리,QnA등을 입력가능 하게 함  
- 정방향으로 개발시작 VO제작->매퍼쿼리제작


#### 20210616 수 작업예정
- [공지]06-17 목요일(4교시) UI 디자인 시험 있습니다.(화면기획서XLS제작, 화면설계서PPT제출용) 확인 후 수업진행.
- 관리자단 게시판 생성관리 CRUD 처리.(3. 스프링의 AOP기능구현).
- 10년,20년,지금 변하지 않는 것은 변수값의 흐름은 변함이 없음 정방향 개발시작


- 시작.VO->매퍼쿼리->DAO클래스 생성->Service클래스 생성
- 관리자단 게시물관리 CRUD 처리(4.파일업로드구현,5.트랜잭션구현).


#### 20210615 화 작업예정
- 회원관리 CRUD 화면 JSP구현 update(ok) delete(ok), insert(ok)
- 관리자단 회원관리 수정 암호 수정 잘 되는지 확인예정 ok


####20210614 월 작업예정
- 수업접 관리자 회원관리 view 화면구현 마무리 ok
- multipart(첨부파일)라는 폼태그 전송방식을 추가-->commons.fileupload 외부모듈필수(pom.xml에서 의존성 추가)
- 위 외부모듈을 스피링빈으로 등록합니다(servlet-context.xml 하단에 추가)

```
<beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
   </beans:bean>
   ```
- 데이터 변수를 전송할때 GET(URL쿼리스트링기본값)으로 전송받으면, 타도메인에서도 GET으로 접근이 가능합니다
- 쉽게 말하면, 다른 도메인(서버)에서 GET은 검색만 가능 입력,수정,삭제 불가능
- 단, 데이터 변수를 POST(숨김)으로 전송받으면, 타 도메인에서는 접근이 불가능 
- 쉽게말하면 같은 도메인(서버)에서만 POST로는 입력/수정/삭제가 가능 
- GET: Insert (외부사이트 입력폼에서도 입력가능)-쿼리스트링으로 데이터 전송 url?key=value@key2=value2
- POST: Insert (외부사이트에서 입력 불가능, 같은 사이트의 입력폼에서만 입력가능) form의 입력태그(히든스트링)으로 데이터 전송
- 나머지 관리자 회원관리 CRUD 화면 JSP처리. insert(x),view>update, insert

#### 20210611 금 작업예정
- 정방향 개발: 메퍼쿼리>DAO>Service>[JUnit-IoC,DI구현]컨트롤러클래스>JSP
- 역박향 개발(클래스간 이동 빨라서: 정방행으로 개발한 것 
- 수업전 관리자단 회원관리 페이징처리에서 컨트롤러와 calcPage()메서드의 관계 간단하게 확인
- JSTL: Java Standard Tag Library 자바표준태그모듈 JSP에서 자바를 사용하는 표준
- taglib uri(유니폼 리소스 ID-식별값) > url(고유값)
- prefix(접두어), 태그별칭사용 예: <c 시작
- ===========3주간 작업내역 시작(관리자단-제일 손이 많이감)=================
- 관리자단 회원목록 처리 마무리(1.페이징및 검색기능구현).ok
- model을 이용해서 결과를 JSP로 구현.(2.JSP화면은 표준언어인 JSTL로 구현)
- [공지]06-17 목요일(4교시) UI 디자인 시험 있습니다.(화면기획서XLS제작, 화면설계서PPT제출)
- 그래서, 다음주 월요일 점심시간 피곤할떄 현재 프로젝트를 정리하는 문서작업 시간을 갖겠습니다.

- 관리자단 게시판 생성관리 CRUD 처리.(3.AOP기능구현).
- 관리자단 게시물관리 CRUD 처리(4.파일업로드구현,5.트랜잭션구현).
- 관리자단 댓글 CRUD 처리(6.RestAPI기능구현-개발트렌드).
- 관리자단 왼쪽메뉴 UI 메뉴 고정시키기(7.jQuery로 구현).
- 사용자단 로그인 화면 JSP로 만들기.
- 로그인처리 및 관리자 권한체크 기능 추가(8.스프링시큐리티구현).
- ===============3주간 작업내역 끝(07.02 금)================
- ===============2주간 작업내역 시작(사용자단은 관리자단 로직을 사용)===============
- 사용자단 회원가입, 수정, 탈퇴 JSP기능 추가.
- 사용자단 게시판 CRUD 처리.
- 사용자단 댓글 CRUD 처리.
- 헤로쿠 클라우드에 배포(9.클라우드 배포구현 CI/CD 구현). 깃(최신소스)-헤로쿠(배포)
- 문서작업(제출용)
- [실습시간이 가능->알고리즘 다이어그램기반으로 자바코딩테스트]
- [실습시간이 가능->사용자단 네이버아이디로그인 처리(10.외부RestAPI구현)]
- ===============2주간 작업내역 끝(07.16 금)================

#### 20210610 목작업예정
- 컨트롤러를 이용해서 관리자단 회원관리화면 JSP 만들기 진행시작
- JUnit 마치고, 관리자단 회원관리(CRUD) jsp까지는 작업함 이후 앞에 내용참조해서 확장해 나가는 작업이 이어짐
- 수업전 내용 확인 합니다.(아래)
- 쿼리실습에서 .equals함수 사용에 대해서 설명할때,아래 isEmpty메서드와 착각해서 이야기 한 내용이 있어서 정정 합니다.
- 자바에서 객체가 공백 또는 비었는지 비교할때, 예를 들면, 우리프로젝트에서 첨부파일이 있는지 비교할때 아래 처럼 사용하지 않고
- if(save_file_name != null && "".equals(save_file_name))
- 다음처럼 짧게(널과공백체크를 한번에) 사용합니다.(아래)
- if(!save_file_name.isEmpty())
=========================================
- GTM시간(그리니치천문대기준-표준시) - KST 한국시간과는 9시간
- DB서버에 타임좀 설정 Asia/Seoul 되어있으면 그냥 사용
- 만약 위 GTM + 9시간해서 Insert, Update 한국시간으로 사용
- 오라클일때 확인 :
SELECT TO_CHAR(systimestamp + numtodsinterval( 9, 'HOUR' ), 'YYYY-MM-DD HH24:MI.SS.FF4')  from dual;
- Mysql(마리아dB)확인 :
SELECT DATE_ADD(NOW(3), INTERVAL 9 HOUR);
- ------------------------------------
- 업데이트 실습은 회원암호를 스프링시큐리티5 암호화(1234->해시데이터)로 일괄변경 실습예정.
- 정방향 암호화 가능, 역방향 복호화는 불가능(JAVA용 스프링시큐리티암호화,DB용 MD5등)

```
BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
String userPwEncoder = passwordEncoder.encode(memberVO.getUser_pw());
memberVO.setUser_pw(userPwEncoder);
```




####20210609 수 작업예정
- 프로젝트를 진행: 보유기술 70%(솔루션있는업체) + 신기술 30%(개발사도 모름) - 9할 성공
- PageVO.java 클래스 생성 마무리 ok
- Junit에서 위 작업한 내용을 기준으로 selectMember() 테스트진행 ok
- <![CDATA[쿼리]]> : 태그안쪽에 부등호를 사용하기 위해서 문자열 변환 태그를 사용 
- 쿼리에서 변수와 문자열과의 연결할때는 +(자바)x, ,(x), ||(ㅇ)
- JUnit에서 회원관리 나머지 CRUD 테스트 진행 암호화도 실습예정


####20210608 화 작업예정
- 페이징에 사용되는 변수(쿼리변수+VO변수) 아래
- queryStartNo, queryPerPageNum, page, perPageNum, startPage, endPage
- 검색에 사용되는 변수(쿼리변수만): 검색어(search_keyword), 검색조건(search_type)

```
--SQL쿼리 페이징을 구현해서 변수로 삼을것을 정의
--PageVO의 멤버변수로 사용예정
SELECT TableB.* FROM
(
    SELECT ROWNUM AS RNUM, TableA.* FROM
    (
        SELECT * FROM tbl_member
        WHERE user_id LIKE '%admin%'
        OR user_name LIKE '%사용자%'
        ORDER BY reg_date DESC
    ) TableA WHERE ROWNUM <= (1*5)+5 -- (page*b)+b
) TableB WHERE TableB.RNUM > 1*5     -- (page*b)
--쿼리에서 필요한 변수는 2개 
--현재 페이지 수의 변수  page*b == queryStartNo
--한 페이지당 보여줄 개수의 변수 b == queryPerPageNum
--PageVO에서 필요한 추가변수: page
--UI하단의 페이지 선택번호 출력할때 사용하는 변수(아래)
--perPagenum 변수를 받아서 StartPage,endPage 를 구해서 하단의 페이지 선택번호를 출력
```

- 링코딩 작업순서 1부터6까지(아래)
- 1. ERD를 기준으로 VO클래스를 생성.
- M-V-C 사이에 데이터를 입출력하는 임시저장 공간(VO클래스-멤버변수+Get/Set메서드) 생성
- 보통 ValueObject클래스는 DB테이블과 1:1로 매칭이 됩니다.*오늘 MemberVO만듬
- 2.매퍼쿼리(마이바티스사용)를 만듭니다.(VO사용해서쿼리생성)-내일만들예정
- 3.DAO(데이터엑세스오브젝트)클래스를 생성(SqlSession사용쿼리실행).*오늘 Sql세션은 root-context에 빈으로 만들었습니다.(1개 ) 
- IF 인터페이스 만드는 목적: 복잡한구현클래스 간단하게 구조화 시켜서 개발자가 관리하기 편하게 정리하는 역할
-> 기사시험책 캡슐화 구현과 관련 (알약 캡슐 - 안에 어떤약이 있는지 모르게 먹게하기) 프로그램에서도 캡슐화는 구현 내용을 몰라도, 이름만 보고 사용하게 만든것
- 스프링 부트(간단한 프로젝트)에서는 4번 Service 클래스가 없이 바로 컨트롤러로 이동합니다
- 4.Service(서비스)클래스생성(서비스에 쿼리결과를 담아 놓습니다.)(1개)
- 게시물을 등록하는 서비스 1개(tbl_board-DAO1+tbl_attach 첨부-DAO2)
- Junit에서 위 작업한 내용을 CRUD테스트(선배작업) -> 대리,사원에게 아래 작업을 맡김 
- 5.Controller(컨트롤러)클래스생성(서비스결과를 JSP로 보냅니다.)
- 6.JSP(View파일) 생성(컨트롤러의Model객체를 JSTL을 이용해 화면에 뿌려 줍니다.)

#### 20210607(월) 작업
- 마이바티스 추가 순서: 1번+2번 끝
- 1. pom.xml에 의존성추가
- 2. 마이바티스설정파일 추가(쿼리를 저장할 위치지정,파일명 지정) ok
- Junit으로 CRUD 실습 -코딩시작
- JUnit의 oldQueryTest메서드처럼 직접쿼리를 사용하지 않고, 쿼리를 관리하는 프로그램으로 제어를 합니다.
- 위 쿼리를 관리하는 프로그램이 마이바티스 입니다. 그래서, 마이바티스 모듈을 추가한 후 JUnit실습을 진행합니다.
- 스프링: 관리자단, 회원관리부터 스프링 작업예정.
- 책 스프링 웹프로젝트는 개발 STS(스프링툴슈트) 툴
- 우리가 하는 책 스프링 웹프로젝트는 개발 전자정부표준프레임워크 개발 툴=> 기반은 이클립스기반을 확장 => 전자정부표준프레임워크를 커스터마이징(제외)
-----------------------------------------
- 스프링에서는 마이바티스를 이용해서 쿼리를 관리
- 이전에는 자바코드(jsp코드)안에 쿼리를 만들어서 프로그램을 제작함->문제점 발견(스파게티 코딩)
- MVX로 분리: Model부분의 SQL쿼리를 분리하도록 기능을 추가한 것이 마이바티스입니다 
- 마이바티스(mybatis): 형은  아이바티스(ibatis) 지금x->마이바티스(현재)
- 마이바티스 나오기전에는 쿼리를 모아서 작업을 프로시저로 만들어서 작업함
- 지금은 스프링으로 옮기지 못한 프로그램만 제외하고는 대부분 마이바티스로 쿼리를 관리
- 그래서 마이바티스 셋팅을 함
- 오라클의 DB관리 로그인정보(Application Express): admin / apmsetup-> 암호변경요청: Apmsetup1234%(대문자와 숫자와 특수문자추가)

```
--SQL디벨러퍼에서 system으로 로그인후 아래 쿼리로 XE2사용을 완벽하게 지우기(아래)
SELECT * FROM all_users;
--all_users는 테이블이 아니고 synonim 시노님(동의어) = 테이블명이 사용하기 힘들정도로 길거나
delete from all_users where username='XE2';
--오라클은 스프링과 같은 방식 패키지명안에 함수,프로시저(오라클프로그램)를 만들 수 있음
--패키지명이 길어서 사용시 개발자에게 부담이 됌
--위 상황을 해결하도록 만든 것이 시노님(동의어)
DROP USER XE2 CASCADE;--XE2사용자를 지울때,XE사용자의 테이블까지 모두 지우는 명령
--CSS(Cascade계층형 Style Sheet)
```

- 현업에서는 오픈소스인 mysql(마리아DB)을 사용할 기회가 더 많음-개발자가 더 많음
- 오라클은 납품시 SW비용시 산정되어서 사용할 기회가 적지만 개발자가 상대적으로 적음 
- 보통은 학교전산실, 시청전살실 기업체 전산실에 부탁을 해서 XE 사용자를 추가해 달라고 요청해서, 발급받은계정으로 개발을 시작
- 오라클 기초이론 마무리: 시퀸스(스프링에서 사용-AI자동증가기능)
- 만약 시퀀스(Auto Increment)기능이 없다면 게시물 작성시 첫번째, 두번째 게시물 들들을 구별하는 숫자를 계속 추가하려면 현재까지 저장된 게시물의 최고번호값(Max)을 구해서 +1을 해야합니다(개발자가 매번 Insert시)
- 그래서 DB에서 기본으로 위 Max값을 구해서 +1하는 로직을 만들게 됩니다 이 기능이 시퀸스(AI)
- 우리 스프링프로젝트에서는 두개의 시퀸스를 만들예정 (게시물 시퀸스 SEQ_BNO, 댓글 시퀸스SEQ_RNO)
- 시노님: 긴 객체를 개발자가 타이핑하기 어려워서 만든 단축이름 예, sys.dual->dual 단축이름으로 사용가능
- 오라클 : 더미데이터 일관등록예정 회원관리(100명),게시판관리(공지사항 50개,갤러리 50개) ok
- 위 더미데이터는 프로시저(함수)라는 DB프로그램방식으로 추가함 ok
- 오라클:


#### 20210604금
- 오라클일때 localhost::1521/XE 접속 URL끝의 XE 서비스 (서버)ID명 1개 > XE,XE2 스키마 2개(DB)2개 존재함
- 오라클은 사용자명(XE)이 테이블스페이스명(DB명)입니다. 사용자(XE2)워크스페이스를 추가하면 테이블스페이스(DB)가 새로만들어집니다(구버전은 테스크답프로그램->지금은 웹프로그램 사용자추가/DB(테이블스페이스)추가
- Mysql(마리아DB): localhost:3306/XE URL의 끝의 XE 스키마명(DB명)
- junit테스트시 SQL에러를 디버그하는 방법은 jdbc드라이버-> log4jdbc드라이버로 바꾸면 SQL에러가 나오게 됩니다
- junit에서는 SQL에러가 보입니다 콘솔창에는 보이지 않음 콘솔창에서 SQL로그상황이 나오게 하는 드라이버를 추가 pom.xml에 추가
- 오라클: 07장 마무리 후 13장으로 바로 실습ok.(나머지는 아래 실습 후) 
- 스프링: JUnit테스트: oldQueryTest메서드 실습 ok.
- 오라클: 08,09,10,11,12,14장 실습예정.
- 스프링: JUnit테스트: 회원관리부분 CRUD 테스트 진행예정.

#### 20210603목 작업예정
- JUnit테스트: 오라클 연동한 후 회원관리부분 CRUD 테스트 진행예정
- 오라클 04장부터 CRUD 실습예정
- admin 회원관리(바로jsp디자인)부터 프로그램 작업 시작예정
- 오라클 CRUD 진행예정

#### 20210602(수) 작업예정
- 예외처리하는 목적: 예외상황에서도 프로그램이 중단되지 않도록 하는 것이 주목적이다(예외상황을 세련되게 넘기게 처리)
- 스프링에서는 개발자가 처리하는 100의 코딩에서 2~3개정도이고, 대부분 throws Exception 스프링으로 넘김(예외의 전파)
- 쓰레드(thread): 실행되는 프로그램을 명시, 1개의 프로그램에는 보통 1개의 쓰레드가 실행(우리소스는 여기까지), 특이한 경우(네트워크 프로그램인경우-게시물 다운로드버튼 다운로드 100G 쓰레드가 실행되면서, 리스트 버튼을 클릭했을때 목록보기 쓰레드가 동시에 실행-안드로이드앱에서 필요) 여러개 쓰레드 실행이 필요할 수 있음 
- 예외처리: Throwable 오브젝트가 실행시 에러가 발생하면, 예외(내용)를 보낼때(던질때) 사용하는 클래스 Throwable클래스입니다
- 스프링앱에서는 예외(에러)정보를 스프링처리합니다.
- 자바앱에서는 예외(에러)정보를 개발자가 처리합니다(개발자가 손이 많이 갑니다) 지금 실습시작
- 예외처리: 에러발생시 프로그램이 중지되는 것을 방지하고 계속 프로그램을 사용할 수 있도록 처리
- 패키지는 관련기능을 한곳에 모아서 개발자가 관리하기 편하게 하기 위해서 구분한 이름(폴더명)
- Controller클래스 + home/index.jsp 한쌍, 그래서 컨트롤러클래스에서 만든 변수를 index.jsp에서 사용가능하게 됌
- 안드로이드앱= 액티비티(java) + 레이아웃.xml(화면) 한쌍
- C#닷넷= test.aspx.cs(프로그램) + test.aspx(화면)
- 일반홈페이지(cafe24)-url직접접근가능
- MVC 웹프로그램 차이점-url직접접근이 가능x(보안위험낮음)-관공서,대학,은행
- MVC프로젝트에도 직접접근이 가능한 resources폴더 직접접근가능-static contents(html,css,js)를 모아놓은 폴더,view 폴더 직접 접근이 불가능
- View 폴더터럼 직접접근이 불가능한 컨텐츠는  Controller(라우터)로 접근하게 됌 
- views/home/index.jsp 엑박처리 ok 
- 후 분해(header.jsp, footer.jsp, index.jsp)
- 개발순서: ERD제작 -> html제작 -> jsp제작(현재:관리자단10기능 작업후 사용자단 5기능)
- admin 폴더 만든이후 분해ok 
- Junit(Java Unit Test): 자바 단위 테스트(서비스프로그램 만들기 전 프로토타입 시제품 제작)- Junit CRUD작업 후 본격작업시작
- 로거의 레벨: DEBUG > INFO > WARN > FATAL
- 개발할때: DEBUG 로거레벨을 설정
- 납품할때: WARN으로 로거레벨을 변경
- 4장패키지와 예외처리실습 후 오라클 CRUD

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