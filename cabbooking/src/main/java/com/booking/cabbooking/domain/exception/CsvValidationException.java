package com.booking.cabbooking.domain.exception;

public class CsvValidationException extends RuntimeException{

    public CsvValidationException(String message){
        super(message);
    }
}
