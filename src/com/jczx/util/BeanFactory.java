package com.jczx.util;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactory {
	private static final Logger logger = Logger.getLogger(BeanFactory.class);
	private static final String APPLICATIONCONTEXT_PATH = "applicationContext.xml";
	static ApplicationContext ac;
	static {
		ac = new ClassPathXmlApplicationContext(APPLICATIONCONTEXT_PATH);
	}
	public static ApplicationContext getApplicationContext(){
		return ac;
	}

	public static Object getBean(String beanName){
		return ac.getBean(beanName);
	}
}