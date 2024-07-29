package map.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapService {
	/* Map : 특정 키워드(Key)를 입력하면
	 *       해당되는 상세한 값(Value)를 얻을 수 있는 컬렉션 객체
	 * 
	 * - K:V 형식으로 구성
	 * 
	 * - K:V 한 쌍을 "Entry" 라고 부름
	 * 
	 * - Key : 키워드 역할(== 변수명)
	 * 1) 중복 X
	 *  -> 중복되는 Key 입력 시 Value를 덮어씌움
	 *  -> Key 역할의 객체는 hashCode(), equals() 오버라이딩 필수!
	 *  
	 * 2) 순서 유지 X (단, LinkedHashMap 제외) // linked 가 들어가면 순서 유지가 되는 특별한 친구가 있다
	 * 
	 * * Key만 묶어서 보면 Set과 같은 특징을 지니고 있음!
	 *  -> Map.keySet() / Map.EntrySet() 제공
	 * 
	 * 
	 * Value : 키워드에 해당하는 상세한 값
	 * 
	 * - Key로 인해서 모든 Value가 구분됨
	 *  -> Map.get(Key) / Map.remove(Key) 형태로 사용
	 * 
	 */
	
	public void test1() {
		
		// HashMap : 대표적 Map상속객체
		// Hash가 들어가면 식별자와 정렬로 속도가 빠름!
		// 대신 key 역할의 객체가 equals(), hashCode() 오버라이딩 필수!!
		
		//   K        V
		Map<String, String> map = new HashMap<String, String>();
		
		// 1. V put (K k, V v) : 맵에 키 밸류(엔트리) 한 쌍을 추가한다
		// 추가 성공 시 Value가 반환 됨!
		// 단, Value 가 조금 이상한데?
		// 중복되는 key가 없으면 null
		// 중복되는 key가 있으면 이전 value 반환!
		
		System.out.println(map.put("아침", "참치김밥"));
		System.out.println(map.put("점심", "돈까스"));
		
		System.out.println(map.put("저녁", "삼겹살"));
		System.out.println(map.put("저녁", "소고기")); // key 중복
		// 중복될 경우 이전 value를 내보내고 새 value 로 대체한다
		
		System.out.println(map.toString()); // map 전체 확인
		
		System.out.println("--------------------");
		
		// 2. V get(K k) : 해당 key에 대응되는 Value 반환
		// 단, 일치하는 K가 없으면 null 반환
		
		System.out.println(map.get("아침"));
		System.out.println(map.get("점심"));
		System.out.println(map.get("저녁"));
		System.out.println(map.get("야식"));
		
		// 3. int size() : Map에 저장된 K:V 쌍의 개수를 반환
		System.out.println("size() : " + map.size());
		
		System.out.println("--------------------");
		// 4. V remove(K k) : Map에서 Key가 일치하는 쌍을 제거
		// 일치하는 Key가 존재하면 Value 가 반환
		// 일치하는 Key가 존재하지 않으면 null 반환
		System.out.println(map.remove("아침") + " 제거");
		System.out.println(map.remove("점심") + " 제거");
		System.out.println(map.remove("야식") + " 제거");
		System.out.println(map); // 남은 요소 확인
	}
	
	
	/**
	 * Map에 저장된 모든 요소 순차 접근하기
	 */
	public void test2() {
		
		// K는 String -> 문자열만 작성
		// V는 Object -> 오브젝트 (모든 자식들의 최상위 부모)
		// 모든 자식 객체를 활용하기 위해 업캐스팅 : 모든 자료형이 가능!!
		Map<String, Object> student = new HashMap<String, Object>();
		
		student.put("name", "홍길동"); // String
		student.put("grade", 3); // Integer // Wrapper 자동 boxing
		student.put("gender", '남'); // Charactor
		student.put("avg", 80.4); // Double
		// 유사 DTO 모습,  Map을 DTO처럼 사용하는데 기본 기능만 있음
		
		/* 1) Map.keySet() 이용 */ // 다른 언어들과 사용법이 비슷함
		// key만 모아둔 집합 Set 반환
		// 모아둔 key 집합에서 key를 하나씩 꺼내서
		// Map.get(key)를 통해 value를 하나씩 꺼냄!!
		
		Set<String> keys = student.keySet();
		System.out.println(keys);
		
		for(String key : keys) {
			System.out.printf("student[%s] : %s \n", key, student.get(key));
		}
		
		System.out.println("---------------------------------------------");
		
		/* 2) Map.entrySet() 이용 */
		// K : V 쌍 형태의 객체를 모아둔 집합(Set) 반환
		Set<Map.Entry<String, Object>> set = student.entrySet();
		
		System.out.println(set);
		
		// Entry.getKey() : key 반환
		// Entry.getValue() : value 반환
		
		// 향상된 for문
		for(Entry<String, Object> entry :set) {
			System.out.printf("student[%s] : %s \n", entry.getKey(), entry.getValue());
		}
	}
}
