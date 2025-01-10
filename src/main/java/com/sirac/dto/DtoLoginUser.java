package com.sirac.dto;

import lombok.Data;

@Data
public class DtoLoginUser extends DtoBase{

    private String username;

    private String password;
}
