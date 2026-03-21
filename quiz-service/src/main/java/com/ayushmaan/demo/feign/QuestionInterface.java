package com.ayushmaan.demo.feign;

import com.ayushmaan.demo.models.QuestionWrapper;
import com.ayushmaan.demo.models.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuestionInterface {
    @GetMapping("create")
    ResponseEntity<List<Integer>> createQuiz(@RequestParam String category, @RequestParam Integer numQ);

    @PostMapping("getQuestions")
    ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(@RequestBody List<Integer> questions);

    @PostMapping("getScore")
    ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
