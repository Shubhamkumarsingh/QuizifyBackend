package com.project.quizify.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="result_table")
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int quiz_id;
	
	private Long user_id;
	
	private int score;

	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(int id, int quiz_id, Long user_id, int score) {
		super();
		this.id = id;
		this.quiz_id = quiz_id;
		this.user_id = user_id;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", quiz_id=" + quiz_id + ", user_id=" + user_id + ", score=" + score + "]";
	}
}
