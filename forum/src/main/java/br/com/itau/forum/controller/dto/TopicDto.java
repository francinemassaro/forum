package br.com.itau.forum.controller.dto;

import br.com.itau.forum.model.Topic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicDto {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;

    public TopicDto(Topic topico){
        this.id = topico.getId();
        this.title = topico.getTitle();
        this.message = topico.getMessage();
        this.creationDate = topico.getCreationDate();
    }

    public Topic convert(){
        return new Topic();
    }

    public static List<TopicDto> convert(List<Topic> topicos){
        return topicos.stream().map(TopicDto::new).collect(Collectors.toList());
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
}