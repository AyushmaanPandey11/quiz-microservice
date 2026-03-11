package com.ayushmaan.demo.controller;


import jakarta.persistence.SqlResultSetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("question")
public class QuizController {

    @GetMapping("allQuestions")
    public String getAllQuestions(){
        return "Hi From Server";
    }
}
