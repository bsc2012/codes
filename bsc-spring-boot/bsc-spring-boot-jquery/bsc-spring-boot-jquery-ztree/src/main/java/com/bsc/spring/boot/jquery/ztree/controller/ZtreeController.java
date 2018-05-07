package com.bsc.spring.boot.jquery.ztree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ZtreeController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
}
