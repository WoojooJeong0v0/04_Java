package list.run;
import list.view.BookView;

public class BookRun {
	public static void main(String[] args) {
		
		// 변수 : 메모리에 값을 저장하는 공간
		// 	-> 변수에 저장하면 계속 호출 가능(재사용 가능)
		new BookView().mainMenu(); // 객체 호출하면 1회성으로 사라짐, 변수에 저장하지 않기 때문에
		
		// 포함된 문자열 확인
		// String.contains("검색어") : 포함이면 true / 아니면 false
//		System.out.println("선재 업고 튀어".contains("선재"));
//		System.out.println("선재 업고 튀어".contains("카리나"));
//		System.out.println("선재 업고 튀어".contains("업고"));
	}
}
