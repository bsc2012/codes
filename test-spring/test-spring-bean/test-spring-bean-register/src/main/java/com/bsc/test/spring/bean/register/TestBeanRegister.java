package com.bsc.test.spring.bean.register;

import com.bsc.test.spring.bean.service.impl.BusiService;
import com.bsc.test.spring.bean.service.inf.IBusiService;

public class TestBeanRegister {

	public static void main(String[] args) {
		SpringBeanRegisterUtil.registerBean("busiService", BusiService.class.getName());
		
		IBusiService busiService = SpringBeanRegisterUtil.getBean(IBusiService.class);
		
		busiService.query();
		
		SpringBeanRegisterUtil.unRegisterBean("busiService");
		
		busiService = SpringBeanRegisterUtil.getBean(IBusiService.class);
	}
}
