package com.demo.udaan.repository;

import com.demo.udaan.entity.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long>  {
}
