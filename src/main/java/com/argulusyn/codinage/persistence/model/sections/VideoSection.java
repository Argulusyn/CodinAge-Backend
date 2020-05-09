package com.argulusyn.codinage.persistence.model.sections;

import javax.persistence.Entity;

@Entity
public class VideoSection extends Section {
    private String source;

    public VideoSection() {
        this.type = SectionType.VIDEO;
    }

    public VideoSection(String title, String description, String source) {
        super(title, description);
        this.type = SectionType.VIDEO;
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
