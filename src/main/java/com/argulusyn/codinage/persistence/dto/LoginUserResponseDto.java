package com.argulusyn.codinage.persistence.dto;

import com.argulusyn.codinage.persistence.model.UserRole;

public class LoginUserResponseDto {
    private Long id;
    private UserRole role;

    public LoginUserResponseDto(Long id, UserRole role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
