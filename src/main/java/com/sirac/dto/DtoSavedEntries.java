package com.sirac.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoSavedEntries extends DtoBase{

    private DtoUser user;

    private DtoEntry entry;
}
