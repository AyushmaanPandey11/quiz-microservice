package com.ayushmaan.demo.service;

import com.ayushmaan.demo.dao.QuestionDao;
import com.ayushmaan.demo.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }
}
