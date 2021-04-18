package com.toy.mbti.controller;


import com.toy.mbti.domain.Question;
import com.toy.mbti.domain.Result;
import com.toy.mbti.repository.QuestionRepository;
import com.toy.mbti.repository.RecordRepository;
import com.toy.mbti.repository.ResultRepository;
import com.toy.mbti.service.RecordService;
import com.toy.mbti.service.ResultService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mbti")
public class MbtiController {

    private final ResultRepository resultRepository;
    private final RecordRepository recordRepository;
    private final QuestionRepository questionRepository;
    private final RecordService recordService;
    private final ResultService resultService;


    public MbtiController(ResultRepository resultRepository, RecordRepository recordRepository, QuestionRepository questionRepository, RecordService recordService, ResultService resultService) {
        this.resultRepository = resultRepository;
        this.recordRepository = recordRepository;
        this.questionRepository = questionRepository;
        this.recordService = recordService;
        this.resultService = resultService;
    }

    @GetMapping("question")
    public List<Question> getQuestions() {
        List<Question> questions = questionRepository.findAll();
        return questions;
    }


    @GetMapping("{value}")
    public ResultResponse getResult(@PathVariable String value) {
        Result result = resultRepository.findByValue(value).orElse(null);
        if (result == null)
            return null;

        ResultResponse resultResponse = new ResultResponse(result);
        return resultResponse;
    }

    @PostMapping("result")
    public ResultResponse result(@Valid @RequestBody ResultRequest request) {
        Result result = resultService.result(request);
        ResultResponse resultResponse = new ResultResponse(result);
        return resultResponse;
    }

    @GetMapping("record")
    public RecordResponse getRecords() {
        RecordResponse response = recordService.getRecords();
        return response;
    }

}
