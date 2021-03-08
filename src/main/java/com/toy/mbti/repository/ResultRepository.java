package com.toy.mbti.repository;

import com.toy.mbti.domain.Result;

import java.util.Optional;

public interface ResultRepository {

    Optional<Result> findById(Long id);
}
