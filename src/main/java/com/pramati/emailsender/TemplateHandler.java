package com.pramati.emailsender;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Component;

import com.pramati.emailsender.beans.TravelInfo;
import com.pramati.emailsender.beans.Traveller;
import com.pramati.emailsender.beans.Trip;
import com.pramati.emailsender.util.PropertiesUtil;

@Component
public class TemplateHandler {
	private VelocityEngine velocityEngine;

	public TemplateHandler() {
		velocityEngine = BeanFactory.getInstance().getVelocityEngine();
	}

	public Template getTemplate( String templateType , String triggerName) throws Exception {
		
		Template template = velocityEngine
				.getTemplate(PropertiesUtil.getPropertyValue("app.file.templates.path") + "/"+templateType+"/"+triggerName+".vm");
		return template;
	}

	public String[] populateData(Template template , TravelInfo travelInfo) throws Exception{
		VelocityContext velocityContext = BeanFactory.getInstance().getVelocityContext();

		velocityContext.put("requestId", travelInfo.getRequestId());
		velocityContext.put("employeeName", travelInfo.getEmployee().getName());
		velocityContext.put("workLocation", travelInfo.getWorkLocation());
		
		velocityContext.put("tripsDetails", travelInfo.getTrips());
		velocityContext.put("travellersDetails", travelInfo.getTravellers());
		velocityContext.put("otherDetails", travelInfo.getEmployee());
		velocityContext.put("fecilities", travelInfo.getFecilites());
		
		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);
		String content = stringWriter.toString();
		String mailContetns[] = content.split("MailBody:");
		return mailContetns;
	}
	
	public String populateSubjectData(Template template) throws Exception{
		VelocityContext velocityContext = BeanFactory.getInstance().getVelocityContext();
		velocityContext.put("requestId", "12603");
		
		
		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);
		return stringWriter.toString();
	}
	
	
}
