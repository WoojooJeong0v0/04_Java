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

	
	/**
	 * 전달 받은 index가 students 범위 내인지
	 * + 정상 범위라면 해당 index가 학생 객체를 참조하는지 확인
	 * @param index
	 * @return 1 또는 2 (3은 정상)
	 */
	
	public int checkIndex(int index) {
		// 입력 받은 index가 정상인지 판별하자 
		// 1 == 범위 초과
		// 2 == 학생 없음
		// 3 == 정상
		
		// index는 무조건 0부터 시작하기 때문에
		if(index < 0 || index >= students.length) return 1;
		
		if(students[index] == null) return 2;
		
		return 3;
	}

	
	/**
	 * 전달 받은 index 번째 학생의 점수 수정하기
	 * @param index
	 * @param scores
	 */
	public void updateScores(int index, StudentDTO other) {
		
		// 객체 배열 : 객체 참조형 변수(주소)를 묶음으로 다룸
		StudentDTO s = students[index]; // students 학생정보 객체 배열의 참조형 변수 
		// 주소를 변수에 대입하는 것으로 얕은 복사가 일어남!!
		// students[index]번째에 저장된 주소 얕은 복사
		
		// 전달하는 이름과 전달 받은 곳에서 쓰이는 이름이 같을 필요 없음!
		// scores -> other 로 작성
		// other에서 값을 get해서 s에 set를 해줘!
		s.setHtml(other.getHtml());
		s.setCss(other.getCss());
		s.setJs(other.getJs());
		s.setJava(other.getJava());
		
		// return; 안 써도 컴파일러가 자동으로 추가 
	}

	
	/**
	 * 평균 최대/최소 구하기
	 * @return 	
		// 	 * 최고점 : 짱구 (85.4)
		//	 * 최저점 : 맹구 (61.5)
	 */
	public String selectMaxMin() {
		
		double maxAvg = 0.0; // 최대값 저장할 변수
		double minAvg = 0.0; // 최소값 저장할 변수
		String maxName = null;
		String minName = null;
		
		// 최고/최점 판별
		for(StudentDTO std : students) {
			
			if(std == null) break; // 학생이 없으면 반복을 멈추겠다
			
			int sum = std.getHtml() + std.getCss() + std.getJava() + std.getJs();
			
			double avg = sum / 4.0;
		
			// for 첫 반복일 때, 아무 값도 대입하지 않았을 때
			if (maxAvg == 0.0) {
				maxAvg = avg;
				maxName = std.getName();
				
				minAvg = avg;
				minName = std.getName();
				continue;
			}
			
			
			if (avg > maxAvg) { // 기존 최대값보다 현재 평균이 클 때
				maxAvg = avg;
				maxName = std.getName();
			}
			
			if (avg < minAvg) { // 기존 최소값보다 현재 평균이 작을 때
				minAvg = avg;
				minName = std.getName();
			}
		}
		
		
		String result = String.format("최고점 : %s(%.1f)\n최저점 : %s(%.1f)\n", maxName, maxAvg, minName, minAvg);
		return result;
	}
	
	
}
