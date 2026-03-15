package com.ayushmaan.demo.service;

import com.ayushmaan.demo.dao.QuestionDao;
import com.ayushmaan.demo.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public Optional<List<Question>> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question){
        try{
            questionDao.save(question);
            return "Success";
        } catch (Error e){
            return "Failed";
        }
    }

    public String updateQuestion(Question question){
        try{
            questionDao.save(question);
            return "Success";
        } catch (Error e){
            return "Failed";
        }
    }

    public String deleteQuestion(Integer quesId){
        try{
            questionDao.deleteById(quesId);
            return "Success";
        } catch (Error e){
            return "Failed";
        }
    }
}
