package com.edu.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.edu.service.IF_BoardService;
import com.edu.service.IF_MemberService;
import com.edu.vo.BoardVO;
import com.edu.vo.MemberVO;
import com.edu.vo.PageVO;

/**
 * 이 클래스는 오라클과 연동해서 CRUD를 테스트하는 클래스 입니다
 * 과장(이사,팀장) JUnit CRUD까지 만들어서 일반사원들에게 공개
 * @author 임샛별
 *
 */
//RunWith인터페이스 현재클래스가 Junit실행클래스라고 명시
@RunWith(SpringJUnit4ClassRunner.class)
//경로에서 **는 모든폴더명시, *는 모든파일명을 명시
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class DataSourceTest {
    //디버그용 로그 객체변수생성
    private Logger logger = Logger.getLogger(DataSourceTest.class);
    //dataSource 객체는 데이터베이스객체를 pool로 저장해서 사용할때 DataSource 클래스를 사용(아래)
    @Inject // 인젝트는 스프링에서 객체를 만드는 방법, 이전 자바에서는 new 키워드로 객체를 만들었고.. 
    private DataSource dataSource;//Inject로 객체를 만들면  메모리 관리를 스프링이 대신 해줌
    //Inject 자바8부터 지원, 그럼, 이전 자바7에서 @Autowired로 객체를 만들었음
    @Inject //MemberService 서비스를 주입받아서 객체를 사용합니다(아래)
    private IF_MemberService memberService;
    @Inject
    private IF_BoardService boardService;
    
    @Test
    public void insertBoard() throws Exception {
    	BoardVO boardVO = new BoardVO();
    	boardVO.setTitle("인서트 후 반환값테스트");
    	boardVO.setContent("J유닛입력테스트");
        boardVO.setWriter("admin");
        boardVO.setBoard_type("gallery");
        boardService.insertBoard(boardVO);
    }
    @Test
    public void updateMember() throws Exception {
    	//이 메서드는 회원 정보수정(1개 레코그). jsp에 사용예정
    	MemberVO memberVO = new MemberVO();
    	memberVO.setEmail("admin@test.com");
    	memberVO.setEnabled(true);
    	memberVO.setLevels("ROLE_ADMIN");
    	memberVO.setPoint(100);
    	memberVO.setUser_name("최고 관리자");
    	memberVO.setUser_pw("");//입력하지 않으면,업데이트에서 제외
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	//스프링5 시큐리티 암호화 적용로직(아래)
    	if((memberVO.getUser_pw()).length() > 0) { 
       //메서드내 적용된 객체변수 생성 
       String userPwEncoder = passwordEncoder.encode(memberVO.getUser_pw());
       memberVO.setUser_pw(userPwEncoder);//암호화된 해시데이터가 memberVO객체 임시저장됨
    	}
       memberVO.setUser_id("admin");//수정조회조건에 사용
       memberService.updateMember(memberVO);
        // ==============여기까지는 jsp에서 1명의 회원만 업데이트(수정)할때 사용하는 로직
        // ============== 이후 부터는 모든회원중의 시큐리티 암호화가 되지 않는 사용자만 암호만 업데이트
        //아래 수정 call호출을 회원수만큼 반복을 해야 함(아래)
        PageVO pageVO = new PageVO();  
        pageVO.setPage(1);//기본값으로 1페이지를 입력합니다(필수값)
        pageVO.setPerPageNum(10);//UI하단사용 페이지 개수(필수값)
        pageVO.setQueryPerPageNum(1000);//쿼리사용 페이지당 개수 (필수값)
        //MemberVO타입을 가진 리스트형 List<MemberVO>
        List<MemberVO> listMember = memberService.selectMember(pageVO);
        //향상된 for반복문(memberOne:listMember) {구현내용}
        for(MemberVO memberOne:listMember) { //listMember객체 비워질때까지 반복
        	//혹시 여러번 실행시켜서 중복암호화 시킬수 있으므로 제외조건을 추가(아래)
        	String rawPassword = memberOne.getUser_pw();
        if(rawPassword.length() < 10) { //원시암호데이터 길이가 50보다 작을때만 암호화로직 진입
        	//memberOne객체(1개의 레코드)의 암호를 뽑아서 시큐리티로 암호화 시킨 후 onePwEncoder변수입력
        	String onePwEncoder = passwordEncoder.encode(rawPassword);
        	memberOne.setUser_pw(onePwEncoder);
        	memberService.updateMember(memberOne);//1명(admin만) 수정 -> 모든회원을 업데이트                  			
        	}
        }
    	selectMember();   
    }
    @Test
    public void readMember() throws Exception {
    	//이 메서드는 회원 상세보기 (1개의 레코드) jsp에 사용될 예정
    	MemberVO memberVO = new MemberVO();
    	//100명 중 1명을 보려면 고유키(기본키,주키,PK)필요 = user_id
        //String user_id = "admin";
    	memberVO.setUser_id("admin");
    	memberVO = memberService.readMember(memberVO.getUser_id());
    }
    
    @Test
    public void deleteMember() throws Exception {
    	memberService.deleteMember("user_del");
    	selectMember();
    }
    @Test
    public void insertMember() throws Exception {
    	MemberVO memberVO = new MemberVO();
    	//insert쿼리에 저장할 객체
    	memberVO.setUser_id("user_del");
    	memberVO.setUser_pw("1234");//스프링시큐리티5버전으로 암호화 처리예정
    	memberVO.setEmail("user@test.com");
    	memberVO.setPoint(10);
    	memberVO.setEnabled(true);
    	memberVO.setLevels("ROLE_USER");
    	memberVO.setUser_name("삭제할 사용자");
    	memberService.insertMember(memberVO);
    	selectMember();
    }
    //스프링 코딩 시작
    //M-V-C 사이에 데이터를 입출력하는 임시저장 공간(VO클래스-멤버변수_Get/Set메서드) 생성
    //보통 ValueObject클래스는 DB테이블과 1:1로 매칭이 됩니다 
    //그래서 1. MemberVO.java VO클래스를 생성 (필수)
    // 2. DB(마이바티스쿼리)를 만듭니다 (VO사용됨) -내일부터 시작
    @Test
    public void selectMember() throws Exception {
    	//회원관리 테이블에서 더미로 입력한 100개의 레코드를 출력 메서드 테스트 ->회원관리목록이 출력
    	//현재 100명 검색기능, 페이징기능 여기서 구현 1페이지에 10명씩 나오게 변경
    	//현재 몇페이지, 검색어 임시저장 공간 -> DB에 페이징조건, 검색조건문
    	//변수를 2~3대 이상은 바로 String변수로 처리하지 않고, VO만들어 사용
    	//PageVO.java 클래스를 만들어서 페이징처리변수와 검색어변수 선언, Get/set 생성
    	//PagrVO 만들기 전 SQL쿼리로 가상으로 페이징을 한번 구현해 보면서 필요한 변수를 만들어야 함 
    	//pageVO 객체를 만들어서 가상으로 초기값을 입력합니다
        PageVO pageVO = new PageVO();
        
        pageVO.setPage(1);//기본값으로 1페이지를 입력합니다(필수값)
        pageVO.setPerPageNum(10);//UI하단사용 페이지 개수(필수값)
        pageVO.setQueryPerPageNum(1000);//쿼리사용 페이지당 개수 (필수값)
        //pageVO.setTotalCount(memberService.countMember(pageVO));//테스트하려고, 100명 입력
        /*모든사용자를 출력하지않고, 일부사용자만 출력할때 아래 2줄필요 
        pageVO.setSearch_type("user_id");//검색타입 all, user_id, user_name
        pageVO.setSearch_keyword("user_del");//검색어
        */
        //위 setTotalCount 위치가 다른 설정보다 상단이면, 에러발생->calcPage()가 실행할때 위 3가지 변수값이 저장되 있어야지 계산메서드가 정상작동되기때문 
        //위 토탈카운트변수값은 startPage, endPage계산에 필수입니다.
        //매퍼쿼리_DAO클래스_Service클래스_JUnit(나중에 컨트롤러에서 작업) 이제 역순으로 작업진행 
    	//더 진행하기 전에 현재 pageVO객체에는 어떤값이 들어 있는지 확인하고 사용하겠습니다(아래)
        logger.info("pageVO저장된값확인"+pageVO.toString());
        List<MemberVO> listMember = memberService.selectMember(pageVO);
    	listMember.toString();
    }
    
    @Test
    public void oldQueryTest() throws Exception {
    	//스프링빈을 사용하지 않을때 예전 방식: 코딩테스트에서는 스프링설정을 안쓰고, 직접 DB 아이디/암호 입력
    	Connection connection = null;
    	connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","XE","apmsetup");
    	logger.debug("데이터베이스 직접 접속이 성공하였습니다. DB종류는" + connection.getMetaData().getDatabaseProductName());
    	//직접쿼리를 날립니다 날리기전 쿼리문자 객체성공statement
    	Statement stmt = connection.createStatement();
    	//위 쿼리문장객체를 만드는 이유? 보안(SQL인젝션공격)
    	//stmt객체가 없으면, 개발자가 SQL인젝션 방지코딩을 넣어야 합니다
    	//insert쿼리 문장만듦(아래)
    	//예전 방식으로 더미데이터(샘플데이터)를 100개 입력합니다
		/*
		 * for(int cnt=0;cnt<100;cnt++) {//error deptno 자리수가 두자리로 고정이 되어서 100은 입력시 에러
		 * stmt.executeQuery("insert into dept02 values("+cnt+",'디자인부','경기도')"); }
		 */
    	//인서트,업데이트,삭제시 sql 디벨로퍼에서는 커밋이 필수지만, 외부 java클래스 인서트할때는 자동커밋이 됩니다
    	//테이블에 입력되어 있는 레코드셋을 select 쿼리 stmt문장으로 가져옴 
    	ResultSet rs = stmt.executeQuery("select * from dept order by deptno");//20년전 작업방식
    	//위에서 저장된 rs객체를 반복문으로 출력(아래)
    	while(rs.next()) {
    		//rs객체의 레코드가 없을때까지 반복
    		logger.debug(rs.getString("deptno")+" "+rs.getString("dname")+
    				" "+rs.getString("loc"));
    	}
    	stmt = null;//메모리 반환
    	rs = null;//메모리 반환
    	connection = null;//메모리 초기화 
    }
	@Test
	public void dbConnectionTest() {
		//데이터베이스 커넥션 테스트: 설정은 root-context의 빈(스프링클래스)를 이용
		try {
			Connection connection = dataSource.getConnection();
			logger.debug("데이터베이스 접속이 성공 하였습니다. DB종류는 "+ connection.getMetaData().getDatabaseProductName());
		} catch (SQLException e) {
			logger.debug("데이터베이스 접속이 실패 하였습니다.");
			//e.printStackTrace();
		}
		
	}
    @Test
    public void jnitTest() {
    	//로거는 장점 조건에 따라서 출력을 조정할수있음
    	logger.debug("Junit테스트 시작 입니다.");
    	
    }
}
