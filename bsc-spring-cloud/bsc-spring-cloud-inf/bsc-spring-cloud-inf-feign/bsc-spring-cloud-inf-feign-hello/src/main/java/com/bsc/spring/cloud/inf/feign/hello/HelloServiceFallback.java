package com.bsc.spring.cloud.inf.feign.hello;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements IHelloService {

	@Override
	public String hello(String name) {
		return "sorry " + name;
	}

}
