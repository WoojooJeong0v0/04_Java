package pkg1.dto;

import java.util.List;
import java.util.Scanner;

// 내 포켓몬
public class My extends Poketmon {
	
	public My()	{
		
	}
	
	Scanner sc = new Scanner(System.in);
	
	public String name() {
		// 이름을 가져와서 오버라이딩하고 싶은데? 방법 다시 확인 필요
		//Syntax error on token(s), misplaced construct(s)
		// 상속받은 것은 굳이 매개변수로 갖고 올 필요가 없다!!
		String myPoketmon = getName();
		return myPoketmon;
	}
	

	@Override
	public int hp() {
		return 30;
	}

	@Override
	public int lv() {
		return 1;
	}

	@Override
	public int experience() {
		return 120;
	}

	@Override
	public List<Skill> getSkillbox() {
		return null;
	}

	@Override
	public List<Elements> getElements() {
		return null;
	}
	
	
	
}
