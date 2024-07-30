package pkg1.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchService {

	private Scanner sc = new Scanner(System.in);
	
	/* Exception(예외) : 코드로 해결 가능한 에러
	 *   (if, try-catch, throws 등)
	 *   
	 * Exception Handling (예외 처리)
	 * 예외 발생 시 이를 처리하는 구문 (try-catch, throws)
	 *   
	 *   
	 */
	
	/**
	 * 고의적으로 예외 발생시키는 코드 작성
	 */
	public void test1() {
		// NullPointerException
		// -> 참조하고 있는 객체가 없는데 객체의 필드/메서드를 참조하려고 할 때
		
//		String str = null;
//		str.split("/");
		
		
		// ArrayIndexOutOfBoundsException
		// - 배열의 index 범위를 초과한 경우 던져지는 예외
//		int[] arr = new int[3]; //index:0 1 2 
//		arr[5] = 10;
		
		// InputMismatchException
		// - 스캐너 입력 시 next자료형()으로 읽어오는 값과
		// 입력된 값의 자료형이 일치하지 않을 때
		System.out.print("정수 입력 : ");
		int input = sc.nextInt(); // 콘솔 입력 시 문자열 입력;
		// 콘솔 입력 시 문자열/실수/값의 범위 초과 입력
		
		}
	
	
	/**
	 * try - catch를 이용한 예외 처리
	 * 
	 * <pre>
	 * 
	 * 	- try { } : 예외가 발생할 가능성이 있는 코드를 
	 * 				{} 중괄호 블럭 내부에 작성하여 시도
	 * 
	 *  - catch(예외참조변수) {}
	 *  try에서 던져진 예외를 ()매개변수에 작성된 
	 *  참조 변수로 잡아서 처리하는 구문
	 * 
	 * </pre>
	 */
	public void test2() {
		
		// InputMismatchException 던져질 가능성이 있는 코드

		try {
			System.out.print("정수 입력 1 : ");
			int num1 = sc.nextInt();
			
			System.out.print("정수 입력 2 : ");
			int num2 = sc.nextInt();
			
			System.out.println("합계 : " + (num1 + num2));
		} catch(InputMismatchException e) {
			// try에서 던져지게 될 InputMismatchException 객체를 잡아서 처리하는 구문
			System.out.println("정수만 입력하시오");
			
			// 발생된 예외를 처리했기 때문에
			// 어떤 이유로 어디서 무슨 예외가 발생했는지
			// 콘솔에 붉게 표시되는 stackTrace 구문이 출력되지 않음 
			
			/*
			 *  e.printStackTrace()
			 *  - 예외 발생 원인, 발생된 메서드 추적 결과를
			 *  콘솔에 출력하는 메서드
			 *  --> 원래 예외 발생하면 나타나는 구문
			 */
			
			e.printStackTrace();
			
			/*
			 * String e.getMessage();
			 * - 예외 원인이 작성된 message를 문자열로 반환
			 */
			e.getMessage(); // 범위 넘기면 나옴
			
		}
		
	}
	
	
	
	public void test3() {
		try {
			System.out.print("정수 입력 1 : ");
			int num1 = sc.nextInt();
			
			System.out.print("정수 입력 2 : ");
			int num2 = sc.nextInt();
			
			System.out.println("나눔 몫 : " + (num1 / num2)); // 예외 발생 
			// 처음 InputMismatchException만 처리한 경우 			
			// 산술적 예외 ArithmeticException (0으로 나눔) 를 처리 못함 -> 프로그램 강제 종료
			
		} catch(InputMismatchException e) {
			System.out.println("int 범위 정수만 입력해 주세요");
		} catch(ArithmeticException e) {
			// 앞에서 처리하지 못한 산술적 예외를 잡아서 처리
			System.out.println("0으로 나눌 수 없습니다");
		}
		
		// 발생된 예외를 처리했기 때문에 수행될 수 있는 구문
		System.out.println(">>>> 프로그램 종료 <<<<");
	}
	
	
	/**
	 * 예외처리 + 다형성 (업 캐스팅) 
	 * 
	 * RuntimeException : 실행 중 발생하는 모든 예외의 최상위 부모 예외
	 * - Unchecked Exception
	 * 	-> 예외처리 구문을 꼭 작성할 필요 없는 예외
	 */
	public void test4() {
		try {
			System.out.print("정수 입력 1 : ");
			int num1 = sc.nextInt();
			
			System.out.print("정수 입력 2 : ");
			int num2 = sc.nextInt();
			
			System.out.println("나눔 몫 : " + (num1 / num2)); // 예외 발생 
			// 처음 InputMismatchException만 처리한 경우 			
			// 산술적 예외 ArithmeticException (0으로 나눔) 를 처리 못함 -> 프로그램 강제 종료
		} catch(InputMismatchException e) { // 자식 예외 먼저 작성, if처럼
			System.out.println("정수를 입력하시오");
		} catch(RuntimeException e){ // 나머지를 처리하는 else처럼
			System.out.println("뭔지 모르겠지만 예외 발생함");
		} //catch(InputMismatchException e) {
			// Unreachable catch block for InputMismatchException. It is already handled by the catch block for RuntimeException
			// 앞에서 부모타입 참조변수를 이용해 자식타입 예외를 이미 처리했기 때문에 절대로 실행될 수 없다는 예외
		//}
		// catch의 매개변수 타입을 부모 타입으로 설정!!
		// -> 던져지는 모든 자식타입의 예외를 잡아서 처리할 수 있다!
		// -> 예외처리에 다형성(업 캐스팅) 적용
		
		// 장점 : 여러 예외처리 구문을 작성하지 않고도 예외처리 가능!!
		// 단점 : 발생하는 예외 별 처리 방법을 제시할 수 없다
		// 단점 해결 : 세부적인 예외 조건을 먼저 앞에 적고 나머지를 이어서 작성
	}
	
	
	/**
	 * catch 문에 다형성 적용 복습 + 예외 강제 발생
	 * 
	 * - throw new 예외클래스();
	 * 	-> 생성된 예외 객체를 던짐 == 에외 강제 발생
	 */
	public void test5() {
		
		//Exception() 클래스 : 모든 예외 최상위 부모
		
		System.out.println("---던질 예외 선택---");
		System.out.println("1. Exception()");
		System.out.println("2. RuntimeException()");
		System.out.println("3. ArithmeticException()");
	
		
		try {
			int input = sc.nextInt();
			switch(input) {
			case 1: throw new Exception();
			case 2: throw new RuntimeException(); 
			case 3: throw new ArithmeticException(); 
			}
		} catch(InputMismatchException e){
			System.out.println("int 정수만 입력해 주세요.");
			
		} catch(ArithmeticException e) {
			System.out.println("ArithmeticException 예외 처리 완료");
			
		} catch(RuntimeException e) {
			System.out.println("RuntimeException 예외 처리 완료");
		
		} catch(Exception e) {
			System.out.println("Exception 예외 처리 완료");
		}
		
	}
	
	
	/**
	 * Checked / Unchecked Exception 확인
	 * 
	 * 1) Checked Exception
	 * - 반드시 예외처리 구문을 작성해야 하는 예외
	 * - 예외 처리 구문 미작성 시 컴파일 에러 발생 (붉은 줄)
	 * 
	 * 2) Unchecked Exception
	 * - 예외 처리 구문 작성 여부가 필수 아닌 선택하는 예외
	 *	(쓰고 싶으면 쓰고 아니면 말고...)
	 * - 예외 처리 구문을 작성하지 않아도 컴파일 에러 발생 안 함
	 * - 대부분의 Unchecked Exception은 if문으로 해결 가능
	 * 	 (사용자, 이용자의 실수 방지)
	 */
	public void test6() {
		
		// Unchecked Exception 확인
		// -> 컴파일 에러 없음
//		throw new RuntimeException();
		
		// Checked Exception 확인
		// -> 컴파일 에러(붉은 줄) 발생한다
		// Unhandled exception type Exception
		// 처리하지 않은 예외처리 오류 발생
//		throw new Exception(); // 예외처리 해야한다 (try-catch등)
		
		
	}
	
	
}
	