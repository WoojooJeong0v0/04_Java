package dao;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import dto.Todo;

public class TodoListDaoImpl implements TodoListDao {

	
	// 투두리스트 데이터가 저장될 파일 경로 상수 지정
	private final String FILE_PATH = "/io_test/todolist.dat";
	
	// 투두리스트 저장 객체
	private List<Todo> list = null;
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	public TodoListDaoImpl() {
		File file = new File(FILE_PATH);
		
		if (!file.exists()) {
			
		}
		
	}
	
	
	
	
}
