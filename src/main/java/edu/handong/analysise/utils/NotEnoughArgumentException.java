package edu.handong.analysise.utils;

public class NotEnoughArgumentException extends Exception {


	public NotEnoughArgumentException() {
		super("Not Enough Argument!");
	}
	
	public NotEnoughArgumentException(String message) {
		super(message);
	}

}
