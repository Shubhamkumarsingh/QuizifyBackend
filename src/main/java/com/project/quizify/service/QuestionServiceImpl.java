package com.project.quizify.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quizify.models.Question;
import com.project.quizify.models.Quiz;
import com.project.quizify.repository.QuestionRepository;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{
	@Autowired
    private QuestionRepository questionrepos;
	
	@Autowired
	private QuizService quizService;
	@Override
	public Question save(Question question,int quiz_id) {
		Quiz quiz=quizService.find(quiz_id);
		question.setQuiz(quiz);
		return questionrepos.save(question);
	}
	
	@Override
	public List<Question> getQuestionByQuiz(Quiz quiz) {
		
		return questionrepos.findByQuiz(quiz);
	}

	@Override
	public Question update(Question newQuestion) {
		Question currentQuestion =find(newQuestion.getId());
		currentQuestion.setText(newQuestion.getText());
		return currentQuestion;
	}

	@Override
	public Question find(int id) {
		Question question=questionrepos.getOne(id);
		return question;
	}

	@Override
	public void delete(Question question) {
		
		questionrepos.delete(question);
		
	}

}
