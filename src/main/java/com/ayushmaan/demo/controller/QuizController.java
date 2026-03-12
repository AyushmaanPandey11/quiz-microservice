package com.ayushmaan.demo.controller;


import com.ayushmaan.demo.models.Question;
import com.ayushmaan.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuizController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("debug")
    public String debugQuestions() {
        List<Question> list = questionService.getAllQuestions();
        return "Number of questions found: " + list.size();
    }
}
