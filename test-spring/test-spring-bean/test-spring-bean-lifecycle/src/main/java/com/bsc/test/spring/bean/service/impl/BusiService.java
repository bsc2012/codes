package com.bsc.test.spring.bean.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.bsc.test.spring.bean.service.inf.IBusiService;

@Service
public class BusiService implements IBusiService, BeanNameAware, BeanFactoryAware, ApplicationContextAware,
		InitializingBean, DisposableBean {

	@Override
	public void query() {
		System.out.println(BusiService.class.getSimpleName() + ".query invoke");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println(BeanNameAware.class.getSimpleName() + ".setBeanName(String " + name + ") invoke");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println(
				BeanFactoryAware.class.getSimpleName() + ".setBeanFactory(BeanFactory " + beanFactory + ") invoke");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println(ApplicationContextAware.class.getSimpleName() + ".setApplicationContext(ApplicationContext "
				+ applicationContext + ") invoke");
	}

	@PostConstruct
	public void init() {
		System.out.println(PostConstruct.class.getSimpleName() + ".init invoke");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(InitializingBean.class.getSimpleName() + ".afterPropertiesSet() invoke");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println(PreDestroy.class.getSimpleName() + ".destroy() invoke");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(DisposableBean.class.getSimpleName() + ".destroy() invoke");
	}

}
