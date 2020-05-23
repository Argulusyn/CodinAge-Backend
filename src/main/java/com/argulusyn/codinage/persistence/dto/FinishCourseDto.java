package com.argulusyn.codinage.persistence.dto;

public class FinishCourseDto {
    private Long userId;
    private Long rating;

    public FinishCourseDto(Long userId, Long rating) {
        this.userId = userId;
        this.rating = rating;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
