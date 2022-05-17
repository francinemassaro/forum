package br.com.itau.forum.controller.form;

import br.com.itau.forum.model.Course;
import br.com.itau.forum.model.Topic;
import br.com.itau.forum.repository.CourseRepository;

public class TopicForm {

    private String title;
    private String message;
    private String courseName;

    public Topic convert(CourseRepository courseRepository) {
        Course course = courseRepository.findByName(courseName);
        return new Topic(title, message, course);
    }

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}