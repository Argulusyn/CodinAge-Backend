package com.argulusyn.codinage.persistence.model.sections;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import java.util.List;

@Entity
public class QuestionSection extends Section {
    @ElementCollection
    @CollectionTable(
            name = "question_options",
            joinColumns = @JoinColumn(name = "question_id")
    )
    private List<String> options;

    private String correctOption;

    public QuestionSection() {
        this.type = SectionType.QUESTION;
    }

    public QuestionSection(String title, String description, List<String> options, String correctOption) {
        super(title, description);
        this.type = SectionType.QUESTION;
        this.options = options;
        this.correctOption = correctOption;
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
}
