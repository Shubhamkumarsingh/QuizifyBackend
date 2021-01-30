package com.project.quizify.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="quiz_table")
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Length(min = 5, max = 50, message = "Quiz name must be minimum 5 and maximum 50 characters")
	private String name;

	@OneToOne
	//@Cascade(value = {CascadeType.ALL})
	@JsonIgnore
	@JoinColumn(name="user_id")
	private User user;
	
	//@JsonIgnore
	@OneToMany(mappedBy="quiz")
	@Cascade(value = {CascadeType.ALL})
	private List<Question> questions = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Quiz(int id, User user,
			@Length(min = 5, max = 50, message = "Quiz name must be minimum 5 and maximum 50 characters") String name,
			List<Question> questions) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.questions = questions;
	}

	}
