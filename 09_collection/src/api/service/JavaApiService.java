package api.service;

import java.util.Arrays;
import java.util.Scanner;

import api.dto.TestDto;

public class JavaApiService {
	/**
	 * String
	 * - java.lang 패키지에서 제공되는 클래스
	 * - 문자열을 저장하고 다루는 용도의 객체(원래는 클래스인데 객체로 만들어 사용 중)
	 * 
	 * [String 객체 생성 방법]
	 * 
	 * 1) String s1 = "Hello"; // 리터럴 표기법 이용한 방법
	 *	// 객체가 만들어지는데 new 구문이 안 적히는 특이한 형태
	 *	-> Heap 영역 내부에 Constant(상수) Pool에 String 객체가 생성
	 * 
	 * 2) String s2 = new String("Hello"); // new 연산자 이용
	 * 	-> new : Heap 영역에 String 객체를 생성한다 
	 * 
	 * [String의 불변성(immutable)]
	 * 
	 * - String은 기본적으로 값이 변하는 것이 불가능
	 * 
	 * 예 ) String str = "abc"; // "abc"		/ 참조 주소 : 0x100
	 * 		str += "def";		// "abcdef"		/ 참조 주소 : 0x300
	 * 		-> 참조하는 객체 주소가 달라진다!! (다른 객체가 됨!)
	 * 
	 */
	
	
	/**
	 * [String 불변성 확인]
	 * 
	 * - String 클래스에서 값을 저장하는 필드가 final (상수)
	 * 	-> 상수 == 변경 불가
	 * 
	 * - System.identityHashCode("참조변수(객체)") // 실제로 저장된 메모리코드를 이용해서 해시코드를 만듬
	 * 	-> 객체의 주소값을 이용해서 생성된 해시코드
	 *  -> 모든 객체가 다른 결과를 반환 (절대 겹치지 않음!)
	 *  
	 * - 같은 객체에 저장된 값이 변했다면, 주소값은 일정해야만 한다!!
	 * 
	 * - 참조하고 있던 객체가 변했다면, 주소값도 변하게 된다!
	 * 
	 */
	public void test1() {
		TestDto t = new TestDto();
		
		// TestDto객체의 주소를 이용해서 만든 해시코드 확인
		System.out.println("TestDto : " + System.identityHashCode(t));
		
		// TestDto 객체의 필드값을 변경
		t.setNum(200);
		t.setStr("Apple");
		// 변경 후 TestDto
		System.out.println("TestDto : " + System.identityHashCode(t));
		
		System.out.println("----------------------------------");
		
		System.out.println("String 확인");
		// String 객체 생성 (리터럴 표기법 이용)
		String s = "hello";
		System.out.println("String : " + System.identityHashCode(s));
		
		// s가 참조하는 객체의 값을 변경
		s += "World"; // 누적
		System.out.println("String : " + System.identityHashCode(s)); // 해시코드가 달라짐!!
		
	}
	
	
	/**
	 * Constant Pool 확인
	 *  - "" String 리터럴 표기법 (쌍따옴표) 이용해 생성된 String 객체가 저장되는 Heap 내부 영역
	 *  
	 *  - 동일한 문자열을 생성하게 되는 경우 객체가 새롭게 생성되지 않고
	 *    기존 주소가 반환된다 (재활용)
	 */
	public void test2() {
		String s1 = "Hello"; // 2055281021 // 상수풀에 생성됨
		System.out.println("s1 : " + System.identityHashCode(s1));
		
		// 같은 값을 지닌 String을 새롭게 생성
		String s2 = "Hello";
		System.out.println("s2 : " + System.identityHashCode(s2)); // 상수풀 생성된 기존 것을 재활용
		
		// 같은 값을 지닌 String을 new 연산자 이용해서 생성
		String s3 = new String("Hello");
		System.out.println("s3 : " + System.identityHashCode(s3)); // Heap에 새로 생성
		
		System.out.println("-----------------------------");
		
		// s1, s2는 같은 객체를 참조한다
		// == s1, s2에 저장된 주소값이 동일하다
		// -> equals()를 사용하지 않아도 비교가 가능함!
		
		System.out.println("s1 == s2 : " + (s1 == s2) ); // 우선순위 때문에 괄호치고 써야 함 // true
		
		// s1, s3는 저장된 값은 같아도 서로 다른 객체를 참조하는 중
		// 주소 값이 다르기 때문에 비교 연산 시 무조건 false
		// -> 그래서 문자열 비교는 equals()로 하는 게 속 편함!
		
		System.out.println("s1 == s3 : " + (s1 == s3) ); // false
		
	}
	
	
	/**
	 * StringBuilder / StringBuffer 클래스
	 * - String의 불변성 문제를 해결한 클래스
	 *  -> 가변성(mutable)
	 * 
	 * - 기본 16글자 저장할 크기로 생성
	 *   저장되는 문자열의 길이에 따라 크기가 증가/감소
	 *   -> 마음대로 문자열 수정, 삭제 가능!
	 *   -> 수정, 삭제를 해도 추가적인 객체 생성이 없어 효율 좋음!
	 *   
	 *  
	 * - StringBuilder : Thread Safe 미제공 (비동기, 추천)
	 * - StringBuffer  : Thread Safe   제공 (동기)
	 */
	public void test3() {
		//StringBuilder 객체 생성
		StringBuilder sb = new StringBuilder();
		
		// StringBuilder는 내부 필드에 문자열을 추가하여 누적하는 방식
		
		/*  문자열 추가 전 주소 */
		System.out.println(System.identityHashCode(sb));
		
		// 1) append("문자열") : 문자열을 뒤쪽에 추가(누적 시킴)
		sb.append("Hello");
		sb.append("World");
		sb.append("\n");
		sb.append("점심시간~");
		
		/*  문자열 추가 후 주소 */
		// 주소가 계속 똑같음
		// 객체 필드 값만 변하고 있음 (가변성 확인)
		System.out.println(System.identityHashCode(sb));
		
		// 2) toString() : 필드 값을 문자열로 반환
		System.out.println(sb.toString());
	}
	
	
	/**
	 * String 관련 메서드
	 */
	public void test4() {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		System.out.println("[아무 단어/문장 5번 입력하기]");
		for(int i = 0 ; i < 5 ; i++) {
			// 입력 받은 값을 StringBuilder에 누적
			System.out.print(i + " : ");
			sb.append(sc.nextLine());
		}
		
		System.out.println("---------------");
//		System.out.println(sb.toString());
		
		// StringBuilder에 누적된 문자열을 String 형태로 반환
		String input = sb.toString();
		
		// 1) String[] 문자열.split("구분자")
		// - 문자열을 "구분자" 기준으로 나누어서 String[] 배열 형태로 반환
		
		String[] arr = input.split("/"); // 슬래시 / 기준으로 쪼갠다
		// 스페이스로 기준을 삼고 싶으면 " " 안에 스페이스 한 칸 넣고
		// 엔터로 기준을 삼고 싶으면 nextLine 밑에 sb.append("\n"); 추가하기
		// 그 이후 기준을 "\n" 개행 문자 표기로 넣고 진행하기
		System.out.println(Arrays.toString(arr));
		
		// 2) String String.join("구분자", 배열)
		// - String 배열을 하나의 문자열로 변환
		// - 각 요소 사이에 "구분자" 추가
		
		String result = String.join("***", arr);
		System.out.println(result);
		
		// 3) String 문자열.replace ("대상 문자열", "바꿀 문자열")
		// - 문자열 변경
		
		String str = "Hello World";
		String str2 = str.replace("Hello", "Hi");
		
		System.out.println(str2);
	}
	
	
}
