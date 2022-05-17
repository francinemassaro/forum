package br.com.itau.forum.repository;

import br.com.itau.forum.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    List<Topic> findByCourseNameIgnoreCase(String nameCourse);
}