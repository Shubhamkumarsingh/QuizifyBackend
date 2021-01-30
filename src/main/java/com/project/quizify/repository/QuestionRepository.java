package com.project.quizify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.quizify.models.Question;
import com.project.quizify.models.Quiz;
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{

	public List<Question> findByQuiz(Quiz quiz);
}
