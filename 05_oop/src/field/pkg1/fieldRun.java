package field.pkg1;

public class fieldRun {
	public static void main(String[] args) {
		
		
		// FieldTest1 객체 생성
		
		FieldTest1 f1 = new FieldTest1(); // public 이라 어디서든 가능
		
		
		// public field 직접 접근
		System.out.println(f1.publicValue);
		
		// protected field 직접 접근
		// 같은 패키지라서 가능!
		System.out.println(f1.protectedValue);		
		
		// (default) field 직접 접근
		// 같은 패키지라서 가능!
		System.out.println(f1.defaultValue);
		
		// private field 직접 접근
		// 다른 곳이나 객체가 private (개인적인) 필드를 접근할 수 없다
//		System.out.println(f1.privateValue); // 문제 발생
		
		
		
	}

}
