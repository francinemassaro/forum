package br.com.itau.forum.repository;

import br.com.itau.forum.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    Page<Topic> findByCourseNameIgnoreCase(String nameCourse, Pageable pageable);
}