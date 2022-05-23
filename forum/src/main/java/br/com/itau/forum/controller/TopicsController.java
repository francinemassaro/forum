package br.com.itau.forum.controller;

import br.com.itau.forum.controller.dto.DetailTopicDto;
import br.com.itau.forum.controller.dto.TopicDto;
import br.com.itau.forum.controller.form.TopicForm;
import br.com.itau.forum.controller.form.UpdateTopicForm;
import br.com.itau.forum.model.Topic;
import br.com.itau.forum.repository.CourseRepository;
import br.com.itau.forum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<DetailTopicDto> detailTopic(@PathVariable Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isPresent()){
            return ResponseEntity.ok(new DetailTopicDto(topic.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<TopicDto> register(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriBuilder) {
        Topic topic = form.convert(courseRepository);
        topicRepository.save(topic);

        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDto(topic));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDto> update(@PathVariable Long id, @RequestBody @Valid UpdateTopicForm form) {
        Topic topic = form.update(id, topicRepository);

        return ResponseEntity.ok(new TopicDto(topic));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        topicRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}