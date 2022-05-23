package br.com.itau.forum.controller.dto;

import br.com.itau.forum.model.Answer;

import java.time.LocalDateTime;

public class AnswerDto {

    private Long id;
    private String message;
    private LocalDateTime creationDate;
    private String userName;

    public AnswerDto(Answer answer) {
        this.id = answer.getId();
        this.message = answer.getMessage();
        this.creationDate = answer.getCreationDate();
        this.userName = answer.getUser().getName();
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getUserName() {
        return userName;
    }
}
