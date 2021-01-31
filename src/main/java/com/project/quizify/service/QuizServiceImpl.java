package com.project.quizify.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quizify.models.Answers;
import com.project.quizify.models.Quiz;
import com.project.quizify.models.Result;
import com.project.quizify.models.User;
import com.project.quizify.repository.QuizRepository;
import com.project.quizify.repository.ResultRepository;

@Service
@Transactional
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizRepository quizrepos;
    
	@Autowired
	private ResultRepository resultrepos;
	

	@Override
	public Quiz addQuiz(Quiz quiz,User user) {
		quiz.setUser(user);
		return quizrepos.save(quiz);
	}



	@Override
	public List<Quiz> findQuizzesByUser(User user) {
		
		return quizrepos.findByUser(user);
	}



	@Override
	public Quiz updateQuiz(Quiz newQuiz) {
		Quiz currentQuiz = quizrepos.getOne(newQuiz.getId());
		currentQuiz.setName(newQuiz.getName());
		return quizrepos.save(currentQuiz);
	}



	@Override
	public void delete(Quiz quiz) {
		quizrepos.delete(quiz);
		
	}



	@Override
	public Quiz find(int quiz_id) {
		Quiz quiz =quizrepos.getOne(quiz_id);
		return quiz;
	}



	@Override
	public List<Quiz> getQuizzes() {
		
		return quizrepos.findAll();
	}



	@Override
	public Result checkAnswers(List<Answers> answers,Quiz quiz,User user) {
		int count=0;
		
		for(Answers ans : answers ) {
			if(ans.getIsCorrect() == 1) {
				count++;
			}
		}
		System.out.println(count);
		System.out.println(quiz.getId());
		System.out.println(user.getId());
		Result result =new Result();
		result.setQuiz_id(quiz.getId());
		result.setUser_id(user.getId());
		result.setScore(count);
		
		System.out.println(result);
		return resultrepos.save(result);
	}
	
	
}
