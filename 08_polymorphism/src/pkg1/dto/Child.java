package pkg1.dto;

public class Child extends Parent {

	private String car;
	
	public Child() {
		super(); // 안 쓰면 컴파일러가 추가해줌
	}

	// 자식 객체 생성 시 자식 + 부모 필드 한 번에 초기화 
	// alt + shift + o 눌러서 위쪽 드롭다운 메뉴에서 부모 매개변수 생성자 선택
	public Child(String lastName, int money, String car) {
		super(lastName, money);
		this.car = car;
	}
	
	public String getCar() {
		return car;
	}
	
	public void setCar(String car) {
		this.car = car;
	}
	
	
}
