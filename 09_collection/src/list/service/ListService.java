package list.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Collection == Framework
 *  - 자바에서 제공하는 자료 구조를 모아둔 것
 *  (java.util 패키지에 존재)
 *  
 *  [특징]
 *  1) 크기 제한이 없음
 *  2) 추가, 수정, 삭제, 검색, 정렬 등 다양한 기능 제공
 *  3) 객체만 저장 가능!!! -> 정확히는 객체 참조 주소만 저장 가능
 *  
 *  
 * 	[List] (인터페이스)
 * - 자료(Data)를 순차적으로 나열한 자료 구조 (배열과 비슷)
 * - index가 존재함 
 *  -> 각 Data를 index로 구분하기 때문에 중복된 Data 저장 가능!! 
 */

public class ListService {
	
	public void test1() {
		// ArrayList 객체 생성
		// -> List 인터페이스를 상속 받은 자식 클래스로 
		// 가장 많이 사용하는 List 이다
		
		
		// List : 부모 인터페이스 = 객체 생성은 불가하지만 부모 참조변수로 사용 가능
		// ArrayList : 자식 객체 = List를 가져와서 업캐스팅 한다! 
		
//		List list = new ArrayList(); // 기본 10칸 
		List list = new ArrayList(3); // 3칸짜리 생성
		
		// E (Element) : 요소를 뜻하는 상징적인 글자 (자료형은 아님)
		//				 특정 자료형은 아니고 Object 타입임
		// boolean add(E e)
		// - List에 주어진 객체(e)를 맨 끝에 추가한다 (최상위 부모객체이기 때문에 뭐든 받아서 추가 가능!)
		
		list.add("아무거나");
		list.add(new Object());
		list.add(new int[4]); // 3index 
		
		// 4index -> 크기초과 발생했을 때 오류가 나는지 안 나는지 테스트 
		list.add(123); // int 기본 자료형은 대입(추가) 불가능
					   // Colletion은 원래 객체만 저장이 가능한데, -> Integer Wrapper class로 자동 변환되어 저장됨
		
		
		System.out.println(list); // 객체에 들어있는 필드값을 문자열로 받는다는 뜻 
		// toString 생략 가능하다 (print 문 특징)
		
		
		// 2. void add (int index, E e) // 반환값이 없는 add
		// - index 번째에 e를 추가한다 -> 중간 삽입 (insert한다)
		list.add(2, "중간");
		
		System.out.println(list); 
		
		
		// 3. int size()
		// - 저장된 Data(객체)의 수를 반환
		
		System.out.println("현재 저장된 Data 개수 : " + list.size()); // 5
		
		
		// (E == Object) 라고 이해하는 상황
		// 4. E get(int index) 
		// - index 번째 요소를 반환
		System.out.println(list.get(0));
		
		System.out.println("-----------------");
		
		// List + 일반 for문
		for(int i = 0 ; i < list.size() ; i++) { // null 이 있어도 신경 안 쓰고 실제 데이타를 가져오기 때문에 null값을 신경 안 써도 됨!
			System.out.printf("%d 번째 indext 요소 : %s\n", i, list.get(i)); // 프린트구문으로 자료형을 넣으면 자동으로 toString을 가져옴! %s로 들어가도 된다!
		}
		
		System.out.println("-----------------");
		
		// List + 향상된 for문
		for(Object obj : list) {
			
			String str = null;
			// obj가 참조하는 객체가 String 타입이라면
			if(obj instanceof String) str = "[String] ";
			else if(obj instanceof int[]) str = "[int[]] ";
			else if(obj instanceof Integer) str = "[Integer] ";
			else str= "[Object] ";
			System.out.println(str + obj);
		}
			
	}
	
	
	/**
	 * List + 제네릭(타입제한) 확인 + List 메서드 몇 가지 더 
	 */
	public void test2() {
		/*
		 * 제네릭 Generics, <제한하고 싶은 타입>
		 * 
		 * 1) 컬렉션의 타입을 제한하여
		 * 한 가지 자료형만 저장할 수 있게 하는 기능
		 * 
		 * 2) 클래스나 메서드가 다룰 타입을 지정하는 기능
		 * 
		 * */
		
		// String 타입으로 제한된 List 생성
		List<String> menuList = new ArrayList<String>();
		
		// add() 확인
//		menuList.add(123); // String으로 제한되어서 다른 자료형 추가 불가능
		
		menuList.add("보쌈");
		menuList.add("초밥");
		menuList.add("돈까스");
		menuList.add("덮밥");
		menuList.add("돌솥밥");
		
		// 향상된 for문
		for(String menu : menuList) {
			System.out.println(menu);
		}
		
		
		// 5. E set (int index, E e)
		// - 지정된 index번째 요소를 e(두 번째 매개변수)로 수정 후
		// -> 메서드 반환 값으로 이전 객체가 반환 된다
		
		System.out.println("------------------");
		System.out.println(menuList);
		
		String before =  menuList.set(2, "버섯전골"); // 기존 인덱스 2번 데이터는 before에 저장됨
		
		System.out.println(before + "가 " + menuList.get(2) + "으로 변경 됨");
		System.out.println(menuList);
		
		
		// 6. boolean contains(E e)
		// - List 내부에 e와 같은 객체가 존재하면 true / 아니면 false (확인 기능)
		
		System.out.println("보쌈 : " + menuList.contains("보쌈") );
		System.out.println("막국수 : " + menuList.contains("막국수") );
		
		
		// 7. int indexOf(E e) *** 많이 씀!!!
		// - List 내부에 e와 같은 객체가 존재하면 해당 index를 반환
		// 존재하지 않으면 -1 을 반환한다! 
		System.out.println("초밥 : " + menuList.indexOf("초밥"));
		System.out.println("삼겹살 : " + menuList.indexOf("삼겹살")); // -1은 없다는 뜻
		
		
		// 8. E remove(int index) 
		// - List에서 지정된 index 번째 요소를 제거
		//   -> 중간이 제거되면 뒤쪽 요소를 앞으로 이동 
		// - 제거된 요소는 메서드 결과로 반환됨
		
		System.out.println(menuList.remove(3) + "제거");
		System.out.println(menuList);
	
	}
	
	/**
	 * 왜 컬렉션 참조 변수를 부모 타입으로 작성 하는가?
	 * 
	 * 다형성 업캐스팅의 특징을 이용,
	 * 프로그래밍 과정에서 미처 생각지 못한 비효율적인 요소를
	 * 쉽게 개선하기 위해서 
	 * 
	 * 	예 ) ArrayList로 만들었는데 중간에 추가 삭제가 빈번히 일어나는 경우
	 * 		-> LinkedList가 훨씬 효율적이다!!
	 * 
	 * 		LinkedList로 만들었는데 검색이 빈번하게 일어나는 경우
	 * 		-> ArrayList 가 훨씬 효율적!!
	 */
	public void test3() {
//		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list = new LinkedList<Integer>();
		Random random = new Random();
		
//		System.currentTimeMillis()
		// -> 1970년 1월 1일 09:00.00 0초 기준으로
		// 현재 시간까지 지난 시간을 ms로 반환(long타입)
//		System.out.println(System.currentTimeMillis());
//		System.out.println(System.nanoTime());
		long start = System.currentTimeMillis(); // for문 전에 시간 저장
		
		
		for(int i = 0 ; i < 500000 ; i++) { // 100만바퀴
			list.add(random.nextInt(100000)); // 0 ~ 99999 사이 난수
//			System.out.println(list.get(i));
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("생성 완료 - 걸린 시간 : "  + (end-start) + "ms");
//		System.out.println(System.currentTimeMillis());
		
		// 추가 시간 확인
		start = System.nanoTime();
		list.add(500000, 123456789); // 중간에 데이터 삽입 // 데이터가 백만 1개가 됨
		end = System.nanoTime();
		System.out.println("추가 시간 : " + (end-start) + "nm");
		
		// 검색 시간 확인
		start = System.currentTimeMillis();
		System.out.println(list.indexOf(123456789));
		end = System.currentTimeMillis();
		System.out.println("검색 시간 : " + (end-start) + "ms");
	}
	
	// ArrayList 는 생성이 빠르고 검색도 빠름!
	// LinkedList는 추가 생성 삭제가 빨라진다!!
}
