package com.toy.mbti.domain;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String text;


    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getText() {
        return text;
    }
}
