package set.dto;

import java.util.Objects;

public class Person {

	// 필드
	
	private String name;
	private int age;
	private char gender;
	
	// 기본 생성자
	public Person() {}
	
	
	// 매개변수 생성자
	public Person(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	
	// getter/ setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}


	// toString() 오버라이딩
	// 모든 필드값을 String으로 만들어서 사용해!
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
	/*  boolean Object.equals (Object other) ==> 동등 비교
	 * - 현재 객체와 매개 변수로 전달 받은 다른 객체의
	 * 필드 값이 일치하는지 확인하는 용도!!
	 * 
	 * 오버라이딩해서 사용하는 Object 제공 메서드
	 * */
	@Override
	public boolean equals(Object other) {
		
		// null 이 전달된 경우
		if(other == null) return false; // 비교값이 없을 경우
		
		// person 타입의 객체가 아닌 경우
		if(!(other instanceof Person)) return false;
		
		// other 다운 캐스팅
		Person o = (Person)other;
		
		// 이름이 일치하지 않으면
		if(!this.name.equals(o.name)) return false; // 참조형만 equals
		
		// 나이가 같지 않으면
		if(this.age != (o.age)) return false;
			// 비교 연산자 (기본자료형만 비교)
		
		// 성별이 같지 않으면
		if(this.gender != (o.gender)) return false;
		
		return true; // 위에 if문 실행 안 되면 같은 값을 지닌 객체다
	}
	
	
	// 자바는 동등, 동일 비교를 같이 해야 한다!
	/* 
	 * int hashCode() ==> 식별코드, 동일 비교
	 * - 객체별 식별 코드(객체를 구분하는 정수 값)를 반환하는 메서드
	 * 
	 * - 식별코드가 겹치지 않게 만들기 위해 hash함수 이용함!!
	 * 
	 * - hash함수 : 암호화, 값을 넣으면 동일한 크기의 값이 반환되는 함수
	 * 
	 *  예 ) sha-256 암호화 방식
	 *  	-> 문자열을 전달하면 256바이트 길이 문자열로 변환
	 *  	== 암호화 
	 */
	
	@Override
	public int hashCode() {
		// Objects : Object 관련 유용한 기능 제공 클래스
		
		// 필드에 저장된 값을 이용해 hashCode를 생성하기 때문에
		// 필드 값이 모두 같으면 동일한 hashCode가 반환된다
		return Objects.hash(name, age, gender);
	}
	
	
}
