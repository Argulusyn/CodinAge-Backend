package com.argulusyn.codinage.persistence.dto;

import com.argulusyn.codinage.persistence.model.CourseType;
import com.argulusyn.codinage.persistence.model.DifficultyLevel;

import java.util.List;
import java.util.Set;

public class GenericCourseDto {
    private Long id;
    private String name;
    private String description;
    private String previewImage;
    private Float rating = 0F;
    private DifficultyLevel difficultyLevel;
    private CourseType courseType;
    private Set<String> subjects;
    private List<SectionDto> sections;
    private Integer numberOfUsers;

    public GenericCourseDto() {
    }

    public GenericCourseDto(Long id, String name, String description, String previewImage, Float rating, DifficultyLevel difficultyLevel, CourseType courseType, Set<String> subjects, List<SectionDto> sections, Integer numberOfUsers) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.previewImage = previewImage;
        this.rating = rating;
        this.difficultyLevel = difficultyLevel;
        this.courseType = courseType;
        this.subjects = subjects;
        this.sections = sections;
        this.numberOfUsers = numberOfUsers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
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

    public Set<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<String> subjects) {
        this.subjects = subjects;
    }

    public List<SectionDto> getSections() {
        return sections;
    }

    public void setSections(List<SectionDto> sections) {
        this.sections = sections;
    }

    public Integer getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(Integer numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }
}
