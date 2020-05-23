package com.argulusyn.codinage.persistence.dto;

import com.argulusyn.codinage.persistence.model.CourseType;
import com.argulusyn.codinage.persistence.model.DifficultyLevel;

import java.util.Set;

public class CreateCourseDto {
    private String name;
    private String description;
    private DifficultyLevel difficultyLevel;
    private CourseType courseType;
    private String previewImage;
    private Set<String> subjects;

    public CreateCourseDto(String name, String description, DifficultyLevel difficultyLevel, CourseType courseType, String previewImage, Set<String> subjects) {
        this.name = name;
        this.description = description;
        this.difficultyLevel = difficultyLevel;
        this.courseType = courseType;
        this.previewImage = previewImage;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }

    public Set<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<String> subjects) {
        this.subjects = subjects;
    }
}
