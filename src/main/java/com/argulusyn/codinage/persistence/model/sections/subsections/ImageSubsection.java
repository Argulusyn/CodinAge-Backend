package com.argulusyn.codinage.persistence.model.sections.subsections;

import javax.persistence.Entity;

@Entity
public class ImageSubsection extends Subsection {
    private String source;
    private String caption;

    public ImageSubsection() {
        this.type = SubsectionType.IMAGE;
    }

    public ImageSubsection(String source, String caption) {
        this.type = SubsectionType.IMAGE;
        this.source = source;
        this.caption = caption;
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
}
