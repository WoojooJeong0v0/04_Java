package pkg1.view;

import java.util.Scanner;

public class PokeView {
	private Scanner sc = new Scanner(System.in);
	
	/**
	 *사용자에게 보여질 메인 화면
	 	 */
	
	public void mainMenu() {
		int menu = 0;
		do {
			System.out.println("1. 이름 짓기");
			System.out.println("2. 내 포켓몬 상태 보기");
			System.out.println("3. 전투 시작");
			System.out.println("4. 기술 배우기");
			System.out.println("0. 게임 종료");
			
			System.out.print("무얼 하시겠습니까? ");
			System.out.println();
			menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu){
			case 1 : namming(); break;
			case 2 : break;
			case 3 : break;
			case 4 : break;
			case 0 : break;
			default : System.out.println("잘못 입력하셨습니다.");
			}
			
		}while(menu != 0);
	}
	
	public void namming() {
		System.out.print("이름을 지어주세요 : ");
		String myPoketmon = sc.nextLine();
		System.out.println("내 포켓몬 이름은 " + myPoketmon + "입니다!");
		System.out.println("만나서 반가워요!\n");
	}

}
