package com.toy.mbti.domain;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
