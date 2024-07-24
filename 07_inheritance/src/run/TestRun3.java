package run;

import dto.Child1;
import dto.Child2;
import dto.Child3;

public class TestRun3 {
public static void main(String[] args) {
	
	// Child 1, 2, 3 객체 생성
	
	Child1 c1 = new Child1();
	Child2 c2 = new Child2();
	Child3 c3 = new Child3();
	
	// 공통된 규약 확인
	System.out.println(c1);
	System.out.println(c2);
	System.out.println(c3);
	/* Parent를 상속받은 Child 1, 2, 3가
	Parent의 toString()을 오버라이딩/저쟁의 할 때
	공통적으로 super.toString() 구문을 작성함! 
	-> Parent의 toString() 하나를 수정했을 뿐인데
	 Child1,2,3의 toString()의 모든 결과가 수정됨!!!
	 ---> 상속 받은 클래스에 대한 [공통적인 규약]
	 
	 [상속 장점]
	 1. 코드 길이 감소
	 	-> 부모 필드/메서드를 자식이 안 써도 사용 가능
	 	
	 2. 재사용성 증가
	 	-> super(), super.참조변수를 이용해 
	 	부모 코드를 호출해서 자식 코드 길이가 감소
	
	 3. 공통적인 코드 관리, 유지보수성 증가
	 	-> 부모의 코드만 수정해도
	 	해당 코드를 활용하면 자식의 코드도 일괄 수정 됨
	 	
	 4. 오버라이딩 장점// 자식에게 상속하는 기능의 이름을 강제할 수 있음
	 	오버라이딩 시 부모의 메서드명과 동일해야 함!!
 	*/
	
	}
}