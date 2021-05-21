package com.demo.udaan.service;

import com.demo.udaan.entity.Question;
import com.demo.udaan.entity.QuestionChoice;
import com.demo.udaan.models.AnswerRequestResponse.AnswerResponse;
import com.demo.udaan.models.AnswerRequestResponse.AnswerRequest;
import com.demo.udaan.models.QuestionRequestResponse.QuestionRequest;
import com.demo.udaan.models.QuestionRequestResponse.QuestionResponse;
import com.demo.udaan.models.QuizRequestResponse.QuizRequest;
import com.demo.udaan.models.QuizRequestResponse.QuizResponse;
import com.demo.udaan.repository.QuestionChoiceRepository;
import com.demo.udaan.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionAnswerService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionChoiceRepository questionChoiceRepository;

    @Transactional
    public QuestionResponse createQuestion(QuestionRequest questionRequest) {

        QuestionResponse questionResponse = new QuestionResponse();
        String desc = questionRequest.getDesc();
        List<String> choices = questionRequest.getChoices();
        Question question = new Question();

        try {
            question.setDescription(desc);
            questionRepository.save(question);

            List<QuestionChoice> questionChoiceList= new ArrayList<>();

            if (choices != null) {
                for (String choice: choices) {
                    QuestionChoice questionChoice = new QuestionChoice();
                    questionChoice.setDescription(choice);
                    questionChoice.setQuestion(question);
                    questionChoiceList.add(questionChoice);
                }

                if (questionChoiceList.size() != 0)
                    questionChoiceRepository.saveAll(questionChoiceList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            questionResponse.setCode("001");
            questionResponse.setMessage("Error saving data");
            return questionResponse;
        }

        questionResponse.setCode("000");
        questionResponse.setMessage("Question saved successfully");
        questionResponse.setId(question.getId());
        return questionResponse;

    }

    public AnswerResponse createAnswer(AnswerRequest answerRequest) {

        AnswerResponse answerResponse = new AnswerResponse();
        Long questionId = answerRequest.getQuestionId();
        List<String> answers = answerRequest.getAnswers();

        Optional<Question> question = questionRepository.findById(questionId);

        if (!question.isPresent()) {
            answerResponse.setCode("001");
            answerResponse.setMessage("invalid question id");
            return answerResponse;
        }

        List<QuestionChoice> questionChoiceList= new ArrayList<>();

        try {
            for (String choice: answers) {
                QuestionChoice questionChoice = new QuestionChoice();
                questionChoice.setDescription(choice);
                questionChoice.setQuestion(question.get());
                questionChoiceList.add(questionChoice);
            }

            if (questionChoiceList.size() != 0)
                questionChoiceRepository.saveAll(questionChoiceList);
        } catch (Exception e) {
            answerResponse.setCode("001");
            answerResponse.setMessage("Error saving data");
            return answerResponse;
        }

        answerResponse.setCode("000");
        answerResponse.setMessage("Answers saved successfully");
        return answerResponse;

    }

    public QuizResponse createQuiz(QuizRequest quizRequest) {
        return null;
    }
}
