package com.pramati.emailsender;

import java.io.StringWriter;
<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pramati.emailsender.appconfig.ApplicationConfig;
import com.pramati.emailsender.beans.TravelInfo;
=======
import org.springframework.stereotype.Component;

import com.pramati.emailsender.beans.TravelInfo;
import com.pramati.emailsender.beans.Traveller;
import com.pramati.emailsender.beans.Trip;
import com.pramati.emailsender.util.PropertiesUtil;
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd

@Component
public class TemplateHandler {
	private VelocityEngine velocityEngine;
<<<<<<< HEAD
	
	@Autowired
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		System.out.println("in velocityEngine");
		this.velocityEngine = velocityEngine;
	}

	public Template getTemplate(String templateType, String triggerName) throws Exception {

		Template template = velocityEngine
				.getTemplate(ApplicationConfig.getPropertyValue("app.file.templates.path") + "/" + triggerName);
		return template;
	}

	public String[] populateData(Template template, TravelInfo travelInfo) throws Exception {
=======

	public TemplateHandler() {
		velocityEngine = BeanFactory.getInstance().getVelocityEngine();
	}

	public Template getTemplate( String templateType , String triggerName) throws Exception {
		
		Template template = velocityEngine
				.getTemplate(PropertiesUtil.getPropertyValue("app.file.templates.path") + "/"+templateType+"/"+triggerName+".vm");
		return template;
	}

	public String[] populateData(Template template , TravelInfo travelInfo) throws Exception{
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
		VelocityContext velocityContext = BeanFactory.getInstance().getVelocityContext();

		velocityContext.put("requestId", travelInfo.getRequestId());
		velocityContext.put("employeeName", travelInfo.getEmployee().getName());
		velocityContext.put("workLocation", travelInfo.getWorkLocation());
<<<<<<< HEAD

		velocityContext.put("tripsDetails", travelInfo.getTrips());
		velocityContext.put("travellersDetails", travelInfo.getTravellers());
		velocityContext.put("otherDetails", travelInfo.getEmployee());
		velocityContext.put("facilities", travelInfo.getFacilites());

=======
		
		velocityContext.put("tripsDetails", travelInfo.getTrips());
		velocityContext.put("travellersDetails", travelInfo.getTravellers());
		velocityContext.put("otherDetails", travelInfo.getEmployee());
		velocityContext.put("fecilities", travelInfo.getFecilites());
		
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);
		String content = stringWriter.toString();
		String mailContetns[] = content.split("MailBody:");
		return mailContetns;
	}
<<<<<<< HEAD

	public String populateSubjectData(Template template) throws Exception {
		VelocityContext velocityContext = BeanFactory.getInstance().getVelocityContext();
		velocityContext.put("requestId", "12603");

=======
	
	public String populateSubjectData(Template template) throws Exception{
		VelocityContext velocityContext = BeanFactory.getInstance().getVelocityContext();
		velocityContext.put("requestId", "12603");
		
		
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);
		return stringWriter.toString();
	}
<<<<<<< HEAD

=======
	
	
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
}
