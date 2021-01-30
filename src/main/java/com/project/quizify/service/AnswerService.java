package com.project.quizify.service;

import java.util.List;

import com.project.quizify.models.Answers;
import com.project.quizify.models.Question;


public interface AnswerService {
public List<Answers> save(List<Answers> answerList,int question_id);

public List<Answers> getAnswerByQuestion(Question question);

public Answers update(Answers newAnswer);

public Answers find(int id);

public void delete(Answers answer);
}
