package cls.pkg2;

import cls.pkg1.ClassTest1;
//import cls.pkg1.DefaultClass;

public class ClassRun2 {
public static void main(String[] args) {
	// public class + 다른 패키지
	// ClassTest1 객체 생성하기  -> 문제 없다
	
	ClassTest1 t1 = new ClassTest1();
	t1.method();
	
	// (default) class + 다른 패키지
	// 문제가 발생!!
	// 다른 패키지라서 접근이 불가능하다!!
//		DefaultClass d1 = new DefaultClass();
//		d1.method();
}
}
