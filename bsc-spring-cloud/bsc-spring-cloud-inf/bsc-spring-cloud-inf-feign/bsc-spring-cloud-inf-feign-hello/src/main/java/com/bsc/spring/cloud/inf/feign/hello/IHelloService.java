package com.bsc.spring.cloud.inf.feign.hello;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="service-hello")
public interface IHelloService {

	@GetMapping(value = "/hello")
	String hello(@RequestParam(value = "name") String name);
}
