package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.Todo;

public class TodoListDaoImpl implements TodoListDao {

	
	// 투두리스트 데이터가 저장될 파일 경로 상수 지정
	private final String FILE_PATH = "/io_test/todolist.dat";
	
	// 투두리스트 저장 객체
	private List<Todo> todoList = null;
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	public TodoListDaoImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(FILE_PATH);
		
		if (file.exists()) { // file이 존재하는 경우에는 이 배열 리스트에 데이터를 저장할 예정
			try {
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH)); // Checked Exception 은 throws
				todoList = (ArrayList<Todo>) ois.readObject();
			} finally {
				if (ois != null) ois.close();
			}
		}
		else todoList = new ArrayList<Todo>(); // 없을 경우 저장할 리스트
		// 해당 리스트에 들어있는 배열을 나중에 세이브할 때 내보낼 예정
	}
	
	
	@Override
	public List<Todo> getTodoList() {
		return todoList;
	}
	
	
	
	
}
