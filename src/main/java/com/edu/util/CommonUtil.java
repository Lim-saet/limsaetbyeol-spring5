package com.edu.util;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.service.IF_MemberService;
import com.edu.vo.MemberVO;

/**
 * 이 클래스는 이 프로젝트에서 공통으로 사용하는 유틸리티기능을 모아놓은 클래스
 * @author 임샛별
 *컨트롤러기능 @Controller(jsp와 바인딩이 필요할때는 필수 애노테이션입니다)
 *콤포넌트는 @Component는 MVC가 아닌 기능들을 모아놓은 스프링빈 명시, 여기서는 jsp와 바인딩이 필요해서 사용안함
 */
@Controller
public class CommonUtil {
	 //멤버변수생성(아래)
	private Logger logger = LoggerFactory.getLogger(CommonUtil.class);
	@Inject
	private IF_MemberService memberService;//스프링빈 주입받아서(DI) 객체준비
	
     //ResrAPI서버 맛보기 ID중복체크 (제대로 만들면 @RestController 사용)
	@RequestMapping(value="/id_check",method=RequestMethod.GET)
	@ResponseBody //반환받는 값의 헤더값을 제외하고, 내용(body)만 반환하겠다는 것을 명시 
	public String id_check(@RequestParam("user_id")String user_id) throws Exception {
		//중복ID를 체크로직(아래)
		String memberCnt= "0";//중복ID가 없을때 기본값0
		MemberVO memberVO = memberService.readMember(user_id);
		
		if(memberVO != null) { //!주의  중복ID가 존재하면 {}안을 실행
			memberCnt = "1";
		}
		return memberCnt;//0.jsp 이렇게 작동하지 않음 이유는 @ResponseBody때문이고 RestAPI는 값만 반환
	}
}
