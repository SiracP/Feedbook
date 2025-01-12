package com.sirac.dto;


import com.sirac.model.Entry;
import com.sirac.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoLike extends DtoBase {

    private DtoUser user;

    private DtoEntry entry;
}
