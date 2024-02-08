package com.gl.todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;
	@Column(name="title",nullable = false,unique = true)
  String title;
	@Column(name="description",nullable = false,unique = true)
  String description;
	@Column(name ="status",nullable = false)
  String status;
}
