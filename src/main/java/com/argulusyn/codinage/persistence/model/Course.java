package com.argulusyn.codinage.persistence.model;

import com.argulusyn.codinage.persistence.model.sections.Section;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private String previewImage;
    private Float rating = 0F;
    private DifficultyLevel difficultyLevel;
    private CourseType courseType;

    @ElementCollection
    @CollectionTable(
            name = "course_subjects",
            joinColumns = @JoinColumn(name = "course_id")
    )
    private Set<String> subjects;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Section> sections;

    @ManyToMany(mappedBy = "courses")
    Set<User> users;

    public Course() {
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
