package com.project.quizify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.quizify.models.Result;

public interface ResultRepository extends JpaRepository<Result, Integer> {

}
