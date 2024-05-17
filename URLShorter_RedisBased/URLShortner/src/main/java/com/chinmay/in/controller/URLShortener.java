package com.chinmay.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinmay.in.dto.RequestDTO;
import com.chinmay.in.dto.ResponseDTO;
import com.chinmay.in.services.RedisService;
import com.chinmay.in.services.URLShortenerService;

@RestController
@RequestMapping("/shortit")
public class URLShortener {

	@Autowired
	URLShortenerService urlShortenerService;
	
	@Autowired
	RedisService redisService;
	
	@PostMapping
	public ResponseDTO shortit(@RequestBody RequestDTO requestDTO) {
		return new ResponseDTO(urlShortenerService.shortenURL(requestDTO.getUrl()));
	}
	
	
}
