package com.toy.mbti.service;

import com.toy.mbti.controller.RecordResponse;
import com.toy.mbti.domain.Record;
import com.toy.mbti.domain.RecordVO;
import com.toy.mbti.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordService {

    private final RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public RecordResponse getRecords() {
        List<Record> records = recordRepository.findAll();

        List<RecordVO> collect = records.stream()
                .map(record -> new RecordVO(record.getResult().getValue(), record.getDay()))
                .collect(Collectors.toList());
        RecordResponse recordResponse = new RecordResponse(collect);

        return recordResponse;
    }
}
