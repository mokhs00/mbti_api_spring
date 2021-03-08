package com.toy.mbti.repository;

import com.toy.mbti.domain.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository {

    List<Question> findAll();
    Optional<Question> findById(Long id);
}
