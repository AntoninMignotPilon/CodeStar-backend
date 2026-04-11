package com.codestar.backend.controller;
import com.codestar.backend.dto.ApiResponseDto;
import com.codestar.backend.model.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import  org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*")
public class CourseController {

    private List<Course> courses = new ArrayList<>();

    public CourseController(){
        courses.add(new Course(1L, "cours de java", "base de la POO", "contenu du cours ..."));
        courses.add(new Course(2L, "cours de java", "base de la POO", "contenu du cours ..."));
        courses.add(new Course(3L, "cours de java", "base de la POO", "contenu du cours ..."));
    }


    @GetMapping
    public ResponseEntity<ApiResponseDto<List<Course>>> getAllCourses(){
        return ResponseEntity.ok(new ApiResponseDto<>(true, "Cours récuperés", courses));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Course>> getCourseById(@PathVariable Long id){
        return courses.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(course -> ResponseEntity.ok(new ApiResponseDto<>(true, "Cours recupere", course)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponseDto<>(false, "Cours introuvable", null)));
    }
}
