package com.ayushmaan.demo.controller;


import com.ayushmaan.demo.models.Question;
import com.ayushmaan.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable("category") String category){
        Optional<List<Question>> list = questionService.getQuestionsByCategory(category);
        return list.orElse(null);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PostMapping("update")
    public String updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }

    @PostMapping("delete")
    public String deleteQuestion(@RequestBody Integer questionId){
        return questionService.deleteQuestion(questionId);
    }
}
