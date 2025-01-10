package com.sirac.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class RootEntity <T>{

    private  Integer status;

    private T data;

    private String errorMessage;

    public static <T> RootEntity<T> ok (T data){
        RootEntity<T> rootEntity = new RootEntity<>();
        rootEntity.setStatus(200);
        rootEntity.setData(data);
        rootEntity.setErrorMessage(null);
        return rootEntity;
    }

    public static <T> RootEntity<T> error (String errorMessage){
        RootEntity<T> rootEntity = new RootEntity<>();
        rootEntity.setStatus(500);
        rootEntity.setData(null);
        rootEntity.setErrorMessage(errorMessage);
        return rootEntity;
    }
}
