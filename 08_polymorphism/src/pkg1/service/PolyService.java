package pkg1.service;

import pkg1.dto.Child;
import pkg1.dto.Parent;

public class PolyService {
	
	
	/** [매개변수 다형성]
	 * 
	 * 객체가 가지고 있는 필드 정보 모두 출력
	 * @param obj : Object 객체를 참조하는 참조 변수
	 * Object : 모든 클래스의 최상위 부모!!
	 */
	public void printObject(Object obj) {
		
		// Object obj가 참조할 수 있는 객체
		// -> Object / Parent / Child 
		// 가능한 이유 : 다형성 - 업 캐스팅으로 가능!
		
		System.out.println("----------------------");
		// 전달받은 주소의 객체가 Childe 객체인 경우
		if(obj instanceof Child) {
			System.out.println("[Child]");
			
			Child ch = (Child)obj; // obj -> Child 다운 캐스팅
			
			// 김 / 50000 / 소나타
			System.out.printf("%s / %s / %s \n", ch.getLastName(), ch.getMoney(), ch.getCar());
			}
		// 전달받은 주소의 객체가 Parent 객체인 경우
		else if (obj instanceof Parent) {
			System.out.println("[Parent]");
			Parent p = (Parent)obj; // obj -> Parent 다운 캐스팅
			System.out.printf("%s / %s \n", p.getLastName(), p.getMoney());
		} else {
			System.out.println("[Object는 필드없음]");
		}
		System.out.println("----------------------");
	}
	
	/**
	 * 매개변수 다형성 테스트
	 */
	public void test1() {
		Object o = new Object();		
		Parent p = new Parent("홍", 100);		
		Child c = new Child("박", 333, "모닝");
		
		printObject(o);
		printObject(p);
		printObject(c);
		
		// -> 매개변수의 다형성이 적용되지 않았다면
		// 각 자료형 별로 매개변수를 전달받는 메서드를
		// 계속 오버로딩을 하는 문제가 발생한다!!
		
		// ex)
		// public void printObject(Object o)
		// public void printObject(Parent p)
		// public void printObject(Child  c)
		
	}
	
	/**
	 * 전달 받은 값에 따라 알맞은 객체를 만들어서 반환하는 메서드
	 * @param num : 1- Object / 2 - Parent / 3 - Child 객체 생성
	 * @return 생성된 객체 반환
	 */
	public Object getInstance(int num) { // 반환되는 객체 타입은 Object이다
	
		if(num == 1) return new Object();
		// 생성된 객체 타입 : Object
		// 주소는 : 0x100 가정
		
		if(num == 2) return new Parent();
		// 생성된 객체 타입 : Parent
		// 주소는 : 0x200 가정
		
		return new Child();
		// 생성된 객체 타입 : Child
		// 주소는 : 0x300 가정
		}
	
	public void test2() {
		
		Object o1 = getInstance(1); // Object객체 , 0x100
		
		// 부모참조변수 = 자식 객체 (업캐스팅 적용)
		Object o2 = getInstance(2); // Parent객체 , 0x200
		Object o3 = getInstance(3); // Child객체 , 0x300
		
		// 매개변수 다형성 적용확인 메서드 호출한다!
		printObject(o1);
		printObject(o2);
		printObject(o3);
	}
	
	
	/**
	 * 바인딩 확인
	 */
	public void test3() {
		Parent p1 = new Parent(); // 부모가 부모 참조
		Child c2 = new Child(); // 자식이 자식 참조
		Parent p3 = new Child(); // 부모 = 자식 (업캐스팅)
		
		System.out.println(p1.toString()); // Parent.toString()
		System.out.println(c2.toString()); // Child.toString()
		System.out.println(p3.toString()); // Parent.toString() 
		// -- 정적 바인딩 : 프로그램 실행 "전" 에 일어남
		// -> 왜? Parent와 연결되었나?
		// 참조변수가 Parent 이기 때문에, Child가 업캐스팅되어 Parent로 연결된다
		
		
		// 동적 바인딩 : 프로그램 실행 "중"에 일어남
		// toString() 호출 구문이 Parent에서 Child 로 변경됨 !!!
		// -> 왜? 
		// Child가 Parent의 toString()을 재정의하는 Override 하였기 때문에 우선권가짐!!
		
		// * 업캐스팅 상태에서는 오버라이딩한 메서드가 우선권을 갖는다!!!
	}
	
	/**
	 * 객체 배열의 다형성 + 바인딩 예제
	 */
	public void test4() {
		Object[] arr = new Object[4];
		
		// 참조 변수 타입 == Object
		// 대입되는 객체 주소 == Parent, Child (자식 타입)
		// -> 업 캐스팅이 적용된 상태 
		arr[0] = new Parent();
		arr[1] = new Parent("이", 30000);
		
		arr[2] = new Child();
		arr[3] = new Child("박", 50000, "캐스퍼");
		
		for(Object obj:arr) {
			System.out.println(obj.toString());
			// 실행 전 : Object.toString() 연결 (정적 바인딩)
			// 실행 중 : Parent.toString(), Child.toString() 연결 (동적 바인딩)
			// 오버라이딩한 것에 우선순위가 있기 때문임!!
			
			
			// print() 관련 구문에 참조변수명을 작성하면 자동으로 toString() 메서드 호출한다
		}
		
		System.out.println("----------------------------");
		System.out.println("[만약 동적 바인딩이 없었더라면]");
		for(Object obj : arr) {
			if(obj instanceof Child) {
				System.out.println ( ((Child)obj).toString());
			} else if(obj instanceof Parent) {
				System.out.println(((Parent)obj).toString());
			} else {
				System.out.println(obj.toString());
			}
		}
	}
	
}
