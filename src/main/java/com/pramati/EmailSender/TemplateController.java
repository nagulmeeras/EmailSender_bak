package com.pramati.EmailSender;

import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class TemplateController {
	
	private TemplateHandler  templateHandler;
	private VelocityEngine velocityEngine;
	
	public TemplateController(){
		this.velocityEngine = new VelocityEngine();
	}
	public TemplateHandler getTemplateHandler() {
		return templateHandler;
	}
	@Autowired
	public void setTemplateHandler(TemplateHandler templateHandler) {
		this.templateHandler = templateHandler;
	}
	
	public void loadTemplate(boolean isTicketChecked , String workLocation , boolean isEmployee ){
		Template template = templateHandler.getTemplate(workLocation, isEmployee, isTicketChecked);
		templateHandler.populateData(template );
	}
}
