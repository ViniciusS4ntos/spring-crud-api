package com.vinicius.spring_crud_api.infrastructure.exceptions;

public class EmailExistenteException extends RuntimeException{
    public EmailExistenteException(String message){super(message);}
    public EmailExistenteException(String message, Throwable throwable){super(message,throwable);}
}
