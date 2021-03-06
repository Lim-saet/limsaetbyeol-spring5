package kr.or.test;
/**
 * 이 클래스는 메서드기반의 Step1클래스를 객체기반의 클래스로 변경한 클래스 
 * @author 임샛별
 *
 */
class MemberVO {
	// 이 클래스는 회원정보를 저장하는 자료형 클래스(자료) 입니다
	private String name;
	private int age;
	private String phoneNum;
	//하나씩 출력하기 힘들때 자동으로 멤버변수값을 출력하는 명령 toString생성(아래)
	
	@Override
	public String toString() {
		return "MemberVO 출력[name=" + name + ", age=" + age + ", phoneNum=" + phoneNum + "]";
	}
	//위 프라이빗 멤버변수를 입출력 구현 메서드를 만듭니다
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//String을 반환(return) 겟 메서드 입니다(아래)
	public String getPhoneNum() {
		return phoneNum;
	}
	//void한 (반환값이 없이) 입력하는 셋 메서드 입니다(아래)
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;//프라이빗변수를 직접접근 못하니까 
		//퍼블릭 메서드로 입력 하게 만들어 놓은 구조
	}
	
}
public class Step2 {

	public static void main(String[] args) {
		// MemberVO클래스자료형 객체를 생성합니다(아래)
		MemberVO memberVO = new MemberVO();
		memberVO.setName("홍길동");
		memberVO.setAge(10);
		memberVO.setPhoneNum("000-000-0000");
		MemberVO memberVO2 = new MemberVO();
		memberVO2. setName("성춘향");
		memberVO2. setAge(18);
		memberVO2. setPhoneNum("111-111-1111");
		MemberVO memberVO3 = new MemberVO();
		memberVO3. setName("각시탈");
		memberVO3. setAge(28);
		memberVO3. setPhoneNum("222-222-2222");
		//MemberVO클래스를 배열 객체(String)로 생성했음(아래)
		MemberVO[] members = new MemberVO[3];
        members[0] = memberVO;
        members[1] = memberVO2;
        members[2] = memberVO3;
        //출력도 메서드를 바로 호출하지 않고, 외부클래스에서 객체로 만들어서 메서드를 호출합니다
        MemberService memberService = new MemberService();
        memberService.printMember(members);
	}

}
class MemberService {
	//회원을 출력하는 메서드 생성
	public void printMember(MemberVO[] members) {
	//멤버서비스클래스에서 퍼블릭 접근제어로 회원정보를 출력하는 메서드 생성
	//향상된 for문을 사용
	for(MemberVO member:members) {
		System.out.println("회원의 이름은"+member.getName()+" 나이는"+member.getAge()
		+ " 폰번호는"+member.getPhoneNum());
	}
	}
	}
