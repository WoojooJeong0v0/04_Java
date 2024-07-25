package pkg3.dto;


/**
 * 인터페이스
 * - 뜻 : 접점 
 * 
 * - 효과 : 
 *  1) 클래스 간의 접점을 만드는 용도
 *  2) 극한의 추상화를 통해서 모든 상황에 유연한 대처(코딩) 가능
 *  
 *  - 기본 작성법
 *  1) 필드는 무조건 public static final (공유 가능한 상수)
 *  2) 메서드는 무조건 public abstract --> 추상 메서드 : 오버라이딩 강제화
 *  (누구든지 상속 받아서 오버라이딩 가능)
 *  
 */

public interface Calculator {
	public static final double PI = 3.14;
	
	// public static fianl 을 생략해도 인터페이스 안에 있으면
	// 무조건 인터페이스 작성된 필드는 자동으로 public static final 로 인식 된다!
	int MAX_NUM = 100_000_000;
	
	int MIN_NUM = -100_000_000;
	
	// 메서드는 무조건 public abstract 
	/**
	 * 두 수의 합을 반환
	 * 단, 결과는 최대, 최소값을 넘을 수 없음
	 * @param a
	 * @param b
	 * @return a + b
	 */
	public abstract int plus(int a, int b);
	
	
	/**
	 * 두 수의 차를 반환
	 * 단, 결과는 최대, 최소값을 넘을 수 없음
	 * @param a
	 * @param b
	 * @return a - b
	 */
	public abstract int minus(int a, int b);
	
	
	/**
	 * 두 수의 곱을 반환
	 * 단, 결과는 최대, 최소값을 넘을 수 없음
	 * @param a
	 * @param b
	 * @return a * b
	 */
	public abstract int multi(int a, int b);
	
	
	/**
	 * 두 수의 나누기를 반환
	 * 단, 결과는 최대, 최소값을 넘을 수 없음
	 * @param a
	 * @param b
	 * @return a / b
	 */
	public abstract int div(int a, int b);
	
	
	/**
	 * 두 수의 나머지를 반환
	 * 단, 결과는 최대, 최소값을 넘을 수 없음
	 * @param a
	 * @param b
	 * @return a % b
	 */
	public abstract int mod(int a, int b);
	
	
	/**
	 * a를 x만큼 거듭 제곱한 결과를 반환
	 * 단, 결과는 최대, 최소값을 넘을 수 없음
	 * @param a
	 * @param x
	 * @return a^x
	 */
	int pow(int a, int x);
	
	
	/**
	 * 원의 넓이를 반환
	 * @param r
	 * @return 원의 넓이
	 */
	double areaOfCircle(double r);
	
	
	/**
	 * 전달 받은 정수를 2진수 String으로 변환하여 반환
	 * @param num
	 * @return 2진수
	 */
	String toBinary (int num);
	
	
	/**
	 * 전달 받은 정수를 16진수 String으로 변환하여 반환
	 * @param num
	 * @return 16진수
	 */
	String toHexadecimal (int num);
	
	
	
}
