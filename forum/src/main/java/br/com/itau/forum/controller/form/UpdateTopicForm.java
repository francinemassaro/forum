package br.com.itau.forum.controller.form;

import br.com.itau.forum.model.Topic;
import br.com.itau.forum.repository.TopicRepository;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;

public class UpdateTopicForm {
    @NotNull
    @NotEmpty
    private String title;
    @NotNull
    @NotEmpty
    private String message;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Topic update(Long id, TopicRepository topicRepository) {
        Topic topic = topicRepository.getById(id);
        topic.setTitle(this.title);
        topic.setMessage(this.message);
        return topic;
    }
}
