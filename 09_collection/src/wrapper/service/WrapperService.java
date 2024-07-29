package wrapper.service;


// Java에서 중요한 클래스만 모아둔 패키지
// -> String, Wrapper Class 등
// 미작성 시 컴파일러가 자동으로 추가해 주는 구문
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperService {
	/* Wrapper Class
	 * 
	 * - wrap : 감싸다, 포장하다
	 * 
	 * - 기본 자료형을 객체(속성, 기능)로 감싸는 클래스
	 *   -> 기본 자료형의 객체화
	 *   
	 *   -> 왜? 컬렉션 처럼 객체만 취급하는 상황에서
	 *      기본 자료형도 취급 가능한 형태로 바꾸기 위해서
	 *   
	 *          
	 *              -->   Boxing
	 *   Unboxing  <--
	 *   
	 *   boolean   <-->   Boolean
	 *   byte      <-->   Byte
	 *   short     <-->   Short
	 *   int       <-->   Integer
	 *   long      <-->   Long
	 *   float     <-->   Float
	 *   double    <-->   Double
	 *   char      <-->   Character
	 *  
	 *  * Boxing, Unboxing을 자동으로 수행되도록 구현되어 있음
	 *   -> Auto Boxing, Auto Unboxing
	 *   
	 * 
	 *  + Wrapper Class를 이용해 객체화 되었을 때
	 *  추가적인 필드, 기능을 제공함
	 */
	
	
		public void test1() {
			// int -> Integer로 Boxing			
			int num1 = 100;
//			Integer wrap1 = new Integer(num1);
			//The constructor Integer(int) has been deprecated since version 9 and marked for removal
			// deprecated 더이상 사용되지 않는
			
			Integer wrap1 = num1; // (int)
			// 다른 자료형인데 오류가 안 남 
			// -> 컴파일러가 Auto Boxing을 수행하여 오류가 발생하지 않음
			// 컴파일러가 new Integer(num1) 형태로 변환
			
			// Integer -> int UnBoxing
			int num2 = wrap1.intValue(); // 정석 방법
			int num3 = wrap1; // (Integer)
			// 좌변우변 자료형이 다르지만 대입이 됨
			// -> 컴파일러가 Auto Unboxing 을 수행하여 오류가 발생하지 않음!
			// wrap1 -> wrap1.intValue()로 변환
			
			/* int 자료형을 저장하는 List(Collection)*/
//			List<int> list = new ArrayList()<int>(); 제네릭에 기본 자료형이라 오류가 남
			List<Integer> list = new ArrayList<Integer>();
			list.add(100); // (int)100 -> (Integer)100 // AutoBox
			
			list.add(300);
			list.add(1, 200); // 1번 인덱스에 200을 추가해라 (중간 삽입)
			
			// 향상된 for문
			// 좌변 : 각 인덱스, 요소 값을 얻어와 저장할 변수를 하나 만듬 (자료형 동일)
			// 우변 : 배열 또는 컬렉션
			for(int i : list) { // Auto Unboxing 자동 수행
				System.out.println(i);
			}
			
			int num4 = 4000;
			Integer wrap4 = num4; // int가 자동으로 Integer로 변환
			
			// Integer -> long (Auto Unboxing + 자동 형변환)
			// Integer 4000 -> int 4000 -> Auto Unboxing
			// int 4000 -> long 4000L // 자동 형변환
			// 정수를 정수에 대입했다
			long longNum4 = wrap4;
		}
		
		
		/**
		 * Wrapper Class가 제공하는 필드, 메서드
		 * -> 대부분이 static으로 되어 있음!!
		 * -> 프로그램 실행 시 static 영역에 필드/메서드 생성
		 * --> 클래스명.필드명 / 클래스명.메서드명() 으로 사용 가능!!
		 */
		public void test2() {
			// 정수형 / 실수형 공통 필드
			System.out.println("byte의 용량 : " + Byte.BYTES + "바이트");
			System.out.println("int의 용량 : " + Integer.BYTES + "바이트");
			System.out.println("double의 용량 : " + Double.BYTES + "바이트");
			
			System.out.println("byte의 용량 : "    + Byte.SIZE    + "비트");
			System.out.println("int 의 용량 : "    + Integer.SIZE + "비트");
			System.out.println("double 의 용량 : " + Double.SIZE  + "비트");
			
			System.out.println("Int 최대값 : " + Integer.MAX_VALUE);
			System.out.println("Int 최소값 : " + Integer.MIN_VALUE);
			
			System.out.println("----------");
			
			// 실수형만 사용 가능한 필드
			System.out.println(Double.NaN);
			System.out.println(Double.POSITIVE_INFINITY); // Not a Number
			System.out.println(Double.NEGATIVE_INFINITY); // Not a Number
			
			// 논리형은 TRUE / FALSE만 존재
			System.out.println(Boolean.TRUE);
			System.out.println(Boolean.FALSE);
			
			System.out.println("----------");
			
			System.out.println("[String을 기본 자료형으로 변환]");
			// 다른 언어 (특히 HTML, JS)에서 전달된 값이 있을 경우
			// 보통 String 형태로 전달되는 경우가 많다!!!
			// 이를 Java에서 기본 자료형으로 변환하는 경우 사용!
			// 단 char (Character)는 존재하지 않음
			/**
			 * WrapperClass.parse자료형("문자열")
			 * 
			 * parsing (파싱) : 성질 (형태) 자체를 다른 것으로 변경
			 * 					String -> int 
			 * 
			 * casting (형변환 캐스팅) : 값의 범위 변경
			 */
			byte b = Byte.parseByte("1"); // Parsing 중
			short s = Short.parseShort("2");
			int i = Integer.parseInt("3");
			long l = Long.parseLong("4");
			float f = Float.parseFloat("0.1");
			double d = Double.parseDouble("0.2");
			boolean bool = Boolean.parseBoolean("true");
			
			System.out.println("변환 확인");
			
			System.out.println("----------");
			
			System.out.println("[기본 자료형 -> String]");
			// int 500 -> String "500" 
			// 방법 1 ) 기본 자료형 + "" (String)
			int num5 = 500;
			String change1 = num5 + ""; // String  변환
			// 권장하지 않는 방법
			
			// 방법 2 ) Wrapper Class의 valueOF() / toString() 이용
			String change2 = Integer.valueOf(num5).toString();
			String change3 = Integer.toString(num5);
			
			System.out.println(change1);
			System.out.println(change1 instanceof String);
			
			System.out.println(change2);
			System.out.println(change2 instanceof String);
			
			System.out.println(change3);
			System.out.println(change3 instanceof String);
		
		}
		
		
}
