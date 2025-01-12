package com.sirac.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoEntry extends DtoBase {

    private String content;

    private Long likeCount;

    private DtoUser user;

    private DtoTopic topic;
}
