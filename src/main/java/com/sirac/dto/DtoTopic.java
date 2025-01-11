package com.sirac.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoTopic extends DtoBase {

    private DtoUser user;

    private String title;

    private Long entryCount;
}
