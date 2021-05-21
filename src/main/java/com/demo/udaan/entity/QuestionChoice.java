package com.demo.udaan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "question_choice")
@Setter
@Getter
public class QuestionChoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
