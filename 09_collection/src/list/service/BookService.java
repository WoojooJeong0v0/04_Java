package list.service;

import java.util.ArrayList;
import java.util.List;

import list.dto.BookDTO;

// Service : 기능(비즈니스 로직) 제공용 클래스
public class BookService {

	// BookDTO 객체 참조 변수만을 저장하는 ArrayList 객체 생성!
	// <BookDTO> == 제네릭 -> 타입 제한 역할
	private List<BookDTO> bookList = new ArrayList<BookDTO>();

	public BookService() { // 기본 생성자 - 이 객체가 만들어질 때 실행될 것
		bookList.add(new BookDTO("자바 프로그래밍 입문", "박은종", 25000)); // 비어있는 마지막 칸에 자동으로 추가가 된다!
		bookList.add(new BookDTO("선재 업고 튀어 대본집 세트", "이시은", 45000));
		bookList.add(new BookDTO("The money book", "토스", 19800));
		bookList.add(new BookDTO("자바의 정석", "남궁 성", 45000));
		bookList.add(new BookDTO("눈물의 여왕 대본집 세트", "박지은", 65000));
		bookList.add(new BookDTO("삼국지 전권 세트", "이문열", 165000));
	}
	
	
	/**
	 * bookList를 반환하는 서비스 메서드
	 * @return bookList
	 */
	public List<BookDTO> selectAll() {
		return bookList;
	}


	/**
	 * bookList 에 전달받은 index가 존재하면
	 * 해당 index번째 요소(BookDTO) 반환
	 * 없으면 null 반환
	 * @param index
	 * @return BookDTO 또는 null
	 */
	public BookDTO selectIndex(int index) {
		
		// index 범위가 bookList 인덱스 범위 밖인 경우 
		if(index < 0 || index >= bookList.size()) return null;
		
		// 정상범위인 경우
		return bookList.get(index);
		
	}
	
	
	/**
	 * bookList 요소의 제목 중 
	 * 전달 받은 title이 포함된 책 모두 반환
	 * 
	 * @param title
	 * @return searchList (찾은 책이 저장된 리스트)
	 */
	public List<BookDTO> selectTitle(String title) {
		
		// 검색 결과를 저장할 List생성, for 바깥쪽에 써야 함!
		List<BookDTO> searchList = new ArrayList<BookDTO>();
		
		// bookList 모든 요소를 순차접근
		for(BookDTO book : bookList) {
			// 책 제목에 title이 포함되어 있을 경우!
			if(book.getTitle().contains(title)) { 
				searchList.add(book); // 찾은 책을 searchList에 추가한다
			}
		}
		return searchList; // 검색 결과를 반환한다
	}


	public List<BookDTO> selectWriter(String writer) {
		List<BookDTO> searchList = new ArrayList<BookDTO>();
		
		for(BookDTO book : bookList) {
			if (book.getWriter().contains(writer)) {
				searchList.add(book);
			}
		}
		return searchList;
	}


	/**
	 * 가격 범위 내 모든 책 찾아서 반환
	 * @param min
	 * @param max
	 * @return searchList
	 */
	public List<BookDTO> selectPrice(int min, int max) {
		
		List<BookDTO> searchList = new ArrayList<BookDTO>();
		
		for(BookDTO book : bookList) {
			int price = book.getPrice();
			// 책의 가격이 최소~최대 사이 범위에 있을 때
			if(price >= min && price <= max) {
				searchList.add(book);
			}
		}
		
		return searchList;
	}

	
	/**
	 * 전달 받은 newBook을 bookList에 추가
	 * @param newBook
	 * @return true (List의 add() 구문은 무조건 true, 성공하기 때문에)
	 */
	// 책 한 권을 그대로 받아오게 하고 싶어서 
	public boolean addBook(BookDTO newBook) {
		return bookList.add(newBook);
	}
	
	
	/**
	 * 전달 받은 index 요소 제거하기
	 * @param index
	 * @return null인 경우가 있다 : index 범위가 잘못됨 / 제목 : 정상범위 index
	 */
	public String removeBook(int index) {
		// 1) index가 bookList 범위 내 인덱스가 맞는지 확인
		if(index < 0 || index >= bookList.size()) { // 정상범위 밖
			return null;
		}
		
		// 2) 정상범위인 경우 index번째 요소를 제거한 후 
		// "제거된 책 제목"을 반환
		
		// bookList.remove(index) -> 제거된 책(BookDTO) 반환 (객체)
		// bookList.remove(index).getTitle(); -> 제거된 객체의 제목만 얻어오기
		// 메서드 부른 결과에서 .을 이용해 다시 메서드를 호출함 
		// * method chainning : 메서드의 결과 (반환값)을 이용해 또 다른 메서드를 호출
		return bookList.remove(index).getTitle();
	}

}
