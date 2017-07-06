package com.randstad.customerreview.exception;

public class CurseWordException extends Exception {
	
	 // Parameterless Constructor
    public CurseWordException() {}

    // Constructor that accepts a message
    public CurseWordException(String message)
    {
       super(message);
    }

}
