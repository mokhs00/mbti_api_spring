package com.toy.mbti.controller;

import javax.validation.constraints.NotBlank;

public class ResultRequest {

    @NotBlank(message = "value must be provided")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
