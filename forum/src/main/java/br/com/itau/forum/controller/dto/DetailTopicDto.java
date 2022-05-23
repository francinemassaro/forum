package br.com.itau.forum.controller.dto;

import br.com.itau.forum.model.StatusTopic;
import br.com.itau.forum.model.Topic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetailTopicDto {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private StatusTopic status;
    private String userName;
    private List<AnswerDto> answers;

    public DetailTopicDto(Topic topic){
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.creationDate = topic.getCreationDate();
        this.status = topic.getStatus();
        this.userName = topic.getUser().getName();
        this.answers = new ArrayList<>();
        this.answers.addAll(topic.getAnswers().stream().map(AnswerDto::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public StatusTopic getStatus() {
        return status;
    }

    public String getUserName() {
        return userName;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }
}
