package com.argulusyn.codinage.controllers;

import com.argulusyn.codinage.persistence.dto.CourseDto;
import com.argulusyn.codinage.persistence.dto.CreateCourseDto;
import com.argulusyn.codinage.persistence.dto.GenericCourseDto;
import com.argulusyn.codinage.persistence.model.Course;
import com.argulusyn.codinage.services.CourseService;
import com.argulusyn.codinage.utils.CourseObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/courses")
public class CoursesController {
    private final CourseService courseService;

    @Autowired
    public CoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    CourseDto getCourse(@PathVariable("id") Long id) {
        Course course = this.courseService.getCourseById(id);
        return CourseObjectMapper.mapCourseToCourseDto(course);
    }

    @PatchMapping("/{id}")
    ResponseEntity patchCourse(@PathVariable Long id, @RequestBody GenericCourseDto genericCourseDto) {
        this.courseService.updateCourse(id, genericCourseDto);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    ResponseEntity<Long> createCourse(@RequestBody CreateCourseDto createCourseDto) {
        Long newCourseId = this.courseService.createNewCourse(createCourseDto);
        return new ResponseEntity<>(newCourseId, HttpStatus.CREATED);
    }

    @GetMapping
    List<CourseDto> getAllCourses() {
        return this.courseService.getAllCourseDtos();
    }
}
