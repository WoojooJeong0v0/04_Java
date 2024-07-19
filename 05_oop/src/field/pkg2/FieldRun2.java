package field.pkg2;

import field.pkg1.FieldTest1;

// 다른 패키지
public class FieldRun2 extends FieldTest1 { // 상속 구문
public static void main(String[] args) {
	
	
	// FieldTest1 객체 생성
	
	FieldTest1 f1 = new FieldTest1();
	
	// public
	System.out.println(f1.publicValue);
	
	// protected field
//	System.out.println(f1.protected); // 문제 발생 : 상속 관계가 아닌 상태에서는 안 됨
	
	// (default)
//	System.out.println(f1.defaultValue); // 같은 패키지만 접근 가능한데 다른 패키지이다 
	
	// private
//	System.out.println(f1.privateValue); // 당연히 안 됨
	}
	
	public void method() {
		
		System.out.println(protectedValue); // 상속 구문을 추가하여 확인하면 가능!
		// 메인 바깥쪽에
		
	}
	
}
