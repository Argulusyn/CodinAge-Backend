package com.argulusyn.codinage.persistence.dto;

import com.argulusyn.codinage.persistence.model.sections.SectionType;

import java.util.List;

public class SectionDto {
    private Long id;
    private String title;
    private String description;
    protected SectionType type;
    private List<SubsectionDto> subsections;
    private List<String> options;
    private String correctOption;
    private String source;

    public SectionDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SectionType getType() {
        return type;
    }

    public void setType(SectionType type) {
        this.type = type;
    }

    public List<SubsectionDto> getSubsections() {
        return subsections;
    }

    public void setSubsections(List<SubsectionDto> subsections) {
        this.subsections = subsections;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
