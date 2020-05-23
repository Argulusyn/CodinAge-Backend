package com.argulusyn.codinage.services;

import com.argulusyn.codinage.persistence.dto.CourseDto;
import com.argulusyn.codinage.persistence.dto.CreateCourseDto;
import com.argulusyn.codinage.persistence.dto.GenericCourseDto;
import com.argulusyn.codinage.persistence.model.Course;
import com.argulusyn.codinage.persistence.model.sections.*;
import com.argulusyn.codinage.persistence.model.sections.subsections.ImageSubsection;
import com.argulusyn.codinage.persistence.model.sections.subsections.Subsection;
import com.argulusyn.codinage.persistence.model.sections.subsections.SubsectionType;
import com.argulusyn.codinage.persistence.model.sections.subsections.TextSubsection;
import com.argulusyn.codinage.persistence.repository.CourseRepository;
import com.argulusyn.codinage.utils.CourseObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Long createNewCourse(CreateCourseDto createCourseDto) {
        Course course = new Course();
        course.setName(createCourseDto.getName());
        course.setDescription(createCourseDto.getDescription());
        course.setCourseType(createCourseDto.getCourseType());
        course.setDifficultyLevel(createCourseDto.getDifficultyLevel());
        course.setPreviewImage(createCourseDto.getPreviewImage());
        course.setSubjects(createCourseDto.getSubjects());
        this.courseRepository.save(course);

        return course.getId();
    }

    public Course getCourseById(Long id) {
        return this.courseRepository.getOne(id);
    }

    public void saveCourse(Course course) {
        this.courseRepository.save(course);
    }

    public void updateCourse(Long id, GenericCourseDto genericCourseDto) {
        Course savedCourse = getCourseById(id);
        Course updatedCourse = CourseObjectMapper.mapGenericCourseDtoToCourse(genericCourseDto);
        updatedCourse.setTotalRating(savedCourse.getTotalRating());
        updatedCourse.setUsers(savedCourse.getUsers());
        saveCourse(updatedCourse);
    }

    public List<CourseDto> getAllCourseDtos() {
        List<Course> courses = this.courseRepository.findAll();
        return courses.stream().map(CourseObjectMapper::mapCourseToCourseDto).collect(Collectors.toList());
    }
}
