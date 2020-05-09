package com.argulusyn.codinage.persistence.model.sections.subsections;

import com.argulusyn.codinage.persistence.model.sections.ArticleSection;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public abstract class Subsection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article_section_id")
    @JsonBackReference
    private ArticleSection articleSection;

    @Transient
    protected SubsectionType type;

    public SubsectionType getType() {
        return type;
    }
}
