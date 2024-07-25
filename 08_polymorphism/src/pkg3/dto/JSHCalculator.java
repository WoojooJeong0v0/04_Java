package pkg3.dto;

// 인터페이스 상속 키워드 : implements (구현하다)

public class JSHCalculator implements Calculator {

	@Override
	public int plus(int a, int b) {
		int result = a + b;
		
		if(result >= MAX_NUM) {
			result = MAX_NUM;
		} else if (result <= MIN_NUM) {
			result = MIN_NUM;
		}
		
		// if (result > MAX_NUM) return MAX_NUM;
		// if (result < MIN_NUM) return MIN_NUM;
		
			return result;
	}

	@Override
	public int minus(int a, int b) {
		int result = a - b;
		return result;
	}

	@Override
	public int multi(int a, int b) {
		int result = a * b;
		return result;
	}

	@Override
	public int div(int a, int b) {
		int result = a / b;
		return result;
	}

	@Override
	public int mod(int a, int b) {
		int result = a % b;
		return result;
	}

	@Override
	public int pow(int a, int x) {
		double result = (int)Math.pow(a, x); 
		return (int)result;
	}

	@Override
	public double areaOfCircle(double r) {
		return Calculator.PI * r * r;
	}

	@Override
	public String toBinary(int num) {
		String result = Integer.toBinaryString(num);
		return result;
	}

	@Override
	public String toHexadecimal(int num) {
		return null;
	}
	
}
