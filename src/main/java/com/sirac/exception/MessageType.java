package com.sirac.exception;

import lombok.Getter;

@Getter
public enum MessageType {
    NO_RECORD_EXIST("9001", "Kayıt Bulunamadı"),
    GENERAL_EXCEPTION("9999","Genel Hata");

    private String code;
    private String message;

    MessageType(String code, String message){
        this.code = code;
        this.message = message;
    }
}
