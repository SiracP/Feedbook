package com.sirac.handler;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exception<E> {

    private  String path;

    private Date createTime;

    private String hostName;

    private E message;
}
