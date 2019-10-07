package com.spring.boot.urlshortner.exception;

public class ShortenerURLException extends RuntimeException{
	private static final long serialVersionUID = -6838731394888544718L;

	public ShortenerURLException(String message) {
		super(message);
	}
}
