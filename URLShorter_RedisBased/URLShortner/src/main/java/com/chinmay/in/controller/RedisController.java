package com.chinmay.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.chinmay.in.dto.RequestDTO;
import com.chinmay.in.dto.ResponseDTO;
import com.chinmay.in.services.RedisService;
import com.chinmay.in.services.URLShortenerService;

@RestController
@RequestMapping("/re")
public class RedisController {
	
	@Value("${server.address}")
	String address;

	@Value("${server.port}")
	String port;

    @Autowired
    private RedisService redisService;
    
    @Autowired
    URLShortenerService urlShortenerService;

//    @PostMapping("/set")
//    public void setValue(@RequestParam String key, @RequestParam String value) {
//        redisService.setValue(key, value);
//    }

//    @GetMapping
//    public String getValue(@RequestParam String key) {
//        return redisService.getValue("http://" + address + ":" +  port + "/redis?key=" +key);
//    }
    @GetMapping
    public  ResponseEntity<?> redirect(@RequestParam String key) {
        String url = redisService.getValue("http://" + address + ":" +  port + "/re?key=" +key);
        if (url != null) {
        	return ResponseEntity.status(HttpStatus.FOUND).header("Location", url).build();
        } else {
            // Handle case where key does not exist in Redis
//            return new RedirectView("/redis/error");
        	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Key does not exist in Redis.");
        }
    }

    @GetMapping("/error")
    public String error() {
        return "Error: Key does not exist in Redis.";
    }

	@PostMapping
	public ResponseDTO shortitredis(@RequestBody RequestDTO requestDTO) {
		return  new ResponseDTO(redisService.setValue(requestDTO.getUrl(),urlShortenerService.shortenURL(requestDTO.getUrl()),Long.parseLong(requestDTO.getTtl())));
	}
}