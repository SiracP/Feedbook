package com.sirac.dto.dto_insert_update;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoEntryIU {

    @NotNull
    private String content;

    private Long likeCount;

    @NotNull
    private Long userId;

    @NotNull
    private Long topicId;
}
