package com.gl.todo.service;

import java.util.List;

import com.gl.todo.dto.ToDoDTO;
import com.gl.todo.entity.ToDo;

public interface ToDoService {
	//CRUD,getAll,completeToDo,incompleteToDo
	ToDoDTO createToDo(ToDoDTO dto);
	ToDoDTO getToDoById(int id);
	ToDoDTO updateToDoById(int id,ToDoDTO dto);
	void deleteToDoById(int id);
	List<ToDoDTO> getAllToDo();
	ToDoDTO statusComplete(int id);
	ToDoDTO statusInComplete(int id);
	/*
	 * ToDo completeToDo(String complete,ToDo todo); ToDo inCompleteToDo(String
	 * incomplete,ToDo todo);
	 */
}
