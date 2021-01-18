package com.toy.mbti.domain;

import javax.persistence.*;

@Entity
public class Choice {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    private String text;

    private String value;


}
