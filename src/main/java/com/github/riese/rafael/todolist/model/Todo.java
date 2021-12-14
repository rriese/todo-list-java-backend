package com.github.riese.rafael.todolist.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "todos")
public class Todo {

	@Id
	private String id;
	@Indexed(unique=true)
	@NotNull(message = "Title must not be null")
	private String title;
	@NotNull(message = "Description must not be null")
	private String description;
	@NotNull(message = "Finished flag must not be null")
	private boolean finished;
	private Date date;
	
}
