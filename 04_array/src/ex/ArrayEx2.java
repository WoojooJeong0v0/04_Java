package ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx2 {

	Scanner sc = new Scanner(System.in);
	
	/**
	 * 얕은 복사
	 * - 참조형 변수가 가지고 있는 "주소"만 복사하는 것!
	 * 
	 * - 서로 다른 변수가 같은 배열/객체를 참조하기 때문에
	 * 	 같은 값을 공유한다!!!
	 * 
	 * 
	 */
	public void method1() {
		// 원본 배열
		int[] arr = {10, 20, 30, 40, 50};
		
		// 얕은 복사한 배열 선언(생성)
		int[] copyArr = arr; // 자료형이 같아서 대입 가능!!
		
		System.out.println("[변경 전]");
		System.out.println("arr : " + Arrays.toString(arr));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		
		// 복사한 배열의 값을 변경하겠다!
		copyArr[3] = 4444;
		copyArr[4] = 5555;
		// 데이터를 공유하기 때문에 변경한 값이 똑같이 적용된다!!
		
		System.out.println("[변경 후]");
		System.out.println("arr : " + Arrays.toString(arr));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		
		// 복사한 배열을 수정했지만 원본도 같이 수정됨을 확인
		// -> 얕은 복사는 주소만 복사했음!! 같은 배열을 참조하게 만들어 값을 공유함
	}
	
	/**
	 * 깊은 복사
	 * - 원본 배열/객체가 가지고 있는 값을 똑같이 복사한 배열/객체를 생성
	 * 	 (복제의 개념)
	 * 
	 * - 새로운 배열/객체가 만들어지는 것으로 원본과는 독립된 존재
	 *  -> 값을 공유하지 않는다!!! 
	 */
	public void method2() {
		
		//원본 배열
		int[] arr = {10, 20, 30, 40, 50};
		
		//깊은 복사 1 : for문 이용
		int[] copyArr = new int[arr.length]; // 원본 크기의 새 배열 생성
		
		// 원본 배열 요소의 값을, 복사된 배열에서 같은 인덱스 요소에 대입
		for(int i = 0 ; i < arr.length ; i++) {
			copyArr[i] = arr[i];
		}
		
		//깊은 복사 2 : System.arrcopy(원본 배열명, 원본 복사시작 인덱스, 복사배열명, 복사 배열의 삽입 시작 인덱스, 복사길이) 이용
		int[] copyArr2 = new int[arr.length];
		System.arraycopy(arr, 0, copyArr2, 0, arr.length); // arr의 0번부터  arr length 만큼 2의 0번부터 복사
		
		// 원본, 복사1, 복사2의 0번 인덱스 값을 변경
		
		arr[0] = 11111;
		copyArr[0] = 22222;
		copyArr2[0] = 33333;
		
		System.out.println("arr : " + Arrays.toString(arr));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		System.out.println("copyArr2 : " + Arrays.toString(copyArr2));
		
		
	}
}
