package set.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import set.dto.Person;

public class SetService {
	/* Set(집합, 주머니)
	 * - 기본적으로 순서를 유지하지 않음
	 *   (index 없음! -> get() 메서드가 없음)
	 *   index 활용 메서드도 없음!!
	 *   
	 * - 중복 데이터 저장 X (같은 객체가 들어오면 덮어쓰기)
	 * 
	 * 
	 * Set 인터페이스의 자식 클래스
	 * 
	 * 1. HashSet (대표) : 처리 속도가 빠른 Set
	 * 
	 * 2. LinkedHashSet : 순서를 유지하는 Set
	 * 
	 * 3. TreeSet : 자동 정렬되는 Set
	 */
	
	/**
	 * Set / HashSet 사용법
	 */
	public void test1() {
		// HashSet 객체 생성
		// 부모타입
		Set<String> set = new HashSet<String>();
		// 1. boolean add(E e) : 요소 추가
		set.add("네이버");
		set.add("카카오");
		set.add("라인");
		set.add("쿠팡");
		set.add("배달의민족");
		set.add("토스");
		set.add("직방");
		set.add("야놀자");
		
		System.out.println(set); // set.toString() 가지고 있는 필드값을 문자열로 반환
		// -> HashSet 작성한 순서 유지가 안 됨!!
		
		// 중복 데이터 추가 후 결과 확인
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		
		System.out.println(set); // 중복은 허용 안 한다!
		
		// null (참조하는 객체가 없음) 도 중복 안 되는지 확인
		set.add(null);
		set.add(null);
		set.add(null);
		System.out.println(set); // null 도 중복 안 된다!
		
		// 2. int size () : Set에 저장된 객체(참조변수)의 수 (크기) 반환
		System.out.println("Set.size() : " + set.size()); // null도 카운트 포함 
		
		// 3. boolean remove(E e) : Set에 저장된 객체 중 같은 객체를 찾아 제거
		// 제거 성공 : true / 특정 개체가 없으면 : false
		System.out.println("쿠팡 제거 : " + set.remove("쿠팡"));
		System.out.println("삼성 제거 : " + set.remove("삼성"));
		System.out.println(set);
			
		// 4. boolean contains(E e)
		// 같은 요소가 있으면 true, 없으면 false
		System.out.println("네이버 있음? " + set.contains("네이버"));
		System.out.println("KT 있음? " + set.contains("KT"));
		
		// 5. boolean isEmpty()
		// 비어있으면 true, 아니면 false
		
		// 6. void clear() 반환되는 게 없어서 void
		// 저장된 객체를 모두 제거 
		
		System.out.println("비어있음? : " + set.isEmpty());
		set.clear();
		System.out.println("모두 제거 완료");
		System.out.println("비어있음? : " + set.isEmpty());
		
		// Set
		// - index가 없음
		// -> index 활용 메서드가 없다 + 순서 유지가 안 된다
		// -> 원하는 요소 하나만 꺼낼 수 없다!
		// -> 순서 유지가 안 되다 보니 중복 허용 안 한다!
 	}
	
	/**
	 * Set에 저장된 객체를 꺼내는 방법
	 * 1. Iterator (반복자) 이용
	 * 2. List로 변환
	 * 3. 향상된 for문 이용
	 */
	public void test2() {
		Set<String> snackSet = new HashSet<String>();
		
		snackSet.add("포카칩");
		snackSet.add("새우깡");
		snackSet.add("홈런볼");
		snackSet.add("꼬깔콘");
		snackSet.add("프링글스");
		snackSet.add("빈츠");
		snackSet.add("쿠쿠다스");
		
		/* Iterator 반복자 이용*/
		// - collection에 저장된 요소를 하나씩 순차접근하는 기능을 제공하는 인터페이스
		
		// hasNext() : 다음 순차 접근할 요소가 있으면 true
		// next() : 다음 요소가 있으면 꺼내와서 반환해라! -> 화살표(커서) 를 한 칸 움직임
		
		Iterator<String> it = snackSet.iterator(); // HashSet에 오버라이딩 되어있음!
		
		System.out.println("[Iterator]");
		while(it.hasNext()) {
			String snack = it.next();
			System.out.println(snack);
		}
		
		/* List 이용 */
		// List 객체 생성자 매개변수로 Set을 추가
		List<String> snackList = new ArrayList<String>(snackSet);
		System.out.println("----------------------------------");
		System.out.println("[List]");
		for (int i = 0 ; i < snackList.size() ; i++) {
			System.out.println(snackList.get(i));
		}
		
		
		/* 향상된 for문 이용 */
		System.out.println("----------------------------------");
		System.out.println("[향상된 for문]");
		for(String snack:snackSet) {
			System.out.println(snack);
		}
			
	}
	
	/**
	 * Hash가 포함된 컬렉션을 이용하는 방법
	 * 예 ) HashSet, linkedHashSet, HashMap, HashTable 등
	 * 
	 * 1. Object.equals() 오버라이딩 하기
	 * 2. Object.hashCode() 오버라이딩 하기 
	 * 
	 * *** 1, 2 둘다 수행해야만 함!!
	 * - > 자바는 동일한 객체임을 비교할 때
	 *	동등(equals) 동일(hashCode)이 모두 true여야지만 동일한 객체로 인식한다!
	 */
	public void test3() {
		Person p1 = new Person("홍길동", 25, '남');
		Person p2 = new Person("홍길순", 22, '여');
		Person p3 = new Person("짱구", 5, '남');
		
		// 중복된 필드를 가진 Person 객체 2개 생성
		Person p4 = new Person("유리", 5, '여');
		Person p5 = new Person("유리", 5, '여'); // 똑같은 필드를 가짐
		
		// HashSet에 p1~p5추가
		Set<Person> set = new HashSet<Person>();
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		set.add(p5);
		
		//향상된 for문으로 하나씩 출력
		// key point!!
		// -> p4, p5가 중복된 데이터로 인식되어 한 번만 출력되는지 확인할 것
		
		// 확인 1 (equals, hashCode 오버라이딩X)
		// 유리가 중복되어서 출력됨
		
		for(Person s :set) {
			System.out.println(s);
		}
		
		System.out.println("--------------------------");
		// equals 오버라이딩 확인 == 동등비교 (동명이인)
		System.out.println(p4.equals(p5)); // t
		System.out.println(p4.equals(p1)); // f
		
		// hashCode 오버라이딩 확인
		System.out.println("해시코드 확인하기");
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());
		System.out.println(p4.hashCode());
		System.out.println(p5.hashCode());
		
	}
	
	
	/**
	 * TreeSet : 이진 트리 구조를 이용해 객체를 저장하는 Set
	 * 				오름차순 정렬 + 중복 제거
	 * 	** 전제조건 (선행)
	 * 저장되는 객체가 comparable 인터페이스를 상속해 구현해야 함!!
	 * 
	 */
	public void test4() {
		
		// 난수 생성
		// 로또 번호 생성기
		
		Random random = new Random();
		
		// set에 저장하려면 integer로!!
		Set<Integer> lotto = new TreeSet<Integer>();
		while(lotto.size() < 6) { // 몇 번이나 돌릴지 알 수 없으니 while 문으로
		lotto.add(random.nextInt(45) + 1); // 1 ~ 45 난수를 TreeSet에 추가
		}
		System.out.println(lotto);
		
		
	}
	
	
	/**
	 * 로또 번호 생성기
	 * - 금액을 천원 단위로 입력 받아
	 * 천원 당 1회씩 번호를 생성해서 List에 저장한 후 
	 * 생성 종료되는 시점에 한 번에 출력
	 * 단, 5회 출력시 마다 구분 선 추가하기
	 * 
	 * <pre>
	 * 금액 입력 : 3000
	 * 1 회 : [1, 2, 3, 4, 5, 6]
	 * 2 회 : [12, 13, 14, 15, 16]
	 * 3 회 : [22, 16, 28, 31, 1] 등
	 * </pre>
	 */
	public void lottoNumberGenerator() {
		Scanner sc = new Scanner(System.in);
		
		// 생성된 로또 번호 저장할 List 생성
		List<Set<Integer>> lottoList = new ArrayList<Set<Integer>>();
		
		System.out.print("금액 입력 (천원단위) : ");
		int price = sc.nextInt();
		
		Random random = new Random();
		
		// 입력된 금액 천원 당 1회 반복
		for(int i = 0 ; i < price/1000 ; i++) { // 1000을 1로 변경
			// 1회치에 해당되는 로또 번호 생성
			Set<Integer> lotto = new TreeSet<Integer>();
			while(lotto.size() < 6) {
				lotto.add(random.nextInt(45) + 1);
			}
			// lottoList에 추가
			lottoList.add(lotto);
		}
		// 문제 제시했던 형태로 출력
		for(int i = 0 ; i < lottoList.size() ; i++) {
			
			// 6회, 11회, 16회... 등 출력 전에
			if(i % 5 == 0) {
				System.out.println("-------------------------");
			}
			
			System.out.printf("%d회 : %s \n", i+1, lottoList.get(i)); // lottoList.get(i).toString()
			
//			// 5/10/15/... 출력한 후에
//			if((i+1) % 5 == 0) {
//				System.out.println("-----------------------------");
//			}
		}
	}
	
	
}
