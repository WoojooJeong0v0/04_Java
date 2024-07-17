package condition.ex;

import java.util.Scanner;

/**
 * 조건문 예시 기능용 클래스
 */

public class ConditionEx {
	
	// 전역변수 비슷 (필드 field) == 멤버 변수 == 인스턴스 변수
	Scanner sc = new Scanner(System.in);

	/**
	 * 1 ~ 10 사이 난수가 짝수인지 홀수인지 출력
	 */
	public void method1() {
		int ran = (int)(Math.random() * 10 + 1);
		
		if(ran % 2 !=1 ) {
			System.out.println("짝수입니다");
		}else {
			System.out.println("홀수입니다");
		}
	}
	
	/**
	 * 나이를 입력 받아
	 * 13세 이하 : 어린이
	 * 14세 이상 19세 이하 : 청소년
	 * 20세 이상 :  성인
	 * 
	 * 구분하여 출력하기
	 */
	public void method2() {
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt(); // 필드 sc이용
		
		String result;
		
		if(age >= 20) {
			result = "성인입니다";
		} else if(age >= 14) {
			result = "청소년입니다";
		} else {
			result = "어린이 입니다.";
		}
		
		System.out.println(result);		
	}
	
	/**
	 * 나이를 입력 받아
	 * 13세 이하 : 어린이
	 * 14세 이상 19세 이하 : 청소년
	 * 	- 14~16 : 청소년(중)
	 * 	- 17~19 : 청소년(고)
	 * 20세 이상 :  성인
	 * 
	 * 0 이하 또는 100 초과 : 잘못 입력하셨습니다
	 * 
	 * 구분하여 출력하기
	 */
	public void method3() {
		System.out.print("나이 입력 : ");
		int age = sc.nextInt(); // 필드 sc이용
		
		String result;
		
		// 직접 입력한 코딩
		if(age > 100 || age < 0) result = "잘못 입력하셨습니다";
		else if(age >= 20) 	   	result = "성인입니다.";
		else if(age >= 17) 		result = "청소년(고)입니다.";
			/*
			 * // else if(age <= 19) { // 청소년 
			 * result = "청소년" + ((age<=16) ? "(중)" : "(고)");
			 * }
			 */
		else if(age >= 14)  	result = "청소년(중)입니다.";
		else 					result = "어린이입니다.";
				
		System.out.println(result);
		
	}
	
	/**
	 * switch 이용한 메서드 호출
	 */
	
	public void displayMenu() { // 메뉴를 표시해라
		
		System.out.println("1. method1() - 난수 홀짝");
		System.out.println("2. method2() - 나이 구분1");
		System.out.println("3. method3() - 나이 구분2");
		System.out.println("4. method4() - 계절 찾기");
		System.out.println("5. method5() - 성적표");
		
		System.out.print("번호를 선택 >> ");
		int num = sc.nextInt();
		
		System.out.println("----------");
		
		switch(num) {
		case 1 : method1(); break; // 1 입력 시 method1() 호출
		case 2 : method2(); break;
		case 3 : method3(); break;
		case 4 : method4(); break;
		case 5 : method5(); break;
		default : System.out.println("잘못 입력하셨습니다. 1~3 중 누르세요.");
		}
		
	}
	
	/** switch 이용
	 * 입력된 달(월)의 계절 출력하기
	 */
	public void method4() {
		System.out.print("달(월) 입력 : ");
		int month = sc.nextInt();
		
		String result;
		
		switch(month) {
		
		//case 를 연속해서 작성하는 방법 
		// 1) 세로로 쭉
		case 3 : 
		case 4 : 
		case 5 : result = "봄"; break; 
		
		// 2) 가로로 쭉
		case 6 : case 7 : case 8 : result = "여름"; break;
		
		// 3) case 값, 값, 값 형식
		case 9 , 10 , 11 : result = "가을"; break;
		
		case 12, 1, 2 : result = "봄"; break;
		
		default : result = "잘못 입력";
		} // switch end
		
		System.out.println(result);
	}
	
	
	/**
	 * 성적 판별기 만들기
	 * 
	 * 중간고사, 기말고사, 과제 점수를 입력 받아 성적 부여
	 * 
	 * - 중간고사 (40%)
	 * - 기말고사 (50%)
	 * - 과제 (10%)
	 * 
	 * - 입력 시 각각 100점 만점으로 입력 받음
	 * 
	 * - 합산된 점수에 따라 성적 부여
	 * 
	 * 95 점 이상 : A+
	 * 90 점 이상 : A
	 * 85 점 이상 : B+
	 * 80 점 이상 : B
	 * 75 점 이상 : C+
	 * 70 점 이상 : C
	 * 65 점 이상 : D+
	 * 60 점 이상 : D
	 * 나머지 : F
	 * 
	 * 
	 * [실행화면]
	 * 홍길동의 최종 점수 : 85.0점
	 * 성적 : B+
	 * 
	 */
	public void method5() {
		System.out.println("이름을 입력하세요");
		sc.nextLine(); // 메뉴에서 5번을 눌렀을 때 엔터가 들어오니까 없애줘야 한다!
		String name = sc.nextLine();
		
		System.out.println("중간고사 점수를 입력하세요");
		int jung = sc.nextInt();
		
		System.out.println("기말고사 점수를 입력하세요");
		int gim = sc.nextInt();
		
		System.out.println("과제 점수를 입력하세요");
		int gwa = sc.nextInt();
		
		double average = (jung * 0.4 + gim * 0.5 + gwa * 0.1);
		
		String result;
		
		
		// swith문 ()괄호에 들어갈 수 있는 값은 int, String 두 개만 된다
		switch((int)(average/5)){
		
		case 20, 19 : result = "A+"; break;
		case 18 : result = "A"; break;
		case 17 : result = "B+"; break;
		case 16 : result = "B"; break;
		case 15 : result = "C+"; break;
		case 14 : result = "C"; break;
		case 13 : result = "D+"; break;
		case 12 : result = "D"; break;
		default : result = "F";		
		}
		
		/*강사님 풀이 
		 * 	// 점수 합계
		double sum = (midTerm * 0.4) + (finalTerm * 0.5) + (report * 0.1);
		
		String result;
		
		switch( (int)sum/10 ) {
		case 10, 9 : result = "A"; break;
		case 8 : result = "B"; break;
		case 7 : result = "C"; break;
		case 6 : result = "D"; break;
		default : result = "F";
		}
		
		// 60초과된 sum 중에서 1의 자리가 5 이상인 값들만 + 추가
		if(sum > 60 && sum % 10 >= 5)  result += "+";
		
		 * */
				
		System.out.printf("%s의 최종 점수 : %.1f \n성적 : %s", name, average, result);
		
		
//		System.out.println(100*10/100);
		
		
		
//		System.out.printf("이름 : %c \n 중간고사 점수 : %d \n 기말고사 점수 : %d \n 과제 점수 : %d \n 최종 점수 : ()점 \n 성적 : %c");
		
	}
	
	
	/** [연습 문제]
	 * 국어, 영어, 수학, 사탐, 과탐 점수를 입력 받아
	 * 40점 미만 과목이 있으면 FAIL
	 * 평균이 60점 미만인 경우도 FAIL // 평균점수 구하기는 (국+영+ 수+ 사+ 과)/5
	 * 만약 평균이 60점 아래라면 
	 * 
	 * 모든 과목 40점 이상, 평균 60점 이상인 경우 PASS // 만약( 모든 과목이 40점 이상 && 평균 60점 이상) pass 
	 * 
	 * [출력 예시]
	 * 점수 입력(국 영 수 사 과) : 100 50 60 70 80
	 * 
	 * 
	 * 1) 40점 미만 과목이 존재하는 경우
	 * FAIL [40점 미만 과목 : 국어 영어]
	 * 
	 * 
	 * 2) 평균 60점 미만인 경우
	 * FAIL [점수 : 50.4 (평균 미달)]
	 * 
	 * 
	 * 3) PASS인 경우
	 * PASS [점수 : 83.4 / 100] */
	 
		public void practice() {
		System.out.print("점수 입력(국 영 수 사 과) : ");
		
		int kor = sc.nextInt(); // 국
		int eng = sc.nextInt(); // 영
		int mat = sc.nextInt(); // 수
		int soc = sc.nextInt(); // 사
 		int sci = sc.nextInt(); // 과
 		
 		// 40점 미만인 과목 검사
 		boolean flag = false;
 		String str = ""; // 빈칸(자료형은 String, 내용은 없음) 
 		
 		if(kor < 40) {
 			flag = true;
 			str += "국어 "; }
 			
 		
 		if(eng < 40) {
 			flag = true;
 			str += "영어 "; }
 			

		if(mat < 40) {
			flag = true;
			str += "수학 "; }
			
			
	 	if(soc < 40) {
	 		flag = true;
	 		str += "사회 "; }
	 		
	 		
	 	if(sci < 40) {
	 		flag = true;
	 		str += "과학 "; }
	 		
		
		// 40점 미만 과목이 존재하는 경우
		if(flag) {
			System.out.printf("FAIL [ 40점 미만 과목 : %s]", str);
			return;
		}
 		
 		
 		// double 형 결과를 반환 받기 위해 강제 형변환, 5.0으로 나누다 
		double avg = (kor + eng + mat + soc + sci) / 5.0;
		
		if(avg < 60.0){
			System.out.printf("FAIL [점수 : %.1f (평균미달)]", avg);
			return; // Early return; (중간에 메서드를 종료)
		}
		
			System.out.printf("PASS [점수 : %.1f / 100]", avg);
			
		}
		
		
	}