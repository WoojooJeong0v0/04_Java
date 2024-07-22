package student.service;

import java.util.Random;

import student.dto.StudentDTO;

// 기능(비즈니스 로직), 실제 업무 기능 담당, 제공용 클래스
public class StudentService {

	// StudentDTO 객체를 참조하는 StudentDTO 참조 변수 5개 묶음 배열 생성
	// 인덱스 0 ~ 4
	// 각 인덱스 요소 : 초기값은 null (아무것도 참조하지 않음)
	private StudentDTO[] students = new StudentDTO[5];
	
	
	/**
	 * 기본 생성자
	 */
	
	public StudentService( ) {
		// 학생 객체 배열(students)에 샘플 학생 3명 추가
		
		// students[0] = StudentDTO 자료형 참조 변수
		students[0] = new StudentDTO("24001", "짱구" , '남');
		students[1] = new StudentDTO("24002", "유리" , '여');
		students[2] = new StudentDTO("24003", "맹구" , '남');
		
		// students[3] / students[4] == null
		
		// 1)	Math.floor(Math.random() * 101) == 0 ~ 100 
		// 2)	Random random = new Random();
		// 		random.nextInt(101); == 0 ~ 100
		
		
		Random random = new Random();
		for(StudentDTO std : students) { // 향상된 for문
			if(std == null) break; // 0, 1, 2만 접근하겠다는 뜻
			// 현재 접근한 요소가 참조하는 객체가 없다면 반복을 종료
			
//			random.nextInt(101) : 0 이상 101 미만 정수형 난수
			
			std.setHtml(random.nextInt(101));
			std.setCss(random.nextInt(101));
			std.setJs(random.nextInt(101));
			std.setJava(random.nextInt(101));
		}
				
	}
	
	/**
	 * 학생 객체 배열 students 중 비어있는 인덱스에
	 * 전달 받은 학생 객체(std) 대입, 추가하겠다!!
	 * @param std : 입력 받은 값을 저장한 학생 객체 주소
	 * @return true : 추가 성공 시 / false : 추가 실패 (인덱스를 초과할 때)
	 * - 실패 조건 : students 배열이 꽉 차있는데 추가 학생이 전달된 경우
	 */
	
	public boolean addStudent(StudentDTO std) {
		
		// 0번 인덱스부터 순서대로 비어있는 (null) 요소를 찾아
		// 전달받은 std 를 대입하는 코드
		for (int i = 0 ; i < students.length ; i++) {
			if(students[i] == null) { // [i] 번째 요소가 비어있는 경우
				students[i] = std;
				return true;
			}
		}
		// 비어있는null 요소(인덱스)가 없을 때 false를 반환해라! 
		return false;
	}
	
	/**
	 * 외부에서 students getter
	 * students 객체 배열에 저장된 주소를 얻어가게 하는 메서드
	 * @return students 객체 배열에 저장된 주소
	 */
	//public 반환형 get필드명() {
	//	return 필드명;
	//}
	public StudentDTO[] getStudents() {
		return students;
	}

	/**
	 * 학생 1명 정보 조회(index 검색)
	 * @param index
	 * @return 조회된 학생 객체 주소 || null 반환
	 */
	public StudentDTO selectIndex(int index) {
		
		// 전달 받은 index 범위가 students의 인덱스 범위 밖인 경우
		if(index < 0 || index >= students.length) {
			return null;
		}
		return students[index];
	}

	/**
	 * 전달 받은 이름과 이름이 일치하는 학생 객체 반환
	 * @param targetName
	 * @return null || 일치하는 학생 객체 주소값 반환
	 */
	public StudentDTO selectName(String targetName) {
		
		// 향상된 for문
		for (StudentDTO std : students) {
			// 저장된 학생이 없을 경우, 뒤에도 없을 테니 검색 종료
			if (std == null) return null;
			
			// == : 기본 자료형 비교
			// A.equals(B) : 참조형 비교
			if (std.getName().equals(targetName)){
				return std;
			}
		}
		return null;
	}
	
	
}
