package com.toy.mbti.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne @JoinColumn(name = "result_id")
    private Result result;

    private LocalDateTime day;

    public Long getId() {
        return id;
    }

    public Result getResult() {
        return result;
    }

    public LocalDateTime getDay() {
        return day;
    }
}
