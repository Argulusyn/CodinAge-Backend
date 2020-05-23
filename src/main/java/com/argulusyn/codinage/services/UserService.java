package com.argulusyn.codinage.services;

import com.argulusyn.codinage.persistence.model.User;
import com.argulusyn.codinage.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public User findUserById(Long id) {
        return this.userRepository.getOne(id);
    }
}
