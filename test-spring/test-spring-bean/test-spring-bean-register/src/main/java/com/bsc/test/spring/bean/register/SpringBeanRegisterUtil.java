package com.bsc.test.spring.bean.register;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanRegisterUtil {
	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static ConfigurableApplicationContext configurableContext = (ConfigurableApplicationContext) applicationContext;
	private static BeanDefinitionRegistry beanDefinitionRegistry = (DefaultListableBeanFactory) configurableContext
			.getBeanFactory();

	public static void registerBean(String beanId, String className) {
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(className);
		BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
		beanDefinitionRegistry.registerBeanDefinition(beanId, beanDefinition);
	}

	public static void unRegisterBean(String beanId) {
		beanDefinitionRegistry.removeBeanDefinition(beanId);
	}
	
	public static <T> T getBean(Class<T> requiredType){
		return applicationContext.getBean(requiredType);
	}

	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}
}
