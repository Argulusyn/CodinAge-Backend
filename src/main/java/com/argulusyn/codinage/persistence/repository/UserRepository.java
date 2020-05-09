package com.argulusyn.codinage.persistence.repository;

import com.argulusyn.codinage.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
