package com.toy.mbti.domain;

import javax.persistence.*;

@Entity
public class Result {
    @Id
    @GeneratedValue
    @Column(name = "result_id")
    private Long id;

    private String value;
    private String title;
    private String text;

    @Column(name = "img_path")
    private String imgPath;

    @OneToOne @JoinColumn(name = "positive_id")
    private Result positive;
    @OneToOne @JoinColumn(name = "negative_id")
    private Result negative;






}
