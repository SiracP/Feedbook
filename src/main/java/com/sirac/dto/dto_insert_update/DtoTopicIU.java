package com.sirac.dto.dto_insert_update;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoTopicIU {

    @NotNull
    private String title;

    private Long entryCount;

    @NotNull
    private Long userId;
}
