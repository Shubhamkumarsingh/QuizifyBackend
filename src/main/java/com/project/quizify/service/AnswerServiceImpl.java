package com.project.quizify.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quizify.models.Answers;
import com.project.quizify.models.Question;
import com.project.quizify.repository.AnswerRepository;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService{
 @Autowired
private	AnswerRepository ansrepos;
 
 @Autowired
 private	QuestionService quesService;;
 
	@Override
	public List<Answers> save(List<Answers> answerList,int question_id) {
		Question question =quesService.find(question_id);
		List<Answers> temp =new ArrayList<>();
		for(Answers answers : answerList) {
			answers.setQuestion(question);
			temp.add(answers);
		}
		
		//List<Answers>  answers = (List<Answers>) ansrepos.saveAll(answerList);
		
		return ansrepos.saveAll(temp);
	}

	@Override
	public List<Answers> getAnswerByQuestion(Question question) {
		
		return ansrepos.findByQuestion(question);
	}

	@Override
	public Answers update(Answers newAnswer) {
		Answers currentAnswer =find(newAnswer.getId());
		currentAnswer.setText(newAnswer.getText());
		currentAnswer.setIsCorrect(newAnswer.getIsCorrect());
		return currentAnswer;
	}

	@Override
	public Answers find(int id) {
		Answers answers=ansrepos.getOne(id);
		return answers;
	}

	@Override
	public void delete(Answers answer) {
		ansrepos.delete(answer);
		
	}

}
