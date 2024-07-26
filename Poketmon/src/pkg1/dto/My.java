package pkg1.dto;

import java.util.List;

// 내 포켓몬
public class My extends Poketmon {
	
	public My()	{}
	
	public String name(Poketmon.getName) {
		// 이름을 가져와서 오버라이딩하고 싶은데? 방법 다시 확인 필요
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
