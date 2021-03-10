package com.toy.mbti.controller;


import com.toy.mbti.domain.*;
import com.toy.mbti.repository.QuestionRepository;
import com.toy.mbti.repository.RecordRepository;
import com.toy.mbti.repository.ResultRepository;
import com.toy.mbti.service.ResultService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mbti")
public class MbtiController {

    private final ResultRepository resultRepository;
    private final RecordRepository recordRepository;
    private final QuestionRepository questionRepository;
    private final ResultService resultService;


    public MbtiController(ResultRepository resultRepository, RecordRepository recordRepository, QuestionRepository questionRepository, ResultService resultService) {
        this.resultRepository = resultRepository;
        this.recordRepository = recordRepository;
        this.questionRepository = questionRepository;
        this.resultService = resultService;
    }

    @GetMapping("question")
    public List<Question> getQuestions(){
        List<Question> questions = questionRepository.findAll();
        return questions;
    }


    @GetMapping("{value}")
    public ResultDTO getResult(@PathVariable String value){
        Result result = resultRepository.findByValue(value).orElse(null);
        if(result == null)
            return null;

        ResultDTO resultDTO = new ResultDTO(result);
        return resultDTO;
    }

    @PostMapping("result")
    public ResultDTO result(@Valid ResultRequest request){
        String value = request.getValue();
        ResultDTO resultDTO = resultService.result(value);
        return resultDTO;
    }

    // TODO : add getRecords RecordResult{"count" : #, "records" : []}
//    @GetMapping("record")
//    public List<Record> getRecords(){
//        return recordRepository.findAll();
//    }

}
