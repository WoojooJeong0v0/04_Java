package pkg3.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import pkg3.dto.Member;

/** 
 * ObjectInputStream / ObjectOupputStream
 * 
 * - 객체를 입출력하는 용도의 바이트 기반 보조 스트림
 * 	(바이트 기반 == 1byte 단위)
 * 	(보조 스트림 == 혼자 사용 불가, 기반 스트림과 함께 사용)
 * 
 * ************************************************************************중요
 * 
 * 	직렬화 (Serializable)
 * - 스트림을 통과하려는 객체(Object)를
 * 	직렬(직선) 형태로 변환하는 것
 * 
 * [직렬화(변환) 방법]
 * - 스트림을 통과하려는 객체에게 Serializable 인터페이스 상속받게 하면 된다!
 * 
 *  역질렬화
 * - 직렬화 된 객체를 다시 정상 객체 형태로 바꾸는 것
 * 
 * [역직렬화 방법]
 * - ObjectInputStream을 이용해서 
 * 	"직렬화"된 객체를 읽어오게 되면
 * 	자동으로 "역직렬화"가 수행됨
 * 
 * *****************************************************************************
 * - 
 * 
 */
public class ObjectService  {
	
	
	/**
	 * 객체를 외부 파일로 출력
	 */
	public void objectOutput() {
		// 출력용 스트림 참조 변수 선언
		FileOutputStream fos = null; // 기반
		ObjectOutputStream oos = null; // 보조
		
		try {
			// 출력할 Member 객체 생성
			Member member = new Member("member01", "pass01", "김길동", 20);
			
			// 폴더가 없으면 생성
			String folder = "/io_test/object";
			
			File f = new File(folder);
			if ( !f.exists() ) { // 폴더가 없다면
				f.mkdirs(); // 경로상 없는 폴더 모두 생성
			}
		
			// 출력 스트림 객체 생성
			fos = new FileOutputStream(folder + "/Member.dat");
										// /io_test/object/Member.dat
										// .dat 확장자 : data를 담고 있는 파일을 나타냄 
			
			oos = new ObjectOutputStream(fos);
			
			/* Member 객체 파일로 출력하기 */
			oos.writeObject(member); // 객체출력
			System.out.println("Member 객체 출력 완료");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 스트림 닫기
			try {
				if (oos != null) oos.close(); // 보조 스트림만 닫으면 됨
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 파일에서 Member 객체 읽어오기
	 */
	public void objectInput() {
		
		// 스트림 참조 변수 선언
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			// 스트림 객체 생성
			fis = new FileInputStream("/io_test/object/Member.dat");
			ois = new ObjectInputStream(fis);
			
			// 직렬화된 객체를 읽어와 역직렬화 후 Member타입으로 다운캐스팅
			Member member = (Member)ois.readObject();
			
			// 확인
			System.out.println(member);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
