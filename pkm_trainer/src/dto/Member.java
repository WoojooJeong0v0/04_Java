package dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 매개변수 생성자
@ToString // toString

public class Member { // 객체로 내보내기 할 때 implements Serializable 해줘야 함!!
	
	// 포켓몬 트레이너 등급 
	// 퍼블릭 스태틱 상수 로 저장
	public static final int NOVICE = 0; // 뉴비
	public static final int ELITE = 1; // 엘리트
	public static final int VETERAN = 2; // 베테랑
	public static final int MASTER = 3; //  마스터
	// Member.MASTER 등으로 사용
	
	private String name;
	private String phone;
	private int badge; // 배지 개수 누적에 따라 등급 결정
	private int grade; // 트레이너 등급
	
}
