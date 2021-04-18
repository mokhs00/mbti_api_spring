package com.toy.mbti.repository;


import com.toy.mbti.domain.Record;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaRecordRepository implements RecordRepository{

    private final EntityManager em;

    public JpaRecordRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Long count() {
        return (Long) em.createQuery("SELECT COUNT(*) FROM record")
                .getSingleResult();
    }

    @Override
    public Optional<Record> findById(Long id) {
        return Optional.ofNullable(em.find(Record.class, id));
    }

    @Override
    public Record record(Record record) {
        em.persist(record);
        return record;
    }

    @Override
    public List<Record> findAll() {
        return em.createQuery("SELECT r FROM Record r",Record.class)
                .getResultList();
    }
}
