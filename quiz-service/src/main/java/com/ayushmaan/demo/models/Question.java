package com.ayushmaan.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_title")
    private String questionTitle;

    @Column(name = "option1")
    private String option1;

    @Column(name = "option2")
    private String option2;

    @Column(name = "option3")
    private String option3;

    @Column(name = "option4")
    private String option4;

    @Column(name = "right_answer")
    private String rightAnswer;

    @Column(name = "difficultylevel")
    private String difficultyLevel;

    @Column(name = "category")
    private String category;

    public Integer getId() { return id; }
    public String getQuestionTitle() { return questionTitle; }
    public String getOption1() { return option1; }
    public String getOption2() { return option2; }
    public String getOption3() { return option3; }
    public String getOption4() { return option4; }
    public String getRightAnswer() { return rightAnswer; }
    public String getDifficultyLevel() { return difficultyLevel; }
    public String getCategory() { return category; }
}