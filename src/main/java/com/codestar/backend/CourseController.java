package com.codestar.backend;
import  org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class CourseController {

    private List<Course> courses = new ArrayList<>();

    public CourseController(){
        courses.add(new Course(1L, "cours de java", "base de la POO", "contenu du cours ..."));
        courses.add(new Course(2L, "cours de java", "base de la POO", "contenu du cours ..."));
        courses.add(new Course(3L, "cours de java", "base de la POO", "contenu du cours ..."));
    }


    @GetMapping
    public List<Course> getAllCourses(){
        return courses;
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id){
        return courses.stream().filter(c->c.getId().equals(id)).findFirst().orElse(null);
    }
}
