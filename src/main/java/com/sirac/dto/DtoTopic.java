package com.sirac.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoTopic extends DtoBase {

    private String title;

    private Long entryCount;

    private DtoUser user;
}
