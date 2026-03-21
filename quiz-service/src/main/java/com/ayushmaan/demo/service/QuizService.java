package com.ayushmaan.demo.service;

import com.ayushmaan.demo.dao.QuizDao;
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
    private QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        try{
            List<Question> questions = questionDao.findRandomQuestionByCategory(category,numQ);
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
            List<Question> questions = quiz.get().getQuestions();
            List<QuestionWrapper> questionWrapperList = new ArrayList<>();
            for( Question q : questions ){
                QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
                questionWrapperList.add(qw);
            }
            return new ResponseEntity<>(questionWrapperList,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Integer> submitQuiz(Integer quizId, List<Response> responses) {
        try {
            int correctAnswers =0;
            Optional<Quiz> quiz = quizDao.findById(quizId);
            List<Question> questions = quiz.orElseThrow().getQuestions();
            for( Response response : responses ){
                Optional<Question> question = questions.stream().filter(q -> q.getId().equals(response.getId())).findFirst();
                if( question.get().getRightAnswer().equals(response.getResponse()) ){
                    correctAnswers++;
                }
            }
            return new ResponseEntity<>(correctAnswers,HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(0,HttpStatus.BAD_REQUEST);
    }
}
