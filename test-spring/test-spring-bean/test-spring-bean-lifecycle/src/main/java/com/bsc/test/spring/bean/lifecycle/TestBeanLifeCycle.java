package com.bsc.test.spring.bean.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bsc.test.spring.bean.service.inf.IBusiService;

public class TestBeanLifeCycle {
	public static void main(String[] args) {
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		IBusiService busiService = applicationContext.getBean(IBusiService.class);
		busiService.query();
		applicationContext.close();
	}
}
