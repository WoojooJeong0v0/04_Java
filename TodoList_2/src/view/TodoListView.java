package view;

import java.io.BufferedOutputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListView {
	
	// 필드
	private TodoListService service = null;
	private BufferedReader br = null;
	
	// 기본 생성자
	public TodoListView() {	
		// 객체 생성 중 발생한 예외는 View에서 모아 처리 예정
		// throws는 호출한 곳에서 예외처리를 하는 구문이기 때문
		try {
			service = new TodoListServiceImpl();
			// 키보드 입력 받는 버퍼드리더 보조스트림 생성
			br = new BufferedReader(new InputStreamReader(System.in));
		} catch (Exception e) {
			System.out.println("프로그램 실행 중 오류 발생");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	// 메인 메뉴
	public void mainMenu() {
		int input = 0;
		
		do {
			try {
				input = selectMenu(); // 누르면 나올 메뉴 만드는 용
				
				switch(input) {
				case 1 : /*fullView();*/ break;
				case 2 : break;
				case 3 : todoAdd(); break;
				case 4 : break;
				case 5 : break;
				case 6 : break;
				case 0 : System.out.println("프로그램을 종료합니다"); break;
				default : System.out.println("메뉴에 작성된 번호만 입력해 주세요");
				}
				
				System.out.println("=========================");
				
			} catch (NumberFormatException e) {
				System.out.println("\n숫자만 입력해 주세요\n");
				input = -1; // 첫 반복에서 프로그램이 종료되지 않도록 input 값을 남김
			} catch (IOException e) {
				System.out.println("\n다시 입력해 주세요\n");
				e.printStackTrace();
			} catch (Exception e) {
				//나머지 예외 전부
				e.printStackTrace();
			}
			
		} while(input != 0); // 0이 나올 때까지 반복, 0되면 종료
	}


	// 이클립스 기능 이용해서 새로 만듬
	private int selectMenu() throws NumberFormatException, IOException {
		System.out.println("\n===== Todo List =====\n");
		System.out.println("1. Todo List Full View");
		System.out.println("2. Todo Detail View");
		System.out.println("3. Dodo Add");
		System.out.println("4. Todo Complete");
		System.out.println("5. Todo Update");
		System.out.println("6. Todo Delete");
		System.out.println("0. EXIT");
		
		System.out.print("select menu number >>> ");
		int input = Integer.parseInt(br.readLine());
		System.out.println();
		
		return input;
	}
	
	// Todo 전체 보기 add 만들고 다시 만들 예정
//	private void fullView() {
//		List<Todo> todoList = service.getTodoList();
//	}

	// 3. todo 추가
	private void todoAdd() throws IOException {
		System.out.println("\n==[ 3. Todo add ]==\n");
		
		System.out.print("할일 제목 입력 : ");
		String title = br.readLine();
		
		System.out.println("세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)");
		System.out.println("-----------------------------------------------");
		
		StringBuilder sb = new StringBuilder(); // 입력할 스트링빌더
		// 얼마나 입력할지 몰라서 while로 무한 반복
		// split으로는 못하려나?
		
		while(true) {
			String content = br.readLine();
			if (content.equals("!wq")) break;
			sb.append(content);
			sb.append("\n");
		}
		
		System.out.println("-----------------------------------------");
		
		
	}
	
	
}
