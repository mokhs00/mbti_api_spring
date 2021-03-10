package com.toy.mbti.service;

import com.toy.mbti.domain.Record;
import com.toy.mbti.domain.Result;
import com.toy.mbti.domain.ResultDTO;
import com.toy.mbti.repository.RecordRepository;
import com.toy.mbti.repository.ResultRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResultService {

    private final ResultRepository resultRepository;
    private final RecordRepository recordRepository;

    public ResultService(ResultRepository resultRepository, RecordRepository recordRepository) {
        this.resultRepository = resultRepository;
        this.recordRepository = recordRepository;
    }

    @Transactional
    public ResultDTO result(String value){
        Result result = resultRepository.findByValue(value).orElse(null);
        if (result == null){
            return null;
        }
        return record(result);
    }


    public ResultDTO record(Result result){
        Record record = new Record(result);
        recordRepository.record(record);
        ResultDTO resultDTO = new ResultDTO(
                result
        );
        return resultDTO;
    }


}
