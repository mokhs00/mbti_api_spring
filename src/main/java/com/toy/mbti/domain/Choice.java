package com.toy.mbti.domain;

import javax.persistence.*;

@Entity
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    private String text;

    private String value;

    public Long getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }
}
