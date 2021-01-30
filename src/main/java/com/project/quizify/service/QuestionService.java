package com.project.quizify.service;

import java.util.List;

import com.project.quizify.models.Question;
import com.project.quizify.models.Quiz;

public interface QuestionService {
	
 public Question save(Question question,int quiz_id);
 
 public List<Question> getQuestionByQuiz(Quiz quiz);
 
 public Question update(Question newQuestion);
 
 public Question find(int id);
 
 public void delete(Question question);
}
