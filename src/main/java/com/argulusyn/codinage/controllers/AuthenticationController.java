package com.argulusyn.codinage.controllers;

import com.argulusyn.codinage.persistence.dto.LoginUserDto;
import com.argulusyn.codinage.persistence.dto.LoginUserResponseDto;
import com.argulusyn.codinage.persistence.dto.RegisterUserDto;
import com.argulusyn.codinage.persistence.model.User;
import com.argulusyn.codinage.persistence.model.UserRole;
import com.argulusyn.codinage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.SecureRandom;

@RestController
@CrossOrigin
@RequestMapping("/authentication")
public class AuthenticationController {
    private UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    ResponseEntity registerUser(@Valid @RequestBody RegisterUserDto registerUserDto) {
        User user = this.userService.findUserByUsername(registerUserDto.getUsername());

        if (user != null) {
            return new ResponseEntity("ALREADY_EXIST", HttpStatus.BAD_REQUEST);
        }

        String encodedPassword = encodePassword(registerUserDto.getPassword());
        User newUser = new User.UserBuilder(registerUserDto.getUsername(), encodedPassword)
                .email(registerUserDto.getEmail())
                .role(UserRole.USER)
                .firstName(registerUserDto.getFirstName())
                .lastName(registerUserDto.getLastName())
                .build();

        userService.saveUser(newUser);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    ResponseEntity login(@Valid @RequestBody LoginUserDto loginUserDto) {
        User user = this.userService.findUserByUsername(loginUserDto.getUsername());

        if (user == null) {
            return new ResponseEntity("NO_SUCH_USER", HttpStatus.NOT_FOUND);
        }

        if (passwordEncoder().matches(loginUserDto.getPassword(), user.getPassword())) {
            LoginUserResponseDto responseLoginDto = new LoginUserResponseDto(user.getId(), user.getRole());
            return new ResponseEntity(responseLoginDto, HttpStatus.ACCEPTED);
        }

        return new ResponseEntity("USERNAME_OR_PASSWORD_INCORRECT", HttpStatus.UNAUTHORIZED);
    }

    String encodePassword(String password) {
        return passwordEncoder().encode(password);
    }

    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }
}
