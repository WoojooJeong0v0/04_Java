package ex;

/* 예제 기능용 클래스
 * */

import java.util.Scanner;

public class OperatorEx {
	
	// OperatorRun 에서 호출할 수 있는 기능(메서드, 함수)을 정의해두는 클래스
	
	// method == 객체(클래스)가 가지고 있는 기능(function)
	
	//test1() 메서드
	public void test1() {
		System.out.println("test1() 메서드 호출됨");
	}
	
	public void test2() {
		System.out.println("22222222222");
	}
	
	/**
	 * 슬래시 별별 엔터
	 * 입력 받은 두 정수의 산술 연산 결과 출력하기
	 * 
	 * 정수 입력1 : 10
	 * 정수 입력2 : 3
	 * 
	 *  10 + 3 = 13 
	 *  10 -3 = 7
	 *  10 * 3 = 30
	 *  10 / 3 = 3 // 인트 나누기 인트는 인트 
	 *  10 % 3 = 1
	 */
	public void method1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 1 : ");
		int num1 = sc.nextInt(); // 입력 버퍼에 있는 다음 정수 읽어오기, 정수만 읽고 [엔터]는 남음
		
		System.out.print("정수 입력 2 : ");
		int num2 = sc.nextInt();
		
		System.out.println(); // 빈칸을 입력하고 줄을 바꿔라!
		
//		System.out.println(num1 + "+" + num2 + "=" + (num1+num2));
		// \n : 개행 (escape 문자)
		System.out.printf("%d + %d = %d \n", num1, num2, num1 + num2);
		System.out.printf("%d - %d = %d \n", num1, num2, num1 - num2);
		System.out.printf("%d * %d = %d \n", num1, num2, num1 * num2);
		System.out.printf("%d / %d = %d \n", num1, num2, num1 / num2);
		System.out.printf("%d %% %d = %d \n", num1, num2, num1 % num2);
		
		// printf에서 %% == '%', 그냥 %만 쓰면 뒤에오는 %가 뭐냐고 물어보는 에러 
		
	}
	
	/**
	 * 입력 받은 정수가 3의 배수가 맞는지 확인
	 */
	public void method2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		// input이 3의 배수가 맞으면 true, 아니면 false 를 저장
		boolean isTrue = input % 3 == 0;
		
		System.out.printf("%d 는 3의 배수인가? %b",input, isTrue);
	}
	
	
	/**
	 * 첫 번째 입력 받은 수가 두 번째 입력 받은 수의 배수가 맞는지 확인
	 * 
	 * 
	 * [true인 경우]
	 * 첫 번째 입력 : 20
	 * 두 번째 입력 : 5
	 * 
	 * 20은 5의 배수가 맞는가? true
	 * 
	 * 
	 * [false인 경우]
	 * 첫 번째 입력 : 18
	 * 두 번째 입력 : 5
	 * 
	 * 18은 5의 배수가 맞는가? false
	 * 
	 */
	public void method3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("정수 입력 2 : ");
		int num2 = sc.nextInt();
		
		boolean isTrue = num1 % num2 == 0;
		
		System.out.printf("%d는 %d의 배수인가? %b", num1, num2, isTrue);
		
	}
	
	
	/**
	 * 생성된 난수가 1이상 10 이하 짝수가 맞는지 확인
	 * 난수 범위는 1~20 
	 */
	public void method4() { 
		// 1~20 사이 난수
		int randomNumber = (int)(Math.random()* 20 + 1); // 0부터 1 미만, 1.0 ~ 10.9
		// (int) 강제 형변환
		
		System.out.println("생성된 난수 : " + randomNumber);
		
		// 1이상 10 이하가 맞는지 확인
		boolean result1 = randomNumber >= 1 && randomNumber <= 10;
		// 짝수 확인
		boolean result2 = randomNumber % 2 == 0;
		
		System.out.println("1~10사이 짝수 맞아? " + (result1 && result2));
	}
	
	/**
	 * 입력 받은 수가 짝수이거나 10보다 큰 수인지 확인하기
	 */
	public void method5() {
		int randomNumber = (int)(Math.random()*20 + 1);
		
//		System.out.println("생성된 난수 : " + randomNumber);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 1 : ");
		int num1 = sc.nextInt();
		
		
		boolean result1 = (num1 % 2 == 0) || (num1 > 10);
//		boolean result2 = num1 > 10;
		
//		boolean result = (input % 2 == 0) || (input > 10); 강사님 것
		
		System.out.println("result : " + result1);
		
//		System.out.println("짝수이거나 10보다 큰 게 맞아? " + (result1 + result1));
		
	}
	
	
/**
 * 삼항 연산자 1
 * 1~10사이 난수를 발생시켜 홀짝 검사 진행
 */
	public void method6() {
		// 1 ~ 10 사이 난수
		int ran = (int) (Math.random()*10 + 1);
		
		//
		String result = (ran % 2 == 0) ? "짝수" : "홀수"; 
		
		System.out.printf("%d은/는 %s", ran, result);
	}
	
	/**
	 * 삼항 연산자2
	 * 나이를 입력 받아 
	 * 13세 이하면 "어린이"
	 * 14세 이상 19세 이하 "청소년"
	 * 20세 이상 "성인" 출력
	 * 
	 */
	public void method7() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		String result = age <= 13 ? "어린이" : (age >= 20 ? "성인" : "청소년");
		
		System.out.println(result);
	}
	

}
