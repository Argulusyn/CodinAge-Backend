package com.argulusyn.codinage.persistence.repository;

import com.argulusyn.codinage.persistence.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
