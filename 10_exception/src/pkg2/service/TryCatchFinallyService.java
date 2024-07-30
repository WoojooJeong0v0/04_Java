package pkg2.service;

import java.util.Scanner;

public class TryCatchFinallyService {


	/*
	 * Try {} : 예외가 발생할 가능성 있는 코드를 블럭에 작성
	 * 
	 * catch(처리할 예외객체 참조 변수) {} : 
	 * try에서 던져진 예외 객체를 잡아서 처리하는 구문
	 * 	-> 예외가 처리되어 (없어져) 프로그램이 강제 종료 되지 않음!!
	 * 
	 * finally{} : 
	 * try 구문에서 예외 발생 여부 상관 없이
	 * 무조건 마지막에 실행되어야 하는 코드를 작성하는 구문
	 */
	
	private Scanner sc = new Scanner(System.in);
	
	
	/**
	 * finally 확인하기
	 */
	public void test1() {
		try {
			System.out.println("1. 정상 수행 / 2. 예외 강제 발생 : ");
			int input = sc.nextInt();
			if (input == 1) {
				System.out.println("예외 없이 정상 수행 됨");
			} else {
				throw new Exception("강제로 던져진 Exception");
			}
			
		}
		catch(Exception e) {
			System.err.println(e.getMessage()); // 자주 사용하면 안 됨, 에러 발생으로 수행 순번이 이상해지기도 함
		}
		finally {
			System.out.println("===무조건 수행===");
		}
	}
	
	
	/**
	 * finally 언제 사용?
	 *
	 ** 	- Java 프로그램 <-> 외부 프로그램/ 장치의 연결을 무조건 끊어야 할 때  
	 */
	public void test2() {
		// Scanner 이용 시 맨날 뜨던 노란 줄
		// Resource leak: 'scan' is never closed
		// 자원 누수 scan이 참조하는 객체가 닫히지 않아서
		// 자원 (메모리) 누수되고 있다는 뜻
		// 	--> 키보드와 연결된 통로 (Stream)가 닫히지 않고 남아있다!
		// 	--> 메모리가 쓸데없이 소비 됨
		
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("1. 정상 수행 / 2. 예외 강제 발생 : ");
			int input = scan.nextInt();
			if (input == 1) {
				System.out.println("예외 없이 정상 수행 됨");
				} else {
				throw new Exception("강제로 던져진 Exception");
				}
		}
		catch(Exception e) {
			System.err.println(e.getMessage()); // 자주 사용하면 안 됨, 에러 발생으로 수행 순번이 이상해지기도 함
		}
		finally { // 프로그램 최적화
			scan.close();
			System.out.println("===scan close 완료===");
			// 예외 발생 여부 관계 없이 무조건
			// 외부 입력 장치와의 통로를 닫아서 메모리 반환 시켜준다!
		}
	
	}
}
