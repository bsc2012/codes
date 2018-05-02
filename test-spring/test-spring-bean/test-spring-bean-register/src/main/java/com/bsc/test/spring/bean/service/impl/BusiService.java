package com.bsc.test.spring.bean.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

import com.bsc.test.spring.bean.service.inf.IBusiService;

@Service
public class BusiService implements IBusiService{

	@PostConstruct
	public void init(){
		System.out.println(PostConstruct.class.getSimpleName() + ".init invoke");
	}
	
	@Override
	public void query() {
		System.out.println(BusiService.class.getSimpleName() + ".query invoke");
	}

	@PreDestroy
	public void destroy() {
		System.out.println(PreDestroy.class.getSimpleName() + ".destroy invoke");
	}
}
