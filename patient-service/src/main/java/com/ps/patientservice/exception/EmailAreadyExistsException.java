package com.ps.patientservice.exception;

public class EmailAreadyExistsException extends RuntimeException
{

    public EmailAreadyExistsException(String message)
    {
        super(message);
    }
}
