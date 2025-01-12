package com.sirac.dto.dto_insert_update;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoLikeIU {

    @NotNull
    private Long entryId;

    @NotNull
    private Long userId;
}
