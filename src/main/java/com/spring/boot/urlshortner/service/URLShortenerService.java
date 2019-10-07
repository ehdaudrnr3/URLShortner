package com.spring.boot.urlshortner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.boot.urlshortner.models.URL;
import com.spring.boot.urlshortner.repository.URLRepository;
import com.spring.boot.urlshortner.util.URLShortener;

@Service
public class URLShortenerService {
	
	@Autowired
	private URLRepository repository;
	
	public String getShortURL(String key) {
		URL url = repository.findByKey(key);
		if(url == null) {
			URLShortener urlShortener = new URLShortener();
			String shortUrl = urlShortener.convertURL(key);
			repository.save(new URL(key, shortUrl));
			return shortUrl;
		} 
		return url.getValue();
	}
	
	public String getShortURL(String key, int length) {
		URL url = repository.findByKey(key);
		if(url == null) {
			URLShortener urlShortener = new URLShortener();
			String shortUrl = urlShortener.convertURL(length, key);
			repository.save(new URL(key, shortUrl));
			return shortUrl;
		} 
		return url.getValue();
	}
}
