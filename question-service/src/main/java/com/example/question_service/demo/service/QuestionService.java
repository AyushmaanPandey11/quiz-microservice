package com.example.question_service.demo.service;

import com.example.question_service.demo.dao.QuestionDao;
import com.example.question_service.demo.models.Question;
import com.example.question_service.demo.models.QuestionWrapper;
import com.example.question_service.demo.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
       try{
           return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
       }catch (Exception e){
          e.printStackTrace();
       }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question){
        try{
            questionDao.save(question);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        } catch (Error e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateQuestion(Question question){
        try{
            questionDao.save(question);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        } catch (Error e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(Integer quesId){
        try{
            questionDao.deleteById(quesId);
            return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
        } catch (Error e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Integer>> getQuestionIdsForQuiz(String category, Integer numQ) {
        return new ResponseEntity<>(questionDao.findRandomQuestionByCategory(category,numQ),HttpStatus.OK);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(List<Integer> questions) {
        try {
            List<QuestionWrapper> questionWrapperList = new ArrayList<>();
            for( Integer id: questions ){
                Question q = questionDao.findById(id).get();
                QuestionWrapper qw = new QuestionWrapper();
                qw.setId(q.getId());
                qw.setQuestionTitle(q.getQuestionTitle());
                qw.setOption1(q.getOption1());
                qw.setOption2(q.getOption2());
                qw.setOption3(q.getOption3());
                qw.setOption4(q.getOption4());
                questionWrapperList.add(qw);
            }
            return new ResponseEntity<>(questionWrapperList,HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        try{
            int right =0;
            for(Response response: responses){
                Question question = questionDao.findById(response.getId()).get();
                if( response.getResponse().equals(question.getRightAnswer()) ){
                    right++;
                }
            }
            return new ResponseEntity<>(right,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(0,HttpStatus.BAD_REQUEST);
    }
}
