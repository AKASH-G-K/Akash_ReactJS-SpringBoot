package com.gl.todo.mapper;

import com.gl.todo.dto.ToDoDTO;
import com.gl.todo.entity.ToDo;

public class ToDoMapper {
public static  ToDoDTO maptoToDoDTO(ToDo todo) {
	ToDoDTO dto= new ToDoDTO(todo.getId(), todo.getTitle(), todo.getDescription(), todo.getStatus());
	return dto;
}
public static  ToDo maptoToDo(ToDoDTO toDoDTO) {
	ToDo todo= new ToDo(toDoDTO.getId(),toDoDTO.getTitle(),toDoDTO.getDescription(),toDoDTO.getStatus());
	return todo;
}
}
