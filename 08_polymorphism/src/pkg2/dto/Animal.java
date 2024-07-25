package pkg2.dto;


/**
 * 추상 클래스
 * 
 * 1) abstract 메서드를 가지고 있는 클래스
 * 
 * 2) 객체로 만들면 안 되는 클래스
 * 
 * 추상 클래스는
 * 일반 필드/메서드 + 추상메서드가 합쳐진 모습이다!
 * 
 * -> 미완성 설계도이지만 부분적으로는 완성되어 있다
 * -> 상속 받은 자식 객체 생성 시 내부에 일반 필드/메서드가 
 *    정상적으로 구현이 되어야 하기 때문에, 
 *    추상 클래스도 생성자가 필요하다!!!
 */


public abstract class Animal { // 추상클래스

	// 공통적인 속성(필드)
	private int eyes; // 눈이 몇 개있나 (개수 저장)
	
	// 기본 생성자
	public Animal() {  super();	}
	
	// 매개변수 생성자
	public Animal(int eyes) {
		this.eyes = eyes;
	}
	
	public int getEyes() {
		return eyes;
	}
	
	public void setEyes(int eyes) {
		this.eyes = eyes;
	}
	
	@Override
	public String toString() {
		return eyes + ""; // int + String == String
	}
	
	// 공통된 기능 (메서드)
	// abstract : 추상적인
	/* 추상 메서드 
	 * - 공통된 기능의 이름을 갖지만
	 * 정의되는 내용들이 다르기 때문에
	 * 정의를 할 수 없는 메서드
	 * 
	 * - 예약어 abstract 작성해야 함!! 
	 * 
	 * - 중괄호를 지우고 세미콜론 작성
	 * 
	 * - 상속 받은 자식 클래스에서 해당 메서드를 정의하도록 강제
	 *  --> 오버라이딩 강제화 */
	public abstract void move();
	public abstract void eat();
	public abstract void sleep();
	
	
}
