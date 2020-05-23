package com.argulusyn.codinage.utils;

import com.argulusyn.codinage.persistence.dto.CourseDto;
import com.argulusyn.codinage.persistence.dto.GenericCourseDto;
import com.argulusyn.codinage.persistence.dto.SectionDto;
import com.argulusyn.codinage.persistence.dto.SubsectionDto;
import com.argulusyn.codinage.persistence.model.Course;
import com.argulusyn.codinage.persistence.model.sections.*;
import com.argulusyn.codinage.persistence.model.sections.subsections.ImageSubsection;
import com.argulusyn.codinage.persistence.model.sections.subsections.Subsection;
import com.argulusyn.codinage.persistence.model.sections.subsections.SubsectionType;
import com.argulusyn.codinage.persistence.model.sections.subsections.TextSubsection;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class CourseObjectMapper {
    public static CourseDto mapCourseToCourseDto(Course course) {
        return CourseDto.CourseDtoBuilder.aCourseDto()
                .withId(course.getId())
                .withName(course.getName())
                .withDescription(course.getDescription())
                .withPreviewImage(course.getPreviewImage())
                .withRating(course.getRating())
                .withDifficultyLevel(course.getDifficultyLevel())
                .withCourseType(course.getCourseType())
                .withSubjects(course.getSubjects())
                .withSections(course.getSections())
                .withNumberOfUsers(course.getUsers().size())
                .build();
    }

    public static Course mapCourseDtoToCourse(CourseDto courseDto) {
        return Course.CourseBuilder.aCourse()
                .withId(courseDto.getId())
                .withName(courseDto.getName())
                .withDescription(courseDto.getDescription())
                .withPreviewImage(courseDto.getPreviewImage())
                .withDifficultyLevel(courseDto.getDifficultyLevel())
                .withCourseType(courseDto.getCourseType())
                .withSubjects(courseDto.getSubjects())
                .withSections(courseDto.getSections())
                .build();
    }

    public static Course mapGenericCourseDtoToCourse(GenericCourseDto genericCourseDto) {
        List<Section> sections = mapSectionDtoListToSections(genericCourseDto.getSections());
        Course course = Course.CourseBuilder.aCourse()
                .withId(genericCourseDto.getId())
                .withName(genericCourseDto.getName())
                .withDescription(genericCourseDto.getDescription())
                .withPreviewImage(genericCourseDto.getPreviewImage())
                .withDifficultyLevel(genericCourseDto.getDifficultyLevel())
                .withCourseType(genericCourseDto.getCourseType())
                .withSubjects(genericCourseDto.getSubjects())
                .withSections(sections)
                .build();

        mapSectionsToCourse(course);
        return course;
    }

    private static void mapSectionsToCourse(Course course) {
        for (Section section : course.getSections()) {
            section.setCourse(course);
        }
    }

    public static List<Section> mapSectionDtoListToSections(List<SectionDto> sectionDtos) {
        return sectionDtos.stream().map(section -> {
            SectionType sectionType = section.getType();

            switch (sectionType) {
                case ARTICLE -> {
                    List<Subsection> subsections = mapSubsectionDtoListToSubsections(section.getSubsections());
                    ArticleSection articleSection = new ArticleSection(section.getTitle(), section.getDescription(), subsections);
                    articleSection.setId(section.getId());
                    mapSubsectionsToArticleSection(articleSection);
                    return articleSection;
                }
                case VIDEO -> {
                    return new VideoSection(section.getTitle(), section.getDescription(), section.getSource());
                }
                case QUESTION -> {
                    return new QuestionSection(section.getTitle(), section.getDescription(), section.getOptions(), section.getCorrectOption());
                }
                default -> {
                    return new ArticleSection();
                }
            }
        }).collect(Collectors.toList());
    }

    private static void mapSubsectionsToArticleSection(ArticleSection articleSection) {
        for (Subsection subsection : articleSection.getSubsections()) {
            subsection.setArticleSection(articleSection);
        }
    }

    public static List<Subsection> mapSubsectionDtoListToSubsections(List<SubsectionDto> subsectionDtos) {
        return subsectionDtos.stream().map(subsection -> {
            SubsectionType subsectionType = subsection.getType();

            switch (subsectionType) {
                case TEXT -> {
                    TextSubsection textSubsection = new TextSubsection(subsection.getContent());
                    textSubsection.setId(subsection.getId());
                    return textSubsection;
                }
                case IMAGE -> {
                    ImageSubsection imageSubsection = new ImageSubsection(subsection.getSource(), subsection.getCaption());
                    imageSubsection.setId(subsection.getId());
                    return imageSubsection;
                }
                default -> {
                    return new TextSubsection();
                }
            }
        }).collect(Collectors.toList());
    }
}
