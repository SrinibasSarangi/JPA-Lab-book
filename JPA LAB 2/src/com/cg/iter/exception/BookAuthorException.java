package com.cg.iter.exception;

@SuppressWarnings("serial")
public class BookAuthorException extends Exception {
	
	public BookAuthorException()
	{
		super("Some error occured");
	}
	public BookAuthorException(String message)
	{
		super(message);
	}
}
