package com.argulusyn.codinage.persistence.model.sections.subsections;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TextSubsection extends Subsection {
    @Column(columnDefinition = "TEXT")
    private String content;

    public TextSubsection() {
        this.type = SubsectionType.TEXT;
    }

    public TextSubsection(String content) {
        this.type = SubsectionType.TEXT;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
