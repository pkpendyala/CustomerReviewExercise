package com.randstad.customerreview.exception;

public class ZeroRatingReviewException extends Exception{

	 // Parameterless Constructor
    public ZeroRatingReviewException() {}

    // Constructor that accepts a message
    public ZeroRatingReviewException(String message)
    {
       super(message);
    }

}
