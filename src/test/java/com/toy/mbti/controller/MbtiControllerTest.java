package com.toy.mbti.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toy.mbti.domain.Result;
import com.toy.mbti.repository.QuestionRepository;
import com.toy.mbti.repository.RecordRepository;
import com.toy.mbti.repository.ResultRepository;
import com.toy.mbti.service.RecordService;
import com.toy.mbti.service.ResultService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MbtiController.class)
class MbtiControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    ResultRepository resultRepository;
    @MockBean
    RecordRepository recordRepository;
    @MockBean
    QuestionRepository questionRepository;
    @MockBean
    RecordService recordService;
    @MockBean
    ResultService resultService;

    public Result expectedResult;

    @BeforeEach
    void setup() {
        this.expectedResult = new Result(0L, "A",
                "A TITLE",
                "A TEXT",
                null,
                new Result(0L, "B",
                        "B TITLE",
                        "B TEXT",
                        null,
                        new Result(),
                        new Result()),
                new Result(0L, "C",
                        "C TITLE",
                        "C TEXT",
                        null,
                        new Result(),
                        new Result())
        );

    }

    @Test
    void result() throws Exception {
        when(this.resultService.result(any(ResultRequest.class)))
                .then(invocation -> {
                    ResultRequest request = invocation.getArgument(0, ResultRequest.class);
                    return new Result(this.expectedResult.getId(),
                            this.expectedResult.getValue(),
                            this.expectedResult.getTitle(),
                            this.expectedResult.getText(),
                            this.expectedResult.getImgPath(),
                            this.expectedResult.getPositive(),
                            this.expectedResult.getNegative()
                    );
                });


        ResultRequest request = new ResultRequest();
        request.setValue("A");

        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(request);

        this.mvc.perform(post("/mbti/result")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value("A"))
                .andExpect(jsonPath("$.positive.value").value("B"))
                .andExpect(jsonPath("$.negative.value").value("C"));

    }
}