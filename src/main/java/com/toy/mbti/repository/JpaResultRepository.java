package com.toy.mbti.repository;


import com.toy.mbti.domain.Result;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class JpaResultRepository implements ResultRepository {

    private final EntityManager em;

    public JpaResultRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Result> findById(Long id) {
        return Optional.ofNullable(em.find(Result.class, id));
    }

    @Override
    public Optional<Result> findByValue(String value) {
        return Optional.ofNullable(
                em.createQuery("SELECT r FROM Result r WHERE value = :value", Result.class)
                .setParameter("value", value)
                .getSingleResult()
        );
    }
}
