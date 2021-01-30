package com.project.quizify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.quizify.models.Answers;
import com.project.quizify.models.Question;


@Repository
public interface AnswerRepository extends JpaRepository<Answers, Integer> {
	public List<Answers> findByQuestion(Question question);
}
