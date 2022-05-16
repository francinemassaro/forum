package br.com.itau.forum.controller;

import br.com.itau.forum.controller.dto.TopicDto;
import br.com.itau.forum.controller.form.TopicForm;
import br.com.itau.forum.model.Topic;
import br.com.itau.forum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/topicos")
public class TopicsController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    public List<TopicDto> list(String courseName) {
        if (courseName == null) {
            List<Topic> topics = topicRepository.findAll();
            return TopicDto.converter(topics);

        } else {
            List<Topic> topics = topicRepository.findByCourseNameIgnoreCase(courseName);
            return TopicDto.converter(topics);
        }
    }

    @PostMapping
    @RequestMapping("/cadastro")
    public void cadastrar(@RequestBody TopicForm form) {
     /*to continue*/
    }
}
