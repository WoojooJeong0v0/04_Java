package pkg1.run;

import pkg1.dto.Child;
import pkg1.dto.Parent;

public class TestRun1 {
	public static void main(String[] args) {
	
	/**
	 * 다형성 확인
	 */
	
		// 부모 참조 변수 = 부모 객체
		// -> 양쪽 다 Parent 타입 == 컴퓨터 값 처리 원칙 잘 지켜짐
		Parent p1 = new Parent();
		
		// 사용 가능한 필드/메서드 : Parent, Object 것들
		System.out.println(p1.getLastName()); // Parent 것
		System.out.println(p1.hashCode()); // Object 것
		
		System.out.println("---------------------------");
	
		// 자식 참조 변수 = 자식 객체
		// ->
		Child c1 = new Child();
		
		// 사용 가능한 필드/메서드 : Child, Parent, Object 것들
		System.out.println(c1.hashCode()); // Object
		System.out.println(c1.getLastName()); // Parent
		System.out.println(c1.getCar()); // Child
	
		System.out.println("---------------------------");
		
		/** *** 다형성 - 업캐스팅 Up Casting // 캐스팅 : 형 변환
		 * - "부모" 참조 변수 = '자식' 객체
		 * 
		 * - 상속 관계에서만 가능함!
		 * 
		 * - 참조하는 자식 객체가 부모 객체로 변함
		 *  */
		
		
		Parent p2 = new Child(); // 오류 안 남! 부모 객체로 형변환 시킴
		
		// 사용 가능한 필드/메서드
		System.out.println(p2.hashCode()); // Object
		System.out.println(p2.getLastName()); // Parent
//		System.out.println(p2.getCar); // Child 메서드 접근 불가
		
		
		/** *** 다형성 - 다운 캐스팅 Down Casting
		 * - 업 캐스팅 상태에서 (부모참조 = 자식 객체)
		 * 참조 변수의 자료형을 자식 객체 자료형으로 강제 형변환!!
		 *
		 * 
		 */
		
		Parent p3 = new Child(); // 업캐스팅 상태
		
		// p3 (Parent) 를 Child로 강제 형변환하여 
		// 반환된 주소를 c3에 저장함 
		Child c3 = (Child)p3; // Child로 강제 형변환 [다운 캐스팅]
		
		// 아래 방법처럼 필요할 때마다 형변환 가능하지만
		// 가독성이 떨어지므로 보통 자식 참조 변수에 대입해 사용하는 경우가 많다!!
		// ((Child)p3).gatCar();
		
		System.out.println(c3.getCar()); // Child 메서드 가능
		
		System.out.println("---------------------------");
		
		/**
		 * Object 를 이용한 업캐스팅
		 *  + 객체 타입에 따른 다운 캐스팅
		 */
		
		// Object : 모든 클래스나 객체의 최상위 부모 
		Object[] arr = new Object[3]; // Object 객체 참조 변수 3개 묶음
		
		// <- Object 참조 변수 = Parent/Child/Object 타입으로 하나씩 진행
		arr[0] = new Parent(); // 업캐스팅 : Object가 Parent 안에 있는 Object를 찾아와서 Object처럼 보인다 
		arr[1] = new Child(); // 업캐스팅 : Child -> Object 로 업 캐스팅
		arr[2] = new Object(); // 같은 자료형 연산
		
		/**
		 * instanceof 연산자 인스턴스오브 연산자
		 * 
		 * [작성법]
		 * 참조변수명 instanceof 클래스명
		 * 
		 * - 참조하고 있는 객체가 클래스명 객체가 맞는지 확인한다! (true / false)
		 * 
		 **** 주의사항
		 *- instanceof는 참조하고 있는 객체의 상속 관계까지 파악한다
		 * 
		 *- 상속하고 있는 객체도 확인하기 때문에 자식객체를 참조하는 변수에 
		 *	부모 타입을 검사하면 true가 나온다
		 *
		 *	Parent p = new Child(); // 업캐스팅
		 *	p instanceof Child 
		 *	-> p가 참조하는 객체가 Child야?  true 
		 *
		 *	p instanceof Parent
		 *	-> p가 참조하는 객체가 Parent야? true (자식 안에 부모가 있기 때문) 
		 * [업 캐스팅 중에는 참조하는 것이 2개이다!!]
		 * 
		 * ==> 주의사항을 잘 이용하면 Parent, Child 클래스 상속 관계가 맞는지
		 * 확인하는 용도로도 사용 가능하다!! 
		 * 
		 */
		// 향상된 for문
		for(Object obj : arr) {
			/* tip : 자료형을 연달아 검사하는 경우
			 * 마지막 자식의 자료형부터 검사하는 것을 추천!! */
			
			// 얻어 온 요소가 Child 타입이면
			if(obj instanceof Child) { // obj가 참조하고 있는 게 Child타입이야??
				System.out.println("Child입니다");
			}
			
			// 얻어 온 요소가 Parent 타입이면 
			else if(obj instanceof Parent) {
				System.out.println("Parent입니다");
			}
			
			// 얻어 온 요소가 Object 타입이면 
			else {
				System.out.println("Object입니다");
			}
		}
	}
	
	/*
	System.out.println("------------------------------");
	System.out.println("[부모 -> 자식 역순 검사 문제점]");
	
	for(Object obj : arr) {
		// 얻어온 요소가 Object  타입이면
		if(obj instanceof Object) {
			System.out.println("Object 입니다");
		}
		
		// 얻어온 요소가 Parent 타입이면
		else if(obj instanceof Parent) {
			System.out.println("Parent 입니다");
		}
		
		// 얻어온 요소가 Child 타입이면
		else {
			System.out.println("Child 입니다");
		}*/
	}
	

