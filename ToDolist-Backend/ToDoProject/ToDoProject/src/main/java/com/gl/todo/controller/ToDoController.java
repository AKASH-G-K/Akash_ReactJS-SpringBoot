package com.gl.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.todo.dto.ToDoDTO;
import com.gl.todo.entity.ToDo;
import com.gl.todo.serviceimpl.ToDoServiceImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/todo")
public class ToDoController {
	@Autowired
	ToDoServiceImpl service;
	
	@GetMapping
	ResponseEntity<List<ToDoDTO>> getAllToDo(){
		List<ToDoDTO> list=service.getAllToDo();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	@PostMapping
	ResponseEntity<ToDoDTO> createToDo(@RequestBody ToDoDTO dto){
		service.createToDo(dto);
		return new ResponseEntity<>(dto,HttpStatus.CREATED);
	}
	@GetMapping("{id}")
	ResponseEntity<ToDoDTO> getToDoById(@PathVariable("id") int id){
		ToDoDTO dto=service.getToDoById(id);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	ResponseEntity<ToDoDTO> deleteToDoById(@PathVariable("id")int id){
		service.deleteToDoById(id);
		return new ResponseEntity("ToDo deleted successfully",HttpStatus.OK);
	}
	@PutMapping("{id}")
	ResponseEntity<ToDoDTO> updateToDoById(@PathVariable("id")int id,@RequestBody ToDoDTO dto){
		ToDoDTO dto1= service.updateToDoById(id, dto);
		return new ResponseEntity<>(dto1,HttpStatus.OK);
		
	}
	@PatchMapping("/{id}/complete")
	ResponseEntity<ToDoDTO> completeToDoById(@PathVariable("id")int id){
		ToDoDTO dto1= service.statusComplete(id);
		return new ResponseEntity<>(dto1,HttpStatus.OK);
		
	}
	@PatchMapping("/{id}/in-complete")
	ResponseEntity<ToDoDTO> inCompleteToDoById(@PathVariable("id")int id){
		ToDoDTO dto1= service.statusInComplete(id);
		return new ResponseEntity<>(dto1,HttpStatus.OK);
		
	}
	

}
