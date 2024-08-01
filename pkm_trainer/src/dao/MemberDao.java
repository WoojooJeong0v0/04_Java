package dao;

import java.util.List;

import dto.Member;

// 데이터를 다오! 옮겨줄 친구
public interface MemberDao {

	// Impl에서 미리 선언한 메서드를 이클립스 기능을 통해 생성함
	// 인터페이스 메서드는 묵시적으로 public abstract 가 붙어있음
	List<Member> getMemberList();

}
