package com.project.quizify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizify.models.Answers;
import com.project.quizify.models.Question;
import com.project.quizify.models.Quiz;
import com.project.quizify.service.AnswerService;
import com.project.quizify.service.QuestionService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/answer")
public class AnswerController {

	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private QuestionService quesService;
	
	@PostMapping("/{question_id}/saveanswer")
	public ResponseEntity<?> save(@PathVariable int question_id,@RequestBody List<Answers> answers) {
		answerService.save(answers, question_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{question_id}/allanswer")
	public List<Answers> findQuestionByQuiz(@PathVariable int question_id) {
		Question question =quesService.find(question_id);
		return answerService.getAnswerByQuestion(question);
	}
	
	@PutMapping("/updateanswer/{answer_id}")
	public Answers updateQuestion(@PathVariable int answer_id,@RequestBody Answers answer) {
		  answer.setId(answer_id);
		return answerService.update(answer);
	}
	
	@DeleteMapping("/deleteanswer/{answer_id}")
	public void deleteQuestion(@PathVariable int answer_id) {
		  Answers answers =answerService.find(answer_id);
		  answerService.delete(answers);;
	}
}
