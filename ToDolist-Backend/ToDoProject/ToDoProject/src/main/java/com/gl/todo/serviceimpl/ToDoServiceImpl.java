package com.gl.todo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.todo.dto.ToDoDTO;
import com.gl.todo.entity.ToDo;
import com.gl.todo.exception.ResourceNotFoundException;
import com.gl.todo.mapper.ToDoMapper;
import com.gl.todo.repository.ToDoRepository;
import com.gl.todo.service.ToDoService;
@Service
public class ToDoServiceImpl implements ToDoService {
    @Autowired
    ToDoRepository toDoRep;
	@Override
	public ToDoDTO createToDo(ToDoDTO dto) {
		// TODO Auto-generated method stub
		ToDo todo=ToDoMapper.maptoToDo(dto);
		ToDo todo1=toDoRep.save(todo);
	    return ToDoMapper.maptoToDoDTO(todo1);
	}

	@Override
	public ToDoDTO getToDoById(int id) {
		// TODO Auto-generated method stub
		ToDo todo=null;
		todo=toDoRep.findById(id).orElseThrow(()-> new ResourceNotFoundException("Your todo doesn't exists"));
		
		return ToDoMapper.maptoToDoDTO(todo);
	}

	@Override
	public ToDoDTO updateToDoById(int id, ToDoDTO dto) {
		// TODO Auto-generated method stub
		ToDo todo1=null;
		todo1=toDoRep.findById(id).orElseThrow(()-> new ResourceNotFoundException("Your todo doesn't exists"));
		todo1.setTitle(dto.getTitle());
		todo1.setDescription(dto.getDescription());
		todo1.setStatus(dto.getStatus());
		return ToDoMapper.maptoToDoDTO(toDoRep.save(todo1));
	}

	@Override
	public void deleteToDoById(int id) {
		// TODO Auto-generated method stub
		ToDo todo=null;
		todo=toDoRep.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo with "+id+"doesn't exists"));
		toDoRep.deleteById(id);

	}

	@Override
	public List<ToDoDTO> getAllToDo() {
		// TODO Auto-generated method stub
		List<ToDo> list=toDoRep.findAll();
		return list.stream().map((todo)->ToDoMapper.maptoToDoDTO(todo)).collect(Collectors.toList());
	}

	@Override
	public ToDoDTO statusComplete(int id) {
		// TODO Auto-generated method stub
		ToDo todo1=toDoRep.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo with "+id+"doesn't exists") );
		todo1.setStatus("completed");
		return ToDoMapper.maptoToDoDTO(toDoRep.save(todo1));
	}

	@Override
	public ToDoDTO statusInComplete(int id) {
		// TODO Auto-generated method stub
		ToDo todo1=toDoRep.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo with "+id+"doesn't exists") );
		todo1.setStatus("Notcompleted");
		return ToDoMapper.maptoToDoDTO(toDoRep.save(todo1));
	}

	

	

	


	

	

	



}
