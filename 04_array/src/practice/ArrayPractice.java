package practice;

import java.util.Scanner;

public class ArrayPractice {
	
	Scanner sc = new Scanner(System.in);
	
	
	// 길이가 9인 배열 선언 및 할당
	// 1부터 9까지 값을 반복문 이용하아ㅕ 순서대로 각 배열 인덱스 요소에 대입 후 출력
	// 짝수번째 인덱스 값의 합을 출력 0번째 인덱스는 짝수로 취급
	public void practice1() {
		int[] arr = new int[9]; // 배열 선언 , 할당
		// 배열 요소 초기화
		for(int i = 0 ; i < arr.length ; i++) { 
			arr[i] = i+1;
		}
		// 출력 및 합계
		int sum = 0;
		
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");
			
			if(i % 2 == 0) { // 짝수 번째 인덱스 요소 합 구하기
				sum += arr[i];
			}
		}
		
		// \n 개행 문자, 줄바꿈
		System.out.println("\n짝수 번째 인덱스 합" + sum);
	}
	
	
	/**
	 * 다시 확인
	 */
	public void practice2(){
		int[] arr = new int[9]; // 배열 선언, 할당
		
		for(int i = 0 ; i < arr.length ; i++) {
			 arr[i] = arr.length - i;
		}
		
		int sum = 0;
		
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");
			if(i % 2 == 1) {
			sum += arr[i];
			}
		}
		
		System.out.println("\n홀수 번째 인덱스 합" + sum);
		
	}
	
	/* 강사님 풀이
	 * public void practice2() {
		
		// 정방향(0 -> 8)
		int[] arr = new int[9];
		
		// i              : 0 1 2 3 4 5 6 7 8 
		// arr.length     : 9 9 9 9 9 9 9 9 9 
		// arr.legnth - i : 9 8 7 6 5 4 3 2 1
		// arr[i]         : 9 8 7 6 5 4 3 2 1
		
		int sum = 0;
		
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = arr.length - i;
			System.out.print(arr[i] + " ");
			if(i % 2 == 1) sum += arr[i];
		}
		
		System.out.println("\n홀수 번째 인덱스 합 : " + sum);
		
		
		
		System.out.println("--------------------------");
		
		// 역방향(8 -> 0)
		int[] arr2 = new int[9];
		
		int sum2 = 0;
		
		// arr.length     : 9 9 9 9 9 9 9 9 9
		// i              : 8 7 6 5 4 3 2 1 0
		// arr.length - i : 1 2 3 4 5 6 7 8 9
		// arr[i]         : 1 2 3 4 5 6 7 8 9
		
		// 대입은 역방향
		for(int i = arr2.length - 1 ; i >= 0 ; i--) {
			arr2[i] = arr2.length - i;
			if(i % 2 == 1)  sum2 += arr2[i];
		}
		
		// 출력은 정방향
		for(int num : arr2) {
			System.out.print(num + " ");
		}
		
		System.out.println("\n홀수 번째 인덱스 합 : " + sum2);
		
		*/
	
	
	public void practice3() {
		
		// 사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당
		// 1부터 입력 받은 값까지 배열에 초기화한 후 출력하기
		
		System.out.println(" 정수를 입력 하세요 ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}
	}
	
	
	public void practice4() {
		// 정수 5개를 받아 배열 초기화
		// 검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스 찾아 출력
		// 배열에 같은 수가 없을 경우 일치하는 값이 없습니다 출력
		
		System.out.println("정수 입력 1: ");
		int num1 = sc.nextInt();
		
		System.out.println("정수 입력 2: ");
		int num2 = sc.nextInt();
		
		System.out.println("정수 입력 3: ");
		int num3 = sc.nextInt();
		
		System.out.println("정수 입력 4: ");
		int num4 = sc.nextInt();
		
		System.out.println("정수 입력 5: ");
		int num5 = sc.nextInt();
		
		int[] arr = new int[5];
		
		arr[0] = num1;
		arr[1] = num2;
		arr[2] = num3;
		arr[3] = num4;
		arr[4] = num5;
		
		System.out.println("검색할 정수 입력 : ");
		int serchNum = sc.nextInt();
		
		int result;
		
		for(int i = 0 ; i < arr.length ; i++) {
			result = arr[i];
			if(serchNum == result) {
				System.out.println("일치하는 인덱스는" + result + "입니다");
			} else {
				System.out.println("일치하는 값이 없습니다");
			}
		}
		
	}
	
	/*
	 * 	
	public void practice4() {
		
		int[] arr = new int[5];
		
		for(int i=0 ; i<arr.length ; i++) {
			System.out.printf("입력 %d : ", i);
			arr[i] = sc.nextInt(); // 요소 마다 입력 값 대입
		}
		
		System.out.print("검색할 값 : ");
		int search = sc.nextInt();
		
		// 검색 값이 존재하면 true
		// 없으면 false
		boolean flag = false;
		
		for(int i=0 ; i<arr.length ; i++) { // 검색
			
			// i번째 요소에 저장된 값과 검색할 값이 같은 경우
			if(arr[i] == search) {
				System.out.println("인덱스 : " + i);
				flag = true; // 같은 값이 있으니 true로 변경
			}
			
		}
		
		if(!flag) {  // flag == false
			System.out.println("일치하는 값이 존재하지 않습니다");
		}
		
		
	}
	*/
			/*
	 * 	public void practice5() {
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		int sum = 0;
		
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt();
			
			sum += arr[i]; // 합계 누적
		}
		
		
		// 한 줄 출력
		for(int value : arr)  System.out.print(value + " ");
		
		// 합계 출력
		System.out.println("\n총 합 : " + sum);
	}
	
	*/
	
	/*
	 * 	public void practice6() {
		// 991122-1234567
//		char[] arr = new char["991122-1234567".length()];
		char[] arr = new char[14];
		
		System.out.print("주민등록번호(-포함) : ");
		String str = sc.next();
		
		// 주민등록번호를 char 배열 요소로 하나씩 대입
		for(int i = 0 ; i < str.length() ; i++) {
			
			if(i <= 7) 	arr[i] = str.charAt(i); // 성별 까지
			else		arr[i] = '*';			// 성별 이후
			
			System.out.print(arr[i]);
		}
	}*/
	
//	public void practice7()	{
		// 3이상인 홀수 입력 
		// 배열의 중간까지 1부터 1씩 증가하여 오름차순으로 값 출력 
		// 중간 이후부터 끝까지 1씩 감소하여 내림차순으로 값 출력
		// 입력한 정수가 홀수가 아니거나 3미만일 때 "다시 입력하세요" 후
		// 정수를 다시 받도록 함
		
//		while(true) {
//		System.out.print("3 이상 홀수 입력 : ");
//		int num = sc.nextInt();
//		
//		if(num < 3 || num % 2 == 0) {
//			
//				System.out.println("다시 입력하세요.");
//				continue;
//			} 
//		}
//
//		int[] arr = new int[num];
//		if(num >= 3 && num %2 == 1) {
//			for(int i = 0 ; i < arr.length ; i++) {
//				arr[i] = num;
//				System.out.println(arr[i]);
//			}
//		}
//		
	
	
		
	}
	


