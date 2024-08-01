package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;

/*
 * 왜 Service, Dao 인터페이스를 만들어서 구현했을까?
 * 
 * - 인터페이스를 상속 받아 구현하면 모든 자식 클래스가 똑같은 기능을 갖게 됨
 * 비슷한 모양으로 생김!!
 * 
 * -> 비슷하게 생기면 대체가 가능해짐!!
 * --> 언제든지 서로 다른 자식 클래스로 대체 가능 => 유지 보수성 증가!
 */


// MemberService를 상속받아 구현한 객체/클래스
// 왜? (위에 설명)
public class MemberServiceImpl implements MemberService {

	// implements Impl 멤버 서비스 구현체
	
	// dao 객체 부모 참조변수 선언
	private MemberDao dao = null;
	
	// 기본 생성자
	// - MemberServiceImpl 객체 생성 시
	// MemberDaoImpl 객체도 생성하겠다는 뜻
	// MemberDaoImpl 이 생성되면 파일을 불러오거나 만든다!
	public MemberServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException {
		dao = new MemberDaoImpl(); // MemberDaoImpl 객체를 생성
		// 호출한 곳에서 예외처리를 해야 하지만 여기서 안 함!!
	}
	
	// 회원추가
	@Override
	public boolean addMember(String name, String phone) throws IOException { // 처음엔 부모와 다르게 생긴 오버라이딩 문구라서 부모와 맞춰야 함
		
		// 1) 회원 목록을 얻어와 휴대폰 번호 중복 검사
		List<Member> memberList =  dao.getMemberList();
		
		for (Member member : memberList) {
			if(phone.equals(member.getPhone())) // member.getPhone 지금 입력 받은 번호 {
			// 1-1) 휴대폰 번호가 같은 경우 == 중복인 경우
			return false;
		}
		
		// 2) 중복이 아닌 경우
		// 입력 받은 정보를 이용해 Member 객체를 생성하고 DAO에 전달하여 파일 저장
		Member member = new Member(name, phone, 0, Member.COMMON); // 처음에 만든 등급 상수
		
		// DAO 메서드 호출 후 결과 반환 받기
		boolean result =  dao.addMember(member); // 문제 없으면 true로 옴
		
		return result;
	}

	
		// DAO에서 조회한 memberList를 그대로 반환
		// 해당 서비스 메서드는 따로 처리할 조건/기능이 없음!
		// 중간에서 전달만 해주는 역할
		@Override
		public List<Member> getMemberList() {
			return dao.getMemberList();
		}
		
	
	
	
	
	
	
}
