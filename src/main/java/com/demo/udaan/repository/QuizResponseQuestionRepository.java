package com.demo.udaan.repository;

import com.demo.udaan.entity.QuizResponseQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizResponseQuestionRepository extends JpaRepository<QuizResponseQuestion, Long> {
}
