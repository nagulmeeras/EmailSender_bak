package com.pramati.EmailSender;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Component;

@Component
public class TemplateHandler {
	// private String workLocation;
	// private boolean isEmployee;
	// private boolean isTicketChecked;
	private VelocityEngine velocityEngine;

	public TemplateHandler(){
		velocityEngine = new VelocityEngine();
	}

	public Template getTemplate(String workLocation, boolean isEmployee, boolean isTicketChecked) {
		Template template = null;
		try {
			template = velocityEngine.getTemplate("src/main/resources/templates/template1/template1.vm");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return template;
	}

	public void populateData(Template template) {
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("requestId", 1);
		velocityContext.put("employeeName", "Nagulmeera");
		StringWriter stringWriter = new StringWriter();
		try {
			template.merge(velocityContext, stringWriter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(stringWriter.toString());
	}
}
