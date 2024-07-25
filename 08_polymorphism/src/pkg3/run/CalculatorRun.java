package pkg3.run;

import pkg3.dto.Calculator;
import pkg3.dto.JSHCalculator;

public class CalculatorRun {
	public static void main(String[] args) {
		
		// 인터페이스도 추상클래스처럼
		// 객체 생성은 못 함!!! (안이 전부 추상 메서드라서)
		
		// 대신 부모 타입 참조변수로 사용이 가능함!!!
		
		// -> 다형성 업캐스팅 + 동적 바인딩이 적용된다
		
		Calculator c = new JSHCalculator();
		System.out.println(c.plus(900000000, 30000000));
		System.out.println(c.minus(1, 300000));
		System.out.println(c.multi(1303, 3055));
		System.out.println(c.div(3333, 332));
		System.out.println(c.mod(1234, 43));
		System.out.println(c.pow(12, 2));
		System.out.println(c.areaOfCircle(5.7));
		System.out.println(c.toBinary(120));
		System.out.println(c.toHexadecimal(122));
		
	}
}
