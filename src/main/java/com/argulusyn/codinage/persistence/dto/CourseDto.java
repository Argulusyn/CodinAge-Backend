package com.argulusyn.codinage.persistence.dto;

import com.argulusyn.codinage.persistence.model.*;
import com.argulusyn.codinage.persistence.model.sections.Section;

import java.util.List;
import java.util.Set;

public class CourseDto {
    private Long id;
    private String name;
    private String description;
    private String previewImage;
    private Float rating = 0F;
    private DifficultyLevel difficultyLevel;
    private CourseType courseType;
    private Set<String> subjects;
    private List<Section> sections;
    private Integer numberOfUsers;

    public CourseDto() {
    }

    public CourseDto(Long id, String name, String description, String previewImage, Float rating, DifficultyLevel difficultyLevel, CourseType courseType, Set<String> subjects, List<Section> sections) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.previewImage = previewImage;
        this.rating = rating;
        this.difficultyLevel = difficultyLevel;
        this.courseType = courseType;
        this.subjects = subjects;
        this.sections = sections;
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

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public Integer getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(Integer numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public static final class CourseDtoBuilder {
        private Long id;
        private String name;
        private String description;
        private String previewImage;
        private Float rating = 0F;
        private DifficultyLevel difficultyLevel;
        private CourseType courseType;
        private Set<String> subjects;
        private List<Section> sections;
        private Integer numberOfUsers;

        private CourseDtoBuilder() {
        }

        public static CourseDtoBuilder aCourseDto() {
            return new CourseDtoBuilder();
        }

        public CourseDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CourseDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CourseDtoBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public CourseDtoBuilder withPreviewImage(String previewImage) {
            this.previewImage = previewImage;
            return this;
        }

        public CourseDtoBuilder withRating(Float rating) {
            this.rating = rating;
            return this;
        }

        public CourseDtoBuilder withDifficultyLevel(DifficultyLevel difficultyLevel) {
            this.difficultyLevel = difficultyLevel;
            return this;
        }

        public CourseDtoBuilder withCourseType(CourseType courseType) {
            this.courseType = courseType;
            return this;
        }

        public CourseDtoBuilder withSubjects(Set<String> subjects) {
            this.subjects = subjects;
            return this;
        }

        public CourseDtoBuilder withSections(List<Section> sections) {
            this.sections = sections;
            return this;
        }

        public CourseDtoBuilder withNumberOfUsers(Integer numberOfUsers) {
            this.numberOfUsers = numberOfUsers;
            return this;
        }

        public CourseDto build() {
            CourseDto courseDto = new CourseDto();
            courseDto.setId(id);
            courseDto.setName(name);
            courseDto.setDescription(description);
            courseDto.setPreviewImage(previewImage);
            courseDto.setRating(rating);
            courseDto.setDifficultyLevel(difficultyLevel);
            courseDto.setCourseType(courseType);
            courseDto.setSubjects(subjects);
            courseDto.setSections(sections);
            courseDto.setNumberOfUsers(numberOfUsers);
            return courseDto;
        }
    }
}
