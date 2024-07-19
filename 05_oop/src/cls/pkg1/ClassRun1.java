package cls.pkg1;

public class ClassRun1 {
public static void main(String[] args) {
	// public class + 같은 패키지에 ClassTest1 객체 생성하기
	// 문제가 있는지 없는지 확인
	
	ClassTest1 t1 = new ClassTest1();
	t1.method();
	
	// (default) class + 같은 패키지
	// 객체 생성 문제 없다
	DefaultClass d1 = new DefaultClass();
	d1.method();
}
}
