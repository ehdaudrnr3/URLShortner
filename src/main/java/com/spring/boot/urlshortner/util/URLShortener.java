package com.spring.boot.urlshortner.util;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.spring.boot.urlshortner.exception.ShortenerURLException;

public class URLShortener {

	private static final String domain = "ggo.ok/";
	private char characterCodes[];
	private Random rand;
	private int length;

	public URLShortener() {
		length = 8;
		rand = new Random();
		characterCodes = new char[62];
		for (int i = 0; i < characterCodes.length; i++) {
			int code = 0;
			if (i < 10) {
				code = i + 48;
			} else if (i > 9 && i < 36) {
				code = i + 55;
			} else {
				code = i + 61;
			}
			characterCodes[i] = (char) code;
		}
	}

	public String convertURL(String longURL) {
		return this.convertURL(this.length, longURL);
	}
	
	public String convertURL(int length, String longURL) {
		this.setLength(length);
		if (longURL.isEmpty()) {
			throw new ShortenerURLException("invalid URL");
		}
		longURL = this.sanitizeURL(longURL);
		return domain+"/"+this.generateURL(longURL);
	}

	private String generateURL(String longURL) {
		StringBuilder URLBulider = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int randomValue = rand.nextInt(62);
			URLBulider.append(characterCodes[randomValue]);
		}
		return URLBulider.toString();
	}

	private String sanitizeURL(String url) {
		if (url.substring(0, 7).equals("http://")) {
			url = url.substring(7);
		}
		if (url.substring(0, 8).equals("https://")) {
			url = url.substring(8);
		}
		if (url.charAt(url.length() - 1) == '/')
			url = url.substring(0, url.length() - 1);

		return url;
	}
	
	public void setLength(int length) {
		this.length = length;
	}

}
