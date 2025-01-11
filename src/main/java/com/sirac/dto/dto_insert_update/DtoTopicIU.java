package com.sirac.dto.dto_insert_update;

import com.sirac.model.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoTopicIU {

    @NotNull
    private Long userId;

    @NotNull
    private String title;

    private Long entryCount;
}
