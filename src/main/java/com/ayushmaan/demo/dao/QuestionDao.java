package com.ayushmaan.demo.dao;


import com.ayushmaan.demo.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    Optional<List<Question>> findByCategory(String category);
}
