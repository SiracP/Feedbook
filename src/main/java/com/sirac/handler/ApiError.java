package com.sirac.handler;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<E> {

    private Integer status;

    private Exception<E> exception;
}
