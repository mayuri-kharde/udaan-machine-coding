package com.demo.udaan.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface AnswerRequestResponse {
    @Getter
    @Setter
    public class AnswerRequest {

        @NotNull private Long questionId;
        @NotNull private List<String> answers;
    }
    @Getter
    @Setter
    public class AnswerResponse {
        private String code;
        private String message;
    }
}
