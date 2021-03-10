package com.toy.mbti.controller;

import javax.validation.constraints.NotBlank;

public class ResultRequest {

    @NotBlank(message = "value must be provided")
    String value;

    public String getValue() {
        return value;
    }
}
