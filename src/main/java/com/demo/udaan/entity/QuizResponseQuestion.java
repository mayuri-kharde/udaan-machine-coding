package com.demo.udaan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "quiz_response_question")
@Setter
@Getter
public class QuizResponseQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "quiz_response_id")
    private QuizResponse quizResponse;
    @ManyToOne
    @JoinColumn(name = "quiz_question_id")
    private QuizQuestion quizQuestion;
    @ManyToOne
    @JoinColumn(name = "question_choice_id")
    private QuestionChoice QuestionChoice;
}
