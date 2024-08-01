package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import dto.Member;
import service.MemberServiceImpl;

// View : 사용자 클라이언트에게 보여지는 역할을 하는 클래스/객체
// - 보여줄 화면을 출력 / 필요한 데이터를 입력
public class MemberView {

	private MemberServiceImpl service = null; // 서비스 참조 변수
	private BufferedReader br = null; // 버퍼드리더 참조변수
	
	// 기본생성자
	public MemberView() {
		try {
			// 객체 생성 중 발생한 예외를 View에 모아서 처리
			service = new MemberServiceImpl();
			// 키보드를 입력 받기 위한 스트림 생성
			br = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (Exception e) {
			System.out.println("**프로그램 실행 중 오류 발생**");
			e.printStackTrace();
			System.exit(0); // 프로그램 강제 종료, 숫자는 본인이 정의하면 됨
		} finally {
			
		}
	}
	
	//---------------------------------------------------------------------
	
	// [메인메뉴]
	public void mainMenu() {
		
		int input = 0;
		do {
			try {
				// 메뉴 출력 후 입력된 번호를 반환 받기
				input = selectMenu(); // 밑에 만들었던 메서드
				
				// 선택된 메뉴 번호에 따라 case 선택하겠다
				switch(input) {
				case 1 : addMember(); break;
				case 2 : selectAll(); break;
				case 3 : break;
				case 4 : break;
				case 5 : break;
				case 6 : break;
				case 0 : System.out.println("**프로그램 종료**"); break;
				default : System.out.println("메뉴에 작성된 번호만 입력해주세요");
				}
				
				System.out.println("===================================");
				
				
			} catch (NumberFormatException e) {
				System.out.println("\n---숫자만 입력 해주세요---\n");
				input = -1; // 첫 반복에서 종료되지 않게
			} catch (IOException e) {
				System.out.println("\\n---입출력 관련 예외 발생---\\n");
				e.printStackTrace(); // 예외 추적
			} catch(Exception e) {
				// 나머지 예외 전부 다 잡겠다
				e.printStackTrace();
			}
			
		} while(input != 0); // input 이 0이 아닐 때까지 반복
		
	}

	
	//---------------------------------------------------------------------
	
	// [메인메뉴 출력/선택하는 메서드]
	private int selectMenu() throws NumberFormatException, IOException {
		System.out.println("\n===회원 관리 프로그램===\n");
		
		System.out.println("1. 회원가입 (추가)");
		System.out.println("2. 회원 전체 조회");
		System.out.println("3. 이름 검색(동명이인있으면 모두 조회)");
		System.out.println("4. 특정 회원 사용 금액 누적하기");
		System.out.println("5. 회원 정보 수정");
		System.out.println("6. 회원 탈퇴");
		System.out.println("0. 종료");
		
		System.out.print("메뉴 선택 >>>> ");
		int input = Integer.parseInt(br.readLine()); // br.readLine()은 String 반환
		// Integer.parseInt(  ) 형변환
		System.out.println(); // 줄바꿈
		
		return input; // void라고 위에 작성할 경우 붉은 줄 나오니까 위에 반환형을 제대로 맞춰주자
	}
	
	//---------------------------------------------------------------------
	
	// [1. 회원가입 추가]
	private void addMember() throws IOException {
		System.out.println("\n--- 회원 가입 (추가) ---\n");
		
		System.out.print("이름 : ");
		String name = br.readLine();
		
		// 정상입력 아닐 경우를 대비
		// 정상 입력 (숫자 11글자) 될 때까지 다시 입력 받기
		String phone = null;
		
		while(true) {
			System.out.print("휴대폰 번호 (-제외) : ");
			phone = br.readLine();
			
			if(phone.length() != 11) {
				System.out.println("다시 입력 해주세요\n");
				continue;
			}
			
			break;
			
		}
		
		// 회원 추가 서비스 호출 후 결과 반환 받기
		boolean result = service.addMember(name, phone);
		
		if(result) System.out.println("\n***회원이 추가되었습니다***\n");
		 else System.out.println("\n중복된 휴대폰 번호가 존재합니다\n");
	}
	
	
	
	
	
	//---------------------------------------------------------------------
	
	// [2. 회원 전체 조회]
	private void selectAll() {
		System.out.println("\n--회원 전체 조회--\n");
		
		// 회원 목록을 조회해서 반환하는 서비스 호출
		List<Member> memberList = service.getMemberList();
		
		// 조회된 회원 목록이 없을 경우
		// MemberDaoImpl 생성자 코드에 의해서 memberList는 "절대로" null이 될 수 없다!!
		// -> 참조하는 List는 있지만 List가 비어있는 검사를 해야 함
		if(memberList.isEmpty()) {
			System.out.println("=-=회원이 존재하지 않습니다=-="); 
			return;
		}
		
		String[] gradeArr = {"일반", "골드", "다이아"};
		
		System.out.println("-------------------------------------------");
		
		System.out.printf("%-6s %-7s %8s %5s \n",
				"[이름]", "[휴대폰 번호]", "[누적금액]", "[등급]");
		
		System.out.println("-------------------------------------------");
		
		// 향상된 for문
		for(Member member : memberList) {
			System.out.printf("%-6s %-12s %8d %5s \n", member.getName(), member.getPhone(), 
													   member.getAmount(), gradeArr[member.getGrade()]);
		}
		
		
		
	}
	
	
	//---------------------------------------------------------------------
	
	
	
	
	
	
	
}


