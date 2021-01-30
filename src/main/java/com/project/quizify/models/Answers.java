package com.project.quizify.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="answers_table")
public class Answers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="text",length = 255)
	private String text;
	
	@Column(name="is_correct")
	private byte isCorrect;
    @JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private Question question;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(byte isCorrect) {
		this.isCorrect = isCorrect;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answers(int id, byte isCorrect, String text, Question question) {
		super();
		this.id = id;
		this.isCorrect = isCorrect;
		this.text = text;
		this.question = question;
	}
}
