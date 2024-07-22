package method;

// 실행용 클래스
public class StudentRun {
	public static void main (String[] args) {
				
		// StudentService 객체 생성 
		StudentService service = new StudentService(); // RAM에 객체 생성
		
		service.mainMenu(); // service가 가지고 있는 mainMenu기능을 실행해라
	}
}
