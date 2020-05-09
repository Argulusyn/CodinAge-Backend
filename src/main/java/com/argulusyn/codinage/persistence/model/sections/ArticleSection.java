package com.argulusyn.codinage.persistence.model.sections;

import com.argulusyn.codinage.persistence.model.sections.subsections.Subsection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ArticleSection extends Section {
    @OneToMany(mappedBy = "articleSection", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Subsection> subsections;

    public ArticleSection() {
        this.type = SectionType.ARTICLE;
    }

    public ArticleSection(String title, String description, List<Subsection> subsections) {
        super(title, description);
        this.type = SectionType.ARTICLE;
        this.subsections = subsections;
    }

    public List<Subsection> getSubsections() {
        return subsections;
    }

    public void setSubsections(List<Subsection> subsections) {
        this.subsections = subsections;
    }
}
