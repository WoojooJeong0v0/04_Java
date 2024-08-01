package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.Member;

// dao 상속 받을 친구
public class MemberDaoImpl implements MemberDao {

	// 멤버 서비스 구현체
	
	// 트레이너 데이터가 저장될 파일경로
	// 상수로 만들어야 함
	private final String FILE_PATH = "/io_test/trainer.dat";
	
	// 트레이너 목록 (dto Member)을 저장할 List객체
	private List<Member> memberList = null;
	
	// 각 데이터를 연결해줄 스트림 참조변수 만들기
	private ObjectInputStream ois = null; // 오브젝트 입력
	private ObjectOutputStream oos = null;  // 오브젝트 출력
	
	// 기본 생성자
	// 다수의 트레이너목록을 관리할 List가 있어야 하고
	// 이 트레이너 목록(trainer dat)이 있다면 읽어올 예정 / 없으면 새로 만듬
	// MemberDao 가 호출되면 해당 기능을 수행할 것이다
	public MemberDaoImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(FILE_PATH);
		// trainer.dat 이 있는지 검사부터 해야 함
		if(file.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				memberList = (ArrayList<Member>)ois.readObject(); // 형변환
			} finally {
				if(ois != null) ois.close();
			}
		} else memberList = new ArrayList<Member>(); //	존재하지 않는다면 새로운 ArrayList<Member> 를 만들어서 참조
	}
	
	// 이제 만들어진 memberList 를 호출하면 반환하게 해주는 메서드 작성
	@Override
	public List<Member> getMemberList() { //getMemberList는 우리가 붙인 이름임
		return memberList;
	}
	
	
	
}
