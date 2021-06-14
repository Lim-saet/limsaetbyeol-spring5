package com.edu.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.service.IF_MemberService;
import com.edu.vo.MemberVO;
import com.edu.vo.PageVO;

/**
 * 이 클래스는 Admin관리자단을 접근하는 클래스
 * 변수(Object)를 만들어서 jsp로 전송 + jsp에서 값을 받아서 Object로 처리
 * @author 임샛별
 *
 */
@Controller 
public class AdminController {
	//컨트롤수정하면 자동로딩(auto컴파일)
	//디버그용 로그객체 생성
	private Logger logger = LoggerFactory.getLogger(AdminController.class);
	//이 메서드는 회원목록을 출력하는 jsp와 매핑이 됩니다
	@Inject
	private IF_MemberService memberService;
	
	@RequestMapping(value="/admin/member/member_delete", method=RequestMethod.POST)
	public String deleteMember(MemberVO memberVO) throws Exception {
		logger.info("디버그: " + memberVO.toString());
		//MemberVO memberVO는 클래스형 변수 이렇게 사용하는 의미는 String user_id 같은 방식
		String user_id = memberVO.getUser_id();
		//이 메서드는 회원상세보기페이지에서 삭제버튼을 클릭시 전송받은 memberVO값을 이용해서 삭제를 구현(아래)
		memberService.deleteMember(user_id);// 삭제쿼리가 실행됨
		//return "admin/member/member_list";//삭제후 이동할 jsp경로지정
        //위 방식대로하면, 새로고침하면 /admin/member_delete 계속 실행됩니다-사용자단에서 실습예정
        //게시판테러상황을 방지하기 위해서 쿼리를 작업 후 이동할때는 redirect(다시접속)라는 명령을 사용 
		return "redirect:/admin/member/member_list";//주의점: redirect는 절대경로를 사용
	}
	@RequestMapping(value="/admin/member/member_view", method=RequestMethod.GET)
	public String viewMemberForm(Model model, @RequestParam("user_id")String user_id, @ModelAttribute("pageVO")PageVO pageVO) throws Exception
 {   // 페이지진입시 받은 클래스 변수값 PageVO pageVO
           /*
            * 이 메서드는 리스트페이지에서 상세보기로 이동할떄 보여주는 1개 레코드값을 보여주는 구현을합니다
            * JUnit에서 테스트했던 readMember 방식을 이용
            * 다른점은 JUnit에서는 식별자 ID를 강제로 지정했지만 이 메서드에서는 @RequesrParan인터페이스를 이용해서 식별자값을 받음
            */
		memberService.readMember(user_id);
		//위 출력값 memberVO 1개의 레코드를 model을 이용해서 member_view.jsp보냄(아래)
		 model.addAttribute("memberVO", memberService.readMember(user_id));
		 //model.addAttribute("pageVO", pageVO);
		 //아래 페이지 반환시(렌더링) @ModelAttribute("pageVO")에 의해서 pageVO변수값으로 jsp 보냄
		  return "admin/member/member_view";//상태경로 폴더파일위치 
	}
	@RequestMapping(value="/admin/member/member_list", method=RequestMethod.GET)
	public String selectMember(@ModelAttribute("pageVO")PageVO pageVO,Model model) throws Exception {
		/* 
		이 메서드는 2개 객체 생성하는 로직이 필요 결과를 JSP로 보내는 기능을 수행 
		1객체: memberList객체를 생성해서 model을 통해서 jsp로 전송
		2객체: pageVO(prev,next,startPage,endPage)객체를 생성해서 model을 통해서 jsp로 전송
		2번 객체부터 로직이 필요-> memberList구하는 쿼리변수가 만들어지기 때문에 이것부터 구현
		*/
	    if(pageVO.getPage() == null) {//jsp에서 클릭값이 없을때만 초기값 입력
	    	pageVO.setPage(1);//초기값 1페이지 입력
	    }
	    //학습포인트: calcPage()로직<변수(객체)값의 이동확인
	    pageVO.setQueryPerPageNum(5);//memberList객체+endPage구할때필요
	    pageVO.setPerPageNum(5);//startpage구할때-UI하단 페이지번호개수
	    //위 2개의 변수값을 이용해서 아래 setTotalCount메서드에서 calcPage()호출됨
	    pageVO.setTotalCount(memberService.countMember(pageVO)); 
	    //calcPage 실행되면 prev, next변수값이 입력 됌
	    List<MemberVO> listMember = memberService.selectMember(pageVO);
	    //위 setPerPageNum 20명이면 next가 false(비활성화), 5이면 next가 true(활성화)
	    logger.info("디버그" + pageVO.toString());//지금까지 jsp->컨트롤러 일방향으로 자료이동
	    //컨트롤러에서 jsp로 자료를 Model에 담아서 보내게 됩니다
	    model.addAttribute("listMember", listMember);
	    //model.addAttribute("pageVO", pageVO);//나중에 @ModelAttribute로 대체
		return "admin/member/member_list";//jsp파일 상대경로
	}
	// URL 요청경로는 @RequestMapping 반드시 절대경로로 표시
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String admin(Model model) throws Exception { //에러발생시 Exception클래스의 정보를 스프링으로 보내게 됩니다
		
		//아래 상대경로에서 /WEB-INF/views/폴더가 루트(최상위)
		//아래 상대경로에서 home.jsp에서 .jsp는 생략(suffix 접미어이기 때문에
		return "admin/home"; //리턴 경로=접근경로는 반드시 상대경로로 표시
	}
}
