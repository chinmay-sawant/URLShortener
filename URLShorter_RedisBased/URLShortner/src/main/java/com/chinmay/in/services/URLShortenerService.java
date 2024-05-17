package com.chinmay.in.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class URLShortenerService {

	@Value("${server.address}")
	String address;

	@Value("${server.port}")
	String port;

	private Map<String, String> shortToLongMap;
	private Map<String, String> longToShortMap;
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int SHORT_URL_LENGTH = 6;

	public URLShortenerService() {
		shortToLongMap = new HashMap<>();
		longToShortMap = new HashMap<>();
	}

	public String shortenURL(String longURL) {
		if (longToShortMap.containsKey(longURL)) { 
			return "http://" + address + ":" +  port + "/re?key=" + longToShortMap.get(longURL);
		} else {
			String shortURL = generateShortURL();
			shortToLongMap.put(shortURL, longURL);
			longToShortMap.put(longURL, shortURL);
			return "http://" + address + ":" +  port + "/re?key=" + shortURL;
		}
	}

	public String expandURL(String shortURL) {
		return shortToLongMap.getOrDefault(shortURL, null);
	}

	private String generateShortURL() {
		StringBuilder shortURLBuilder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < SHORT_URL_LENGTH; i++) {
			int randomIndex = random.nextInt(CHARACTERS.length());
			shortURLBuilder.append(CHARACTERS.charAt(randomIndex));
		}
		return shortURLBuilder.toString();
	}
}
