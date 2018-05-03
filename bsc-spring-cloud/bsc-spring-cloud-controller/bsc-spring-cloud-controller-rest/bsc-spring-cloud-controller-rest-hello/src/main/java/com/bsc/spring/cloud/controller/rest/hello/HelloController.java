package com.bsc.spring.cloud.controller.rest.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bsc.spring.cloud.inf.feign.hello.IHelloService;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello(@RequestParam String name){
		System.out.println("hello service provider");
		return "hello " + name;
	}
	
	@Autowired(required=false)
    private RestTemplate restTemplate;
	
    @RequestMapping(value = "/ribbonHello")
    public String ribbonHello(@RequestParam String name){
    	System.out.println("ribbonHello service consumer");
        return restTemplate.getForObject("http://SERVICE-HELLO/hello?name="+name,String.class);
    }
    
    @Autowired(required=false)
    private IHelloService helloService;
    
    @RequestMapping(value = "/feignHello")
    public String feignHello(@RequestParam String name){
    	System.out.println("feignHello service consumer");
        return helloService.hello(name);
    }
}
