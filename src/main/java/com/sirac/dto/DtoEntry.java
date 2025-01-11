package com.sirac.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoEntry extends DtoBase {

    private DtoTopic topic;

    private DtoUser user;

    private String content;

    private Long likeCount;
}
