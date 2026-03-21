package com.ayushmaan.demo.service;

import com.ayushmaan.demo.dao.QuizDao;
import com.ayushmaan.demo.feign.QuestionInterface;
import com.ayushmaan.demo.models.QuestionWrapper;
import com.ayushmaan.demo.models.Quiz;
import com.ayushmaan.demo.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuestionInterface questionInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        try{
            List<Integer> questions = questionInterface.createQuiz(category,numQ).getBody();
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setNumQ(numQ);
            quiz.setQuestions(questions);
            quizDao.save(quiz);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer quizId) {
        try{
            Optional<Quiz> quiz = quizDao.findById(quizId);
            List<Integer> questionIds = quiz.orElseThrow().getQuestions();
            List<QuestionWrapper> questionWrapperList = questionInterface.getQuestionsFromIds(questionIds).getBody();
            assert questionWrapperList != null;
            return new ResponseEntity<>(questionWrapperList,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Integer> submitQuiz(Integer quizId, List<Response> responses) {
        try {
            Optional<Quiz> quiz = quizDao.findById(quizId);
            if( quiz.isEmpty() ){
                return new ResponseEntity<>(0,HttpStatus.BAD_REQUEST);
            }
            Integer correctAnswers = questionInterface.getScore(responses).getBody();
            return new ResponseEntity<>(correctAnswers,HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(0,HttpStatus.BAD_REQUEST);
    }
}
