package com.greek.hefesto.config.exception;


public class HefestoException extends RuntimeException{

    private final String errorCode;
    private final transient Object[] arguments;

    public HefestoException (String clientErrorCode, Object... args){
        super(clientErrorCode);
        this.arguments = args;
        this.errorCode = clientErrorCode;
    }

    public HefestoException (Throwable cause, String clientErrorCode, Object... args){
        super(clientErrorCode, cause);
        this.arguments = args;
        this.errorCode = clientErrorCode;
    }

}