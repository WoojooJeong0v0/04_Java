package field.pkg1;

/*
 * 필드 (Field)
 * 
 * - 클래스 바로 아래에 작성하는 변수
 * == 객체의 속성을 의미 함 (data 값을 저장하는 공간)
 * 
 * - 필드( == 멤버 변수) 구성
 * 1) 인스턴스 변수
 * 2) 클래스 변수( == static 변수)
 * 
 * [[ 필드 접근 제한자]]
 * 
 * 1) [+] public : 같은 프로젝트 내에서 어디서든 접근 가능 
 * 	public field : 
 * 	같은 프로젝트 내 어디서든 해당 클래스를 이용해 만들어진 객체의
 *  public field에 직접 접근 가능하다!!
 *
 * 2) [#] protected : 같은 패키지 또는 상속관계에서만 접근 가능하다!
 *  - protected (보호된) 
 *  기본적으로 같은 패키지에서만 직접 접근이 가능하지만
 *  다른 패키지에 존재하는 클래스 중
 *  상속 관계인 클래스에서는 직접 접근 가능
 * 
 * 3) [~] (default) : 같은 패키지내에서만 접근 가능
 *  - (default) field는 같은 패키지 내에서 해당 클래스를 이용해 만들어진 객체
 *   (default) 필드를 직접 접근할 수 있다!!
 * 
 * 4) [-] private : 같은 클래스 (해당 객체만!!)만 접근 가능/ 만들어진 객체가 개인적으로 가지고 있음, 개인정보같은 것
 *  private field :
 * 	해당 클래스를 이용해 만들어진 객채 내부에서만 사용 가능하다!!
 *  (무슨 일이 있어도 외부에서 직접 접근이 불가능한 필드, 간접 접근만 가능)
 * 
 * */


public class FieldTest1 {
	
	// [필드 작성법]
	// [접근 제한자][예약어] 자료형 변수명 [= 초기값];
	
	public int publicValue = 100;
	
	protected int protectedValue = 200;
	
	int defaultValue = 300;
	
	private int privateValue = 400;
	
	
	// 같은 클래스(해당 객체) 내부에서 필드접근
	// 모든 접근 제한자가 가능함!!
	public void method() {
		System.out.println(publicValue);
		System.out.println(protectedValue);
		System.out.println(defaultValue);
		System.out.println(privateValue);
		
	}
}
