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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArticleSection getArticleSection() {
        return articleSection;
    }

    public void setArticleSection(ArticleSection articleSection) {
        this.articleSection = articleSection;
    }

    public void setType(SubsectionType type) {
        this.type = type;
    }
}
