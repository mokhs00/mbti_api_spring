package com.toy.mbti.domain;

import javax.persistence.*;

@Entity
public class Question {


    @Id
    @GeneratedValue
    @Column(name = "question_id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    private String text;

}
