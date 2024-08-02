package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;

// View : 사용자 클라이언트에게 보여지는 역할을 하는 클래스/객체
// - 보여줄 화면을 출력 / 필요한 데이터를 입력
public class MemberView {

	private MemberService service = null; // 서비스 참조 변수
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
				case 3 : selectName(); break;
				case 4 : updateAmount(); break;
				case 5 : updateMember(); break;
				case 6 : deleteMember(); break;
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
	
	// 3. 회원 이름으로 검색하기
//	private void memberSearch() throws IOException {
//		System.out.println("\n--회원 이름으로 검색하기--\n");
//		
//		List<Member> memberList = service.getMemberList();
//		
//		System.out.print("검색할 이름 입력 : ");
//		String nameSearch = br.readLine();
//		
//		for (Member mem : memberList) {
//			if (memberLi 리스트 가져와서 
//		} 계속 수정하다가 일단 멈춤
//	
//	
//	}
	
	// 동명이인 포함 이름 검색
	private void selectName() throws IOException {
		System.out.println("\n--- 이름 검색 --- \n");
		
		// 검색할 이름 받음
		System.out.print("이름 검색 : ");
		String searchName = br.readLine();
		
		//이름 검색 서비스 호출 후 결과 반환
		// 서비스 작성 후 돌아올 예정
		// 작성완료 되어 다시 작성
		List<Member> searchList = service.selectName(searchName);
		
		// 검색결과가 없을 경우
		if(searchList.isEmpty()) { // null 아니고 무조건 참조하는 객체가 생기기 때문!! isEmpty로 비교
			System.out.println("검색 결고가 없습니다");
			return;
		}
		
		// 검색결과가 있을 경우
		for(Member mem :searchList) { // searchList 에서 하나씩 꺼낸 친구들
			System.out.println(mem);
		}
		
	}
	
	//---------------------------------------------------------------------
	
	// 4. 특정 회원 사용 금액 누적하기
	private void updateAmount() throws IOException {
		System.out.println("\n---특정 회원 사용 금액 누적하기---\n");
		
		System.out.print("회원 이름 입력 : ");
		String targetName = br.readLine(); // 버퍼드
		
		// 일치하는 회원 모두 조회
		List<Member> searchList = service.selectName(targetName); // 만들어둔 거 재 사용
		// selectName은 searchList로 반환 해주는 메서드
		
		// 이름 일치하는 회원이 없을 경우
		if(searchList.isEmpty()) {
			System.out.println("\n 이름 일치하는 회원이 존재하지 않습니다 \n");
			return;
		}
		
		// 이름이 일치하는 회원이 있을 경우
		// 위에서는 List 형태로 받아왔지만 한 명의 회원만 골라와야 한다!
		// 금액 증가 대상 회원만 참조할 Member 참조변수 선언이 필요함
		Member target = null;
		
		// 1) 동명이인이 있을 경우 => 이름/전화번호 출력해서 한 명만 선택
		if (searchList.size() > 1) { // 1명보다 더 많은 검색결과가 나왔다
			System.out.println("\n*** 대상 회원을 선택해 주세요 ***\n");
			
			// 일반 for문 사용 이유 -> i 값 활용하고 싶어서
			for(int i = 0 ; i < searchList.size() ; i++) {
				System.out.printf("%d) %s (%s)\n", i+1, searchList.get(i).getName(), searchList.get(i).getPhone());
				// +1 하는 건 0부터 시작해서
			}
			
			System.out.print("선택할 회원의 번호를 입력 : ");
			int input = Integer.parseInt(br.readLine()) - 1;  // 문자열을 정수로 변환
			// -1 하는 이유 : 입력된 번호를 index에 맞추기 위해서 
			
			// 입력된 번호가 searchList의 index 범위를 초과한 경우
			
			if(input < 0 || input >= searchList.size()) { // 크거나 같거나
				System.out.println("\n 없는 회원 번호입니다. 처음부터 다시 시도해주세요 \n");
				return;
			}
			
			// target에 회원을 저장해둠
			target = searchList.get(input);
			
		} else {
			// 2) 동명이인이 없을 때
			target  = searchList.get(0); // 1명뿐이라 무조건 0번
		}
		
		
		// 누적할 금액 입력
		System.out.print("누적할 금액 입력 : ");
		int acc = Integer.parseInt(br.readLine());
		
		// 서비스로 넘길 것
		// 대상 회원, 누적할 금액을 서비스로 전달하여 
		// - 금액 누적
		// - 등급 조정
		// - 파일에 데이터 저장 
		// 3가지 기능 수행 하도록 작성
		
		// - 서비스에서 반환 받을 문자열
		// 예 ) 뇨롱 회원님의 누적 금액
		// 		2000 -> 10000
		// 		* 골드 * 등급으로 변경 되셨습니다
		
		String result = service.updateAmount(target, acc); // 미리 자료형 나올 걸 알아서 만들어둠
		
		System.out.println(result);
		}
	
	//---------------------------------------------------------------------
	
	// 5. 특정 회원 정보 수정하기
	
	private void updateMember() throws IOException {
		System.out.println("\n---특정 회원 정보 수정하기---\n");
		
		System.out.print("회원 이름 입력 : ");
		String targetName = br.readLine();
		
		List<Member> searchList = service.selectName(targetName);
		
		if(searchList.isEmpty()) {
			System.out.println("\n 이름 일치하는 회원이 존재하지 않습니다 \n");
			return;
		}
		
		// 수정 대상을 참조할 변수 선언
		Member target = null;
		
		if (searchList.size() > 1) { // 동명이인 있을 경우
			System.out.println("\n*** 대상 회원을 선택해 주세요 ***\n");
			for(int i = 0; i < searchList.size() ; i++) {
				System.out.printf("%d) %s (%s)\n", i+1, searchList.get(i).getName(), searchList.get(i).getPhone());
			}
			
			System.out.print("선택할 회원 번호를 입력 : ");
			int input = Integer.parseInt(br.readLine()) - 1;
			if (input < 0 || input >= searchList.size()) {
				System.out.println("\n 없는 회원 번호 입니다. 처음부터 다시 입력하세요");
				return;
			}
			
			target = searchList.get(input);
		} else target = searchList.get(0);
		
		// 바꿀 전화번호 입력
		System.out.print("바꿀 전화번호 입력 : ");
		String editPhon = br.readLine();
		
		// 정보수정 서비스 호출 후 결과 문자열 반환 받기
		String result = service.updateMember(target, editPhon);
		
		System.out.println(result);
		
		
	}
	
	//---------------------------------------------------------------------
	
	// 6. 회원 탈퇴
	private void deleteMember() throws IOException {
		System.out.println("\n---특정 회원 탈퇴하기---\n");
		
		System.out.print("회원 이름 입력 : ");
		String targetName = br.readLine();
		
		List<Member> searchList = service.selectName(targetName);
		
		if(searchList.isEmpty()) {
			System.out.println("\n 이름 일치하는 회원이 존재하지 않습니다 \n");
			return;
		}
		
		// 탈퇴 대상을 참조할 변수 선언
		Member target = null;
		
		if (searchList.size() > 1) { // 동명이인 있을 경우
			System.out.println("\n*** 대상 회원을 선택해 주세요 ***\n");
			for(int i = 0; i < searchList.size() ; i++) {
				System.out.printf("%d) %s (%s)\n", i+1, searchList.get(i).getName(), searchList.get(i).getPhone());
			}
			
			System.out.print("선택할 회원 번호를 입력 : ");
			int input = Integer.parseInt(br.readLine()) - 1;
			if (input < 0 || input >= searchList.size()) {
				System.out.println("\n 없는 회원 번호 입니다. 처음부터 다시 입력하세요");
				return;
			}
			
			target = searchList.get(input);
		} else target = searchList.get(0);
		
		
		// 정말 탈퇴할 것인지 확인
		System.out.print("정말 탈퇴 처리 하시겠습니까? ( y / n )");
		// 입력 받은 문자열을 소문자로 만들어 제일 앞 문자 하나만 반환받기
		char check = br.readLine().toLowerCase().charAt(0);
		
		if (check == 'n') {
			System.out.println("탈퇴 취소");
			return;
		}
		
		if (check != 'y') {
			System.out.println("\n 잘못 입력 하셨습니다\n다시 시도해 주세요");
			return;
		}
		
		// y 입력된 경우 탈퇴
		// 탈퇴 서비스 호출 후 결과 문자열 반환 받기
		String result = service.deleteMember(target);
		System.out.println(result);
		
		
	}
	
	
}


