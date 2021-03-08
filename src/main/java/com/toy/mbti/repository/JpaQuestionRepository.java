package com.toy.mbti.repository;

import com.toy.mbti.domain.Question;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaQuestionRepository implements QuestionRepository {

    private final EntityManager em;

    public JpaQuestionRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<Question> findAll() {
        return em.createQuery("SELECT q FROM Question q",Question.class)
                .getResultList();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return Optional.ofNullable(em.find(Question.class, id));
    }
}
