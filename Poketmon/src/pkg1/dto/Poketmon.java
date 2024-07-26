package pkg1.dto;
// 인터페이스가 아니라 추상 클래스로 작성하는 것이 좋은 내용

import java.util.List;

public abstract class Poketmon {
	
	//모든 포켓몬은 이름을 가짐
	private String name;
	
	// 모든 포켓몬은 hp를 가짐
	public abstract int hp();
	
	// 모든 포켓몬은 lv을 가짐
	public abstract int lv();
	
	// 모든 포켓몬은 경험치를 가짐
	public abstract int experience();
		
	// 모든 포켓몬은 기술상자를 가짐 (list 이용)
	public abstract List <Skill> getSkillbox();
	// list import 필요
	
	// 모든 포켓몬은 속성을 가짐
	public abstract List <Elements> getElements();
	
	// getter / setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return name + hp() + lv();
	}


	
}
