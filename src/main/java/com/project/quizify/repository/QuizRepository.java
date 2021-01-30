package com.project.quizify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.quizify.models.Quiz;
import com.project.quizify.models.User;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>{

	public List<Quiz> findByUser(User user);
}
