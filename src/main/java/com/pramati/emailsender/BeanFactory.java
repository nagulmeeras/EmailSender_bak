package com.pramati.emailsender;

import org.apache.velocity.VelocityContext;
<<<<<<< HEAD
import org.springframework.context.annotation.Bean;

public class BeanFactory {
=======
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;

public class BeanFactory {
	private VelocityEngine velocityEngine;
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
	private VelocityContext velocityContext;
	private static BeanFactory beanFactory;
	
	private BeanFactory() {
	}
<<<<<<< HEAD
=======
	@Bean
	public VelocityEngine getVelocityEngine() {
		if(velocityEngine == null){
			velocityEngine = new VelocityEngine();
		}
		return velocityEngine;
	}
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
	
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
