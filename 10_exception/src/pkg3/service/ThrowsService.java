package pkg3.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowsService {

	/*
	 * throws : 메서드 내부에서 던져진 예외를 호출부로 다시 던지는 예외처리 구문
	 * 
	 * 
	 * throw : 생성된 예외 객체를 던져 예외 발생 시킴
	 * 		   예외 강제 발생
	 * 
	 * throws를 사용하는 이유 !!!!
	 * 
	 * 1) 경고의 의미
	 * 	-> 해당 메서드 기능을 활용하다 보면 특정 예외가 발생할 수 있으니
	 * 	   대비를 해라
	 * 
	 * 2) 예외 처리를 한 곳에서 묶어 처리하기 위하여
	 *  -> 실질적으로 예외를 처리하는 try - catch 구문이 사방에 흩어져 있을 경우
	 *     돌려 받는 최종 결과가 정상 결과인지, 예외 처리된 결과인지 구분하기 힘듬
	 *     
	 *
	 */
	
	private Scanner sc = new Scanner(System.in);
	
	public void test1() {
		// test1()에서 test2()를 호출한다
		// (3) test2() 메서드에서 던져진 예외를 처리해야 함
		try {
		test2();} catch(Exception e) { // (4) test2()에서 던져진 예외 잡아서 처리
			e.printStackTrace(); // 예외 발생한 원인, 메서드 추적
		}
	}
	
						// (2) throws Exception{}
						// 메서드 내부에서 발생한 Exception
						// 또는 Exception 자식 예외를 
						// 메서드 호출한 곳으로 다시 던짐!!
	public void test2() throws Exception{
		// (1) 예외 Exception 강제 발생, 를 던짐
		throw new Exception();
	}
	
	
	/**
	 * (2)
	 * test4()호출 시 올 수 있는 IOException을 대비한 코드 작성 필요
	 * 
	 * 대비 방법 1) try-catch 작성 -> 해당 메서드에서 예외를 처리해 없애겠다
	 * 
	 * 대비 방법 2) throws 해당 메서드에 작성 -> 전달 받은 예외를 또 호출한 곳으로 전달
	 */
	public void test3() throws IOException {
		test4(1); // 전달 인자 값 1 또는 2
		// 관련한 내용 ThrowsRun에 작성됨
	}
	
	/**
	 * (1)
	 * 전달 받은 num 값에 따라 IOException이 '발생할 가능성이 있으므로'
	 * 해당 메서드를 호출하는 곳에서는 IOException에 대한
	 * 예외 처리 구문을 작성해야만 한다
	 * @param num
	 * @throws IOException
	 */
	
	public void test4(int num) throws IOException {
		// num 값에 따라 예외 발생 여부 결정
		
		if (num == 1) {
			throw new IOException("강제 예외 발생");
		} else {
			System.out.println("정상 수행");
		}
	}
	
	
	public void test5() {
		int input = 0;
		
		do {
			System.out.println("---예외처리 테스트---");
			System.out.println("1. 나누기(0으로 나누면 오류 발생)");
			System.out.println("2. 강제로 Exception 던지기");
			System.out.println("3. 효율적인 키보드 문자열 입력 코드");
			System.out.println("0. 종료");
			
			try {
				System.out.print("메뉴 선택 ::: ");
				input = sc.nextInt(); // 정수 아닌 값 입력하면 예외가 발생함
				sc.nextLine();
				
				switch(input) {
				case 1 : divNum(); break;
				case 2 : forcedException(); break;
				case 3 : inputKeyboard(); break;
				case 0 : System.out.println("***종료***"); break;
				default : System.out.println("잘못 입력했습니다");
				}
				
			} catch(InputMismatchException e) {
				System.out.println("정수만 입력해 주세요");
				sc.nextLine(); // 입력 버퍼에 남은 문자열 제거
				input = -1; // 첫 반복 시 반복문이 종료되지 않도록 input값을 변경함
			} catch(ArithmeticException e) {
				System.out.println("***발생한 산술적 예외를 test5()에서 처리***");
			} catch(Exception e) { // 다형성 업 캐스팅 적용
				// Exception, IOException 처리 중
				System.out.println("**** Exception 또는 남은 예외 처리 ****");
			} finally {
				sc.close();
			}
			
		}while(input != 0);
	}
	
						  //  미작성 시 컴파일러가 자동으로 추가
	public void divNum() /* throws RuntimeException */ { 
		System.out.print("정수 입력 1 : ");
		int num1 = sc.nextInt();
		System.out.print("정수 입력 2 : ");
		int num2 = sc.nextInt();
		
		System.out.println("몫 : " + (num1 / num2));
		
		// num2가 0인 경우
		// ArithmeticException (산술적 에외) 발생 가능성이 있다
		// 왜 붉은 줄이 안 뜰까? -> 꼭 예외처리 구문 안 해도 되는 UncheckedException이라서
		
		// 호출된 메서드에서 직접 try / catch 하는 건 좋지 않다
		
		// ArithmeticException이 발생하면 호출한 곳으로 예외를 던지는 throws를 사용
		// ***  UncheckedException은 throws 구문을 안 쓰면, 아무런 예외처리가 안 되어 있는 경우
		// 컴파일러가 자동으로 throws 구문을 생성해준다!!
	}
	
	
	/**
	 * 강제로 Exception 발생시켜서 던짐
	 * @throws Exception
	 */
	public void forcedException() throws Exception {
		throw new Exception();
	}
	
	
	/**
	 * 효율적인 키보드 입력
	 * - Scaneer가 아닌 다른 방법
	 * 
	 * @throws IOException : 키보드 입력 시 발생할 수 있는 문제를 던짐
	 */
	public void inputKeyboard() throws IOException {
		BufferedReader br = null; // br은 finally에서도 쓰도록 밖에 작성하기
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in)); // 객체 생성할 때 오류가 날 수 있으니 try 안에 작성
			
			// System.in : 키보드 입력 (바이트 형식)
			// InputStreamReader : 읽어온 바이트를 문자로 변경하는 통로
			// BufferedReader : 버퍼에 모여있는 내용을 한 번에 읽어옴
			
			// -> 입력된 키보드 값을 문자로 변경하여 버퍼에 모은 후 한 방에 읽어오는 객체를 생성함
			
			System.out.print("문자열 입력 : ");
			String str = br.readLine(); // br.readLine : 입력된 한 줄을 통째로 읽어옴
			
			// readLine() 메서드는 IOException을 던질 가능성이 있음
			// -> 이 부분에 대한 예외 처리 구문을 꼭!!! 작성해 예외상황 대비해야 함
			// IOException은 checkedException이기 때문임!!
			
			System.out.println("입력된 값 : " + str);
		} finally { // catch 진행하지 않을 경우 finally로 진행
			br.close();
			// 예외가 발생하더라도 finally 무조건 실행하고 throws 됨!
		}
	}

	
}
