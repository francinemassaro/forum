package br.com.itau.forum.controller;

import javax.validation.Valid;
import br.com.itau.forum.controller.dto.TopicDto;
import br.com.itau.forum.controller.form.TopicForm;
import br.com.itau.forum.model.Topic;
import br.com.itau.forum.repository.CourseRepository;
import br.com.itau.forum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/topics")
public class TopicsController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<TopicDto> list(String courseName) {
        if (courseName == null) {
            List<Topic> topics = topicRepository.findAll();
            return TopicDto.convert(topics);

        } else {
            List<Topic> topics = topicRepository.findByCourseNameIgnoreCase(courseName);
            return TopicDto.convert(topics);
        }
    }

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<TopicDto> register(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriBuilder) {
        Topic topic = form.convert(courseRepository);
        topicRepository.save(topic);

        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDto(topic));
    }
}