package com.demo.udaan.controller;

import com.demo.udaan.models.AnswerRequestResponse.AnswerRequest;
import com.demo.udaan.models.AnswerRequestResponse.AnswerResponse;
import com.demo.udaan.models.QuestionRequestResponse.QuestionRequest;
import com.demo.udaan.models.QuestionRequestResponse.QuestionResponse;
import com.demo.udaan.models.QuizRequestResponse.QuizRequest;
import com.demo.udaan.models.QuizRequestResponse.QuizResponse;
import com.demo.udaan.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class QuestionAnswerController {

    @Autowired
    private QuestionAnswerService questionAnswerService;

    @PostMapping("/question")
    public ResponseEntity<?> createQuestion(@Valid @RequestBody QuestionRequest questionRequest) {

        QuestionResponse questionResponse = questionAnswerService.createQuestion(questionRequest);
        return new ResponseEntity<>(questionResponse, HttpStatus.OK);
    }

    @PostMapping("/answer")
    public ResponseEntity<?> createAnswer(@Valid @RequestBody AnswerRequest answerRequest) {

        AnswerResponse answerResponse = questionAnswerService.createAnswer(answerRequest);
        return new ResponseEntity<>(answerResponse, HttpStatus.OK);
    }

    @PostMapping("/quiz")
    public ResponseEntity<?> createQuiz(@Valid @RequestBody QuizRequest quizRequest) {

        QuizResponse quizResponse = questionAnswerService.createQuiz(quizRequest);
        return new ResponseEntity<>(quizResponse, HttpStatus.OK);
    }

}
