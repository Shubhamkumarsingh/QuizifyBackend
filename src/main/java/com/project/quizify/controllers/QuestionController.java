package com.project.quizify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizify.models.Question;
import com.project.quizify.models.Quiz;
import com.project.quizify.service.QuestionService;
import com.project.quizify.service.QuizService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/question")
public class QuestionController {

	@Autowired
	private QuizService quizService;
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/{quiz_id}/savequestion")
	public Question save(@PathVariable int quiz_id,@RequestBody Question question) {
		
		return questionService.save(question,quiz_id);
	}
	
	@GetMapping("/{quiz_id}/allquestion")
	public List<Question> findQuestionByQuiz(@PathVariable int quiz_id) {
		Quiz quiz =quizService.find(quiz_id);
		return questionService.getQuestionByQuiz(quiz);
	}
	
	@PutMapping("/updatequestion/{question_id}")
	public Question updateQuestion(@PathVariable int question_id,@RequestBody Question question) {
		  question.setId(question_id);
		return questionService.update(question);
	}
	
	@DeleteMapping("/deletequestion/{question_id}")
	public void deleteQuestion(@PathVariable int question_id) {
		  Question question =questionService.find(question_id);
		 questionService.delete(question);;
	}
	
}
