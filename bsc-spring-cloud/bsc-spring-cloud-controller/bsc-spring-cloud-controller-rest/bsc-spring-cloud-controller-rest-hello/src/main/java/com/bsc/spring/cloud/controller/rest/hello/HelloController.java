package com.bsc.spring.cloud.controller.rest.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello(@RequestParam String name){
		System.out.println("hello service provider");
		return "hello " + name;
	}
	
	
	@Autowired(required=false)
    RestTemplate restTemplate;
	
    @RequestMapping(value = "/sayHello")
    public String sayHello(@RequestParam String name){
    	System.out.println("hello service consumer");
        return restTemplate.getForObject("http://SERVICE-HELLO/hello?name="+name,String.class);
    }
}
