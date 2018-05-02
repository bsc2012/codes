package com.bsc.test.spring.bean.post.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(BeanPostProcessor.class.getSimpleName() + ".postProcessBeforeInitialization(Object " + bean + ",String " + beanName + ") invoke");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(BeanPostProcessor.class.getSimpleName() + ".postProcessAfterInitialization(Object " + bean + ",String " + beanName + ") invoke");
		return bean;
	}

}
