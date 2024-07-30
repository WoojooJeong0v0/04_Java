package pkg3.run;

import java.io.IOException;

import pkg3.service.ThrowsService;

public class ThrowsRun {
	public static void main(String[] args) throws IOException{
		
		ThrowsService service = new ThrowsService();
		
//		service.test1();
		
		// 붉은 줄 뜨는 이유
		// test3()에서 IOException이 던져질 수 있는데
		// 대비(예외처리) 없어서 오류 나는 중
		
		// main()이 호출할 건데 또 throsw 를 작성하여 예외를 전달함
		// 하지만... 
		// main()을 호출한 메서드는 존재하지 않음
		// 예외 처리되지 않아서 프로그램이 강제종료됨
//		service.test3();
		
//		System.out.println("와아아아"); // 실행되지 않을 것
		
		service.test5();
		
		
	}
}
