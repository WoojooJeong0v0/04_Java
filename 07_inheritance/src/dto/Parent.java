package dto;

/**
 * Object 클래스
 *  - 모든 클래스(객체)의 최상위 부모
 *  - 모든 클래스(객체)가 공통적으로 가져야 하는 기능이 모여있음
 *  
 *  - 클래스 선언부에 아무런 상속구문(extends)이 작성되어 있지 않으면
 * 	  컴파일러가 extends Object 구문을 추가해준다!!
 */



/**
 * 부모 역할 클래스
 */

public class Parent extends Object {

	/*부모 필드*/
	// protected : 접근 제한자 :
	// - 같은 패키지 : 객체 생성 후 사용해야 함
	//	예 ) 같은 패키지 클래스에서
	// 		 Parent p = new Parent();	 p.lastName;
	
	// - 상속 관계 자식 클래스 : 자식 클래스에서 직접 사용
	//  예 ) 자식 클래스에서 lastName 작성
	
	protected String lastName = "홍"; // 명시적 초기화
	
	private String address = "서울시 중구 남대문로 120";
	
	private int money = 100_000_000; // _ : 자릿수 구분(해석 안됨)
	
	private String car = "그랜져";
	
	
	// 기본 생성자 : 반환형 없이 클래스 명과 동일하게
	public Parent()	{
		System.out.println("부모 - 기본 생성자로 객체 생성");
	}


	// 매개변수 생성자 : 생성되는 객체를 매개변수 값으로 초기화를 시키기 위함
	public Parent(String address, int money, String car) {
//		super();
//		this.lastName = lastName;
		this.address = address;
		this.money = money;
		this.car = car;
		
		System.out.println("부모 - 매개변수 생성자로 객체 생성");
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public String getCar() {
		return car;
	}


	public void setCar(String car) {
		this.car = car;
	}
	
	
	/**
	 * 현재 객체의 필드 값을 하나의 문자열로 반환하는 메서드
	 * @return
	 */
	public String inform()	{
		return String.format("%s / %s / %d / %s", lastName, address, money, car);
	}
	
	
	/**
	 * 자기 소개 기능
	 */
	public void introduce() {
		System.out.println("저는 Parent입니다");
	}
	
	
	/**
	 * Object 클래스에서 상속 받은 메서드 중
	 * toString() 메서드를 오버라이딩 하기
	 * 
	 * - Object.toString() 역할
	 *  -> 물려받은 자식이 오버라이딩하여 
	 *  객체가 가지고 있는 필드 값을
	 *  하나의 문자열로 만든다! 이렇게 약속되어 있음!
	 *  
	 *  -> print() 관련 구문에서 () 안에 참조변수명만 작성해도
	 *  자동으로 toString()이 호출 된다!
	 */
	
	@Override // 오버라이딩 됐는지 컴파일러에게 검사 시킴
	public String toString()	{ // 가지고 있는 필드값을 하나의 문자 로 표현
		return String.format("[Parent] %s / %s / %d / %s", lastName, address, money, car);
	}
	
	
	/**
	 * final 메서드
	 * 
	 * final 변수 : 상수 (마지막으로 값을 대입할 수 있는, 변하지 않는 변수)
	 * final 메서드 : 오버라이딩 불가 
	 *  -> 부모의 메서드를 재정의하면 문제가 생기니까, 
	 *  더이상 오버라이딩을 못하게 하겠다!
	 *  (마지막으로 정의된 메서드)
	 *  
	 * - public final 반환형 메서드명(){}
	 */
	
	public final void onlyParent() {
		System.out.println("final 메서드 입니다");
	}
	
}
