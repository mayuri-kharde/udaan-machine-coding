package com.demo.udaan.models;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface QuestionRequestResponse {
    @Getter
    @Setter
    public class QuestionRequest {

        @NotNull private String desc;
        private List<String> choices;
    }

    @Getter
    @Setter
    public class QuestionResponse {
        private String code;
        private String message;
        private Long id;
    }
}
