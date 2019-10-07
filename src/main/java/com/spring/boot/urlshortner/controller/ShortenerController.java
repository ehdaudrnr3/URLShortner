package com.spring.boot.urlshortner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.urlshortner.service.URLShortenerService;

@RestController
public class ShortenerController {
	
	@Autowired
	private URLShortenerService service;
	
	@RequestMapping(value = "/shortener", method = RequestMethod.GET)
	public String shortener(
			@RequestParam(name = "url") String url) {
		return service.getShortURL(url);
	}
	
	@RequestMapping(value = "/")
	public ModelAndView index(ModelAndView view) {
		view.setViewName("index");
		return view;
	}
}
