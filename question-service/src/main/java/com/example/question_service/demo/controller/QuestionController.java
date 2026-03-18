package com.example.question_service.demo.controller;



import com.example.question_service.demo.models.Question;
import com.example.question_service.demo.models.QuestionWrapper;
import com.example.question_service.demo.models.Response;
import com.example.question_service.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable("category") String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PostMapping("update")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }

    @PostMapping("delete")
    public ResponseEntity<String> deleteQuestion(@RequestBody Integer questionId){
        return questionService.deleteQuestion(questionId);
    }

    @GetMapping("create")
    public ResponseEntity<List<Integer>> createQuiz(@RequestParam String category, @RequestParam Integer numQ){
        return questionService.getQuestionIdsForQuiz(category,numQ);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(@RequestBody List<Integer> questions){
        return questionService.getQuestionsFromIds(questions);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }
}

