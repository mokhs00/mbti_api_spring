package com.toy.mbti.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

public class Record {

    @Id @GeneratedValue @Column(name = "record_id")
    private Long id;

    @ManyToOne @JoinColumn(name = "result_id")
    private Result result;

    private LocalDate day;

}
