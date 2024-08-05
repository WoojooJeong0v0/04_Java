package dao;

import java.util.List;

import dto.Todo;

public interface TodoListDao {
	/**
	 * dao객체가 가진 list 반환
	 * @return todoList
	 */
	List<Todo> getTodoList();
	
}
