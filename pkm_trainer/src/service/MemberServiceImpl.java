package service;

import java.io.FileNotFoundException;
import java.io.IOException;

import dao.MemberDao;
import dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	
	// MemberService 를 상속 받아오는 친구
	
	private MemberDao dao = null; // dao에 memberList가 있어, Service를 만들 때마다 dao도 만들 거야! 참조변수를 저장하기 위해 선언
	
	public MemberServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException {
		dao = new MemberDaoImpl(); // 인터페이스는 컨스트럭터로 선언할 수 없으니까 자식 불러와서 업캐스팅 진행함!
	}
	

}
