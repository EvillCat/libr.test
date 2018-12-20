package com.evillcat.libr.test.controller;

import lombok.Data;

@Data
public class Response<T> {

    private String status;

    private T data;

    private String message;
}
