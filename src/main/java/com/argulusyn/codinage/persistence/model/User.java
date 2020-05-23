package com.argulusyn.codinage.persistence.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String avatar;
    private UserRole role;
    private Long scores = 0L;

    @ManyToMany(targetEntity = Course.class, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "user_course",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private Set<Course> courses;

    public User() {
    }

    public User(String username, String email, String password, String firstName, String lastName, String avatar, UserRole role, Long scores, Set<Course> courses) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
        this.role = role;
        this.scores = scores;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Long getScores() {
        return scores;
    }

    public void setScores(Long scores) {
        this.scores = scores;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public static final class UserBuilder {
        private Long id;
        private String username;
        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private String avatar;
        private UserRole role;
        private Long scores = 0L;
        private Set<Course> courses;

        public UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder withAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public UserBuilder withRole(UserRole role) {
            this.role = role;
            return this;
        }

        public UserBuilder withScores(Long scores) {
            this.scores = scores;
            return this;
        }

        public UserBuilder withCourses(Set<Course> courses) {
            this.courses = courses;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setAvatar(avatar);
            user.setRole(role);
            user.setScores(scores);
            user.setCourses(courses);
            return user;
        }
    }
}
