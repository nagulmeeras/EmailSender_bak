package com.pramati.emailsender;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;

public class BeanFactory {
	private VelocityEngine velocityEngine;
	private VelocityContext velocityContext;
	private static BeanFactory beanFactory;
	
	private BeanFactory() {
	}
	@Bean
	public VelocityEngine getVelocityEngine() {
		if(velocityEngine == null){
			velocityEngine = new VelocityEngine();
		}
		return velocityEngine;
	}
	
	@Bean
	public VelocityContext getVelocityContext() {
		if(velocityContext == null){
			velocityContext = new VelocityContext();
		}
		return velocityContext;
	}
	public static BeanFactory getInstance(){
		if(beanFactory == null){
			beanFactory = new BeanFactory();
		}
		return beanFactory;
	}
	
}
