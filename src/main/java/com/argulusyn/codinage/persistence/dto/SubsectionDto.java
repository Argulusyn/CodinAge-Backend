package com.argulusyn.codinage.persistence.dto;

import com.argulusyn.codinage.persistence.model.sections.subsections.SubsectionType;

public class SubsectionDto {
    private Long id;
    private String content;
    private String source;
    private String caption;
    protected SubsectionType type;

    public SubsectionDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public SubsectionType getType() {
        return type;
    }

    public void setType(SubsectionType type) {
        this.type = type;
    }
}
