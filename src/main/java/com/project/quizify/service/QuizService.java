package com.project.quizify.service;

import java.util.List;

import com.project.quizify.models.Answers;
import com.project.quizify.models.Quiz;
import com.project.quizify.models.Result;
import com.project.quizify.models.User;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz,User user);
	
	public List<Quiz> findQuizzesByUser(User user);
	
	public List<Quiz> getQuizzes();
	
	public Quiz updateQuiz(Quiz newQuiz);
	
	public void delete(Quiz quiz) ;
	
	public Quiz find(int quiz_id);
	 
	public Result checkAnswers(List<Answers> answers,Quiz quiz,User user);
	
	
}
