package com.law.util;

public class LawyerException extends Exception {
	private static final long serialVersionUID = 1L;
	public LawyerException(String source){
		super("LawyerException: "+source);
	}
}
