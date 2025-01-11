package com.sirac.dto;

import lombok.Data;

@Data
public class DtoTopic extends DtoBase {

    private DtoUser user;

    private String title;

    private long entryCount;
}
