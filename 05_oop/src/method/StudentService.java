package method;

import java.util.Scanner;

// 기능 제공용 클래스
// service 실질적 기능 제공
public class StudentService {
	
	// 필드 
	private Scanner sc = new Scanner(System.in); // Scanner 객체 생성
	// 이 클래스에서만 쓰는 스캐너 자료형 에 new 연산자로 Scanner 라는 객체로 만들어서 (매개변수) 이용해서 입력받겠다
	
	
	/**
	 * 메인 메뉴 화면
	 */
	public void mainMenu()	{ // 매개변수도 없고 반환형도 없는 메서드
		
		int input = 0; // 입력 받은 메뉴 번호를 저장하는 변수
		
		// 생성된 학생 객체 "주소"를 저장할 참조 변수
		// null : 참조하는 객체가 없다 / 주소 저장이 안 됨 
		Student std = null;
		
		// do ~ while : 최소 1회 이상 반복하고 싶을 때 사용!! 
		do {
			
			System.out.println("\n=====학생 1명 관리 프로그램====");
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 정보 확인");
			System.out.println("3. 학생 이름 수정");
			System.out.println("4. Java 공부하기");
			System.out.println("5. HTML 공부하기");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 번호를 입력 : ");
			input = sc.nextInt();
			
			sc.nextLine(); // 입력 버퍼에 남아있는 엔터를 제거하는 코드
			
			System.out.println(); // 줄바꿈
			
			// 1~5, 0, 나머지 (잘못입력)
			switch(input) {
			case 1 : 
				std = registStudent();
				System.out.println(std.getName() + "학생 등록됨!!");
				break;
			case 2 : 
				System.out.println("[학생 정보 확인]");
				System.out.println("학교 : " + Student.schoolName); // static이니까 class 명을 붙여서 호출해야 함
				System.out.println(std.toString());
				break;
			case 3 : 
				// 학생 이름 수정 메서드 호출 시 std에 저장된 학생 객체 참조 주소를 전달해줌!
				updateName(std); // 얕은 복사
				break;
			case 4 : 
				studyJava(std);
				break;
			case 5 : 
				studyHtml(std);
				break;
			case 0 : System.out.println("===프로그램 종료 합니다==="); break;
			default : System.out.println("===알맞은 메뉴 번호를 입력해주세요==="); ;
			}
			
			
		} while(input != 0); // 0이 입력되기 전까지는 반복, 메뉴 0 선택 시 반복 종료
		
	}
	
	/**
	 * 학생 등록 메서드
	 * @return 생성된 Student 객체의 주소 반환
	 */
	private Student registStudent() { // regist 등록
		
		System.out.println("[학생 등록]");
		System.out.print("이름: ");
		String name = sc.nextLine();
		
		System.out.print("학번: ");
		String studentNumber = sc.nextLine();
		
		System.out.print("성별(남/여): ");
		char gender = sc.next().charAt(0); // 문자열을 받아와서 1글자만 끊어야 함!
		
		Student student = new Student(name, studentNumber, gender);
		
		
		// student 변수에는 생성된 Student 객체를 참조하는 주소값이 담겨있다!!
		// -> return student는 주소값만 반환 ( == 주소값이 복사되어 호출한 곳으로 돌아감!!!)
		return student;
	}
	
	/**
	 * 학생 이름 수정 메서드
	 * @param std : 전달 받은 Student 객체 참조 주소 
	 */
	private void updateName(Student std) { 
		System.out.println("[학생 이름 수정]");
		System.out.println("기존 이름 : " + std.getName());
		
		System.out.print("변경할 이름 입력 : ");
		String newName = sc.nextLine();
		
		// 이름을 홍길동 -> 김철수 변경 하시겠습니까?
		System.out.printf("이름을 %s에서 %s로 변경하시겠습니까?(y/n)", std.getName(), newName);
		
		// String.toUpperCase() -> 대문자로 변환
		// String.toLowerCase() -> 소문자로 변환
		char check = sc.next().toLowerCase().charAt(0);
		
		if (check == 'n') { // 'n'이 입력된 경우
			System.out.println("===이름 변경 취소===");
			return;
		}
		
		// 'y'가 입력되었을 때
		std.setName(newName); // 새로운 이름을 std가 참조하는 객체에 세팅
		System.out.println("===이름 변경 완료!!===");
		
	}
	
	
	/**
	 * 자바 공부하기 메서드 -> std에 저장된 자바 역량 변경
	 * 단, 수정된 자바역량은 최대값(100), 최소값(0) 범위 초과가 불가능
	 * @param std
	 */
	public void studyJava(Student std) {
		System.out.println("[Java 공부하기]");
		
		int before = std.getJava(); // 이전 점수 저장 // int는 기본자료형이기 때문에 값을 그대로 저장함
		System.out.println("현재 Java 역량 점수 : " + std.getJava());
		
		System.out.print("증가 또는 감소한 Java 역량 점수 입력 : ");
		int score = sc.nextInt();
		
		// 기존 점수에 누적하기
		int temp = 	std.getJava() + score; // 기존 점수 + 입력된 점수
		
		// 100 점(Student.MAX_VALUE)  초과 시 MAX_VALUE 대입
		if (temp > Student.MAX_VALUE) {
			temp = Student.MAX_VALUE;
		}
		
		// 0점(Student.MIN_VALUE) 미만 시 MIN_VALUE 대입
		if (temp < Student.MIN_VALUE) {
			temp = Student.MIN_VALUE;
		}
		
		std.setJava(temp); // 참조하고 있는 학생 객체 Java 필드에 대입을 하겠다
		
		System.out.println("===Java 역량 점수 수정 완료===");
		
		// 50 -> 80 (+30)
		// 50 -> 30 (-20)
				
		// 90 -> 100 (+30) // 최대값 초과
		// 10 -> 0 (-40) // 최소값 미만
		
		// 음수인 경우 score
		// 양수인 경우 + score 형태로 만듬
		String str = (score <= 0) ? score + "" : ("+" + score);
		System.out.printf("%d -> %d (%s) \n", before, std.getJava(), str);
	}
	
	
	/**
	 * HTML 역량 점수 변경
	 * @param std
	 */
	private void studyHtml(Student std) {
		System.out.println("[html 공부하기]");
		int before = std.getHtml();
		
		System.out.println("현재 HTML 역량 점수 : " + std.getHtml());
		
		System.out.println("증가 또는 감소한 HTML 점수 입력 : ");
		int score = sc.nextInt();
		
		int value = score + std.getHtml(); // std.getHtml 은 변수가 아니어서 변수에 따로 저장해야 함
		
		if (value > Student.MAX_VALUE) value = Student.MAX_VALUE;
		
		if (value < Student.MIN_VALUE) value = Student.MIN_VALUE;
		
		std.setHtml(value);
		
		System.out.println("===HTML 역량 점수 수정 완료===");
		
		String str = (score <= 0) ? score + "" : "+" + score; // +를 붙이고 싶어서 문자열로 바꿈
		System.out.printf("%d -> %d (%s) \n", before, std.getHtml(), str);
	}
		
	
}
