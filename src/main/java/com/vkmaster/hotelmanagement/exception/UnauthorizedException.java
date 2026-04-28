package com.vkmaster.hotelmanagement.exception;

public class UnauthorizedException extends RuntimeException{

    public  UnauthorizedException(String message){
        super(message);
    }
}
