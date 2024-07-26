package pkg1.dto;

public class Skill {

	private String attack; // 물리공격
	private String atrbAttack; // 속성 공격 attribute attack
	
	public Skill() {} // 기본 생성자

	public Skill(String attack, String atrbAttack) {
		super();
		this.attack = attack;
		this.atrbAttack = atrbAttack;
	}

	
	// getter / setter
	public String getAttack() {
		return attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	public String getAtrbAttack() {
		return atrbAttack;
	}

	public void setAtrbAttack(String atrbAttack) {
		this.atrbAttack = atrbAttack;
	}
	
	
	
}
