package com.demo.udaan.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public interface QuizRequestResponse {

    @Getter
    @Setter
    public class QuizRequest {
        @NotNull private int numberOfQuestions;

    }

    public class QuizResponse {

    }
}
