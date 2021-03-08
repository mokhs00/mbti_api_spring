package com.toy.mbti.controller;


import com.toy.mbti.domain.Choice;
import com.toy.mbti.domain.Question;
import com.toy.mbti.domain.Result;
import com.toy.mbti.repository.QuestionRepository;
import com.toy.mbti.repository.RecordRepository;
import com.toy.mbti.repository.ResultRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mbti")
public class MbtiController {

    private final ResultRepository resultRepository;
    private final RecordRepository recordRepository;
    private final QuestionRepository questionRepository;

    public MbtiController(ResultRepository resultRepository, RecordRepository recordRepository, QuestionRepository questionRepository) {
        this.resultRepository = resultRepository;
        this.recordRepository = recordRepository;
        this.questionRepository = questionRepository;
    }

    @GetMapping("question")
    public List<Question> getQuestions(){
        List<Question> questions = questionRepository.findAll();
        return questions;
    }


    // TODO : result

    // TODO : record




}
