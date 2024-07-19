package field.pkg3;

public class StaticTestRun {
	public static void main(String[] args) {
		
		// Korean 객체 2개 생성
		
		Korean k1 = new Korean();
		
		k1.setName("김철수");
		k1.setId("990424-1345678");
		
		Korean k2 = new Korean();
		
		k2.setName("이영희");
		k2.setId("990312-2345678");
		
		// ---------------------------------------
		
		System.out.println("생성된 객체의 필드 값을 확인");
		System.out.printf("k1 : %d / %s / %s\n", k1.nationalCode, k1.getName(), k1.getId());
		System.out.printf("k2 : %d / %s / %s\n", k2.nationalCode, k2.getName(), k2.getId());
		
		// ---------------------------------------
		
		System.out.println("\n\n[static 변수 값 변경 확인]");
		
		// static 은 값을 공유하고 있기 때문에
		// 한 번만 바꾸면 공유하는 모든 객체의 값이 변경 된다!!!
		k1.nationalCode = 10;
//		k2.nationalCode = 10; // 불필요한 코드가 됐다
		
		System.out.printf("k1 : %d / %s / %s\n", k1.nationalCode, k1.getName(), k1.getId());
		System.out.printf("k2 : %d / %s / %s\n", k2.nationalCode, k2.getName(), k2.getId());
		
		
		// ----------------------------------------
		
		// 왜 k1.nationalCode / k2.nationalCode에 노란 줄이 떠 있을까?
		// 정적 방식으로 접근하는 게 좋아, 라는 오류 (노란 줄, 경고)
		// Static 영역에 생성된 이름으로 호출하는 게 좋다! 라고 권고 
		
		System.out.println("\n\n");
		System.out.println("[Static에 선언된 이름 사용하기]");
		
		System.out.println("Korean.nationalCode : " + Korean.nationalCode);
		
		System.out.println("--값 변경--");
		Korean.nationalCode = 1;
		
		System.out.println("Korean.nationalCode : " + Korean.nationalCode); // 클래스명.필드명 작성이 좋다
		System.out.println(k1.nationalCode);
		System.out.println(k2.nationalCode);
		
		// final 변수명 == 상수 
		// static 변수 == 공유하는 변수
		// static final, final static == 공유 가능한 상수
		// --> 무슨 용도? : 전체적으로 사용되면서 변하면 안 되는 값 
		// 예 ) Math.PI (원주율등) > 대문자로 적혀있으면 final, 앞에 클래스 붙어있으면 static
		// Integer.Max_VALUE (int 최대값)
		// Integer.MIN_VALUE (int 최소값)
		
		System.out.println(Math.PI);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
	}
}
