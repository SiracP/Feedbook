package com.sirac.exception;

import lombok.Getter;

@Getter
public enum MessageType {
    NO_RECORD_EXIST("9001", "Kayıt Bulunamadı"),
    TOKEN_IS_EXPIRED("9002", "Token süresi bitti"),
    USERNAME_NOT_FOUND("9003","Kullanıcı adı bulunamadı"),
    USERNAME_OR_PASSWORD_INVALID("9004","Kullanıcı adı veya şifre hatalı"),
    REFRESH_TOKEN_NOT_FOUND("9005","Refresh token bulunamadı"),
    REFRESH_TOKEN_IS_EXPIRED("9006","Refresh tokenın süresi bitti"),
    RECORD_ALREADY_EXIST("9007", "Bu kayıt zaten var"),
    GENERAL_EXCEPTION("9999","Genel Hata");

    private String code;
    private String message;

    MessageType(String code, String message){
        this.code = code;
        this.message = message;
    }
}
