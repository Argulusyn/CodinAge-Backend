package com.argulusyn.codinage.persistence.model;

import com.argulusyn.codinage.persistence.model.sections.Section;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String previewImage;
    private Long totalRating = 0L;
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

    @ManyToMany(targetEntity = User.class)
    @JoinTable(
            name = "user_course",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
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

    public Integer getNumberOfUsers() {
        return this.users.size();
    }

    public Float getRating() {
        if (this.getTotalRating() == 0L || this.getNumberOfUsers() == 0) {
            return 0F;
        }

        BigDecimal result = new BigDecimal(this.getTotalRating() / this.getNumberOfUsers());
        BigDecimal roundedResult = result.setScale(1, RoundingMode.HALF_UP);
        return roundedResult.floatValue();
    }

    public Long getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(Long totalRating) {
        this.totalRating = totalRating;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public static final class CourseBuilder {
        Set<User> users;
        private Long id;
        private String name;
        private String description;
        private String previewImage;
        private Long totalRating = 0L;
        private DifficultyLevel difficultyLevel;
        private CourseType courseType;
        private Set<String> subjects;
        private List<Section> sections;

        private CourseBuilder() {
        }

        public static CourseBuilder aCourse() {
            return new CourseBuilder();
        }

        public CourseBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CourseBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CourseBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public CourseBuilder withPreviewImage(String previewImage) {
            this.previewImage = previewImage;
            return this;
        }

        public CourseBuilder withTotalRating(Long totalRating) {
            this.totalRating = totalRating;
            return this;
        }

        public CourseBuilder withDifficultyLevel(DifficultyLevel difficultyLevel) {
            this.difficultyLevel = difficultyLevel;
            return this;
        }

        public CourseBuilder withCourseType(CourseType courseType) {
            this.courseType = courseType;
            return this;
        }

        public CourseBuilder withSubjects(Set<String> subjects) {
            this.subjects = subjects;
            return this;
        }

        public CourseBuilder withSections(List<Section> sections) {
            this.sections = sections;
            return this;
        }

        public CourseBuilder withUsers(Set<User> users) {
            this.users = users;
            return this;
        }

        public Course build() {
            Course course = new Course();
            course.setId(id);
            course.setName(name);
            course.setDescription(description);
            course.setPreviewImage(previewImage);
            course.setTotalRating(totalRating);
            course.setDifficultyLevel(difficultyLevel);
            course.setCourseType(courseType);
            course.setSubjects(subjects);
            course.setSections(sections);
            course.setUsers(users);
            return course;
        }
    }
}
