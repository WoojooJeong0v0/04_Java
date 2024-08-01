package pkg4.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 문자 기반 스트림
 * 
 * - 2byte 문자(char)단위로 입/출력하는 스트림
 * 
 * - 문자만 작성된 파일(txt), 채팅, 인터넷 요청(브라우저 주소 등)/응답(html)
 * 
 * - Reader(입력), Writer(출력) 최상위 인터페이스
 */


public class CharService {

	
	/**
	 * 문자 기반 스트림을 이용해 출력
	 * - 기반 스트림만 이용
	 */
	public void fileOutput1() {
		// StringBuilder : 불변성(이뮤터블) 해결한 객체
		StringBuilder sb = new StringBuilder();
		
		sb.append("오늘은 8월 1일 입니다\n");
		sb.append("아쉽게도 목요일\n");
		sb.append("조금 피곤쓰\n");
		sb.append("0231546\n");
		sb.append("adfdfADFSADF\n");
		
		String str = sb.toString();
		
		// 문자 기반 스트림 참조 변수 선언
		FileWriter fw = null;
		
		try { 
			// 예외가 발생할 것 같은 코드를 작성하는 구문

			File folder = new File("/io_test/char");
			if( !folder.exists() ); folder.mkdirs();
			
			// 문자 기반 스트림 객체 생성
			fw = new FileWriter("/io_test/char/문자테스트.txt");
			
			// 문자열을 지정된 파일에 출력, 
			// 자동으로 전달한 String을 한 글자씩 끊어서 한 번에 출력
			fw.write(str);
			
			// flush : 
			fw.flush();
			
			System.out.println("출력완료");
			
		} catch(Exception e) {
			// try에서 던져진 예외를 잡아서 처리하는 구문
			// Exception은 모든 예외를 잡아내는 다형성 업캐스팅 상태
			e.printStackTrace();
		} finally {
			// try 예외 발생 여부 관계 없이 무조건 수행
				try {
					// close() : flush() 후 스트림 닫기
					if(fw != null) fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	
	/**
	 * 문자 기반 스트림을 이용해 출력하기2
	 * 
	 * - 기반 + 보조 스트림 사용
	 * (보조스트림: 실행 속도 향상)
	 */
	public void fileOutput2() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("문자 기반 보조 스트림\n");
		sb.append("BufferedWriter를 이용해\n");
		sb.append("출력한 결과입니다\n");
		
		
		String str = sb.toString();
		
		//스트림 참조 변수 선언
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			// 스트림 객체 생성
			fw = new FileWriter("/io_test/char/보조스트림출력.txt");
			bw = new BufferedWriter(fw);
			
			bw.write(str); // 보조스트림 이용해 출력
			System.out.println("출력완료!");
			bw.flush(); // 스트림 존재하는 데이터 흘려보내기, 안전하게!
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// - 보조 스트림을 닫으면 기반 스트림도 같이 닫힘
				// - close() 호출 시 자동으로 flush()도 호출됨
				if (bw != null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	/**
	 * 문자 기반 입력 스트림을 이용해 
	 *   /io_test/char/문자테스트.txt 파일 내용을 읽어와 콘솔에 출력해라
	 *   
	 * 
	 */
	public void fileInput1() {
		
		FileReader fr = null;
		
		try {
			
			// 스트림 객체 생성해서 파일하고 연결하기
			fr = new FileReader("/io_test/char/문자테스트.txt");
			
			// fr.read ; 문자 하나(2byte) 를 읽어옴, 없으면 -1
			
//			char[] chars = fr.read();
			int value = 0; // 리턴되는 정수를 저장하기 쉽기 때문에 그냥 int
			StringBuilder str = new StringBuilder(); // 객체 컨스트럭터를 만들어야 해서 new
			while(true) {
				value = fr.read();
				if (value == -1) break; // 더이상 읽어올 문자가 없을 경우
				str.append((char)value); // char로 만들어서 누적을 해주겠다
			}
			
			System.out.println(str.toString());
			
		}catch (Exception e) {
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 문자 기반 스트림을 이용해 입력 받기2
	 * - 기반 + 보조 스트림
	 */
	
	/*
	 * char 자료형도 사실 정수를 저장하고 있다!
	 */
	public void fileInput2() {
		
		// 스트림 참조 변수 선언
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			// 스트림 객체 생성
			fr = new FileReader("/io_test/char/문자테스트.txt");
			br = new BufferedReader(fr);
			
			// String br.readLine()
			// -> 한 줄을 읽어옴, 없으면 null 반환
			// -> \n은 읽어오지 않음
			
			String line = null; // 읽어온 한 줄을 저장할 변수
			
			StringBuilder sb = new StringBuilder();
			
			while(true) {
				line = br.readLine();
				
				// 읽어온 내용이 없다면 반복 종료
				if(line == null) break;
				
				sb.append(line); // 읽어온 내용 누적
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
