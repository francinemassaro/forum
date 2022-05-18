package br.com.itau.forum.controller.form;

import br.com.itau.forum.model.Course;
import br.com.itau.forum.model.Topic;
import br.com.itau.forum.repository.CourseRepository;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;

public class TopicForm {
    @NotNull
    @NotEmpty
    private String title;
    @NotNull
    @NotEmpty
    private String message;
    @NotNull
    @NotEmpty
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