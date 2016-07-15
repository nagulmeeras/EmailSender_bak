package com.pramati.emailsender;

import java.util.HashMap;

import org.apache.velocity.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pramati.emailsender.beans.TravelInfo;

@Component
public class TemplateController {

	private TemplateHandler templateHandler;
	public TemplateHandler getTemplateHandler() {
		return templateHandler;
	}

	@Autowired
	public void setTemplateHandler(TemplateHandler templateHandler) {
		this.templateHandler = templateHandler;
	}

	public HashMap<String, String> loadTemplate(String triggerName , String workLocation , TravelInfo travelInfo) throws Exception {
		HashMap<String, String> contentMap = new HashMap<String, String>();
		Template bodyTemplate = templateHandler.getTemplate( "body",
				triggerName);
		Template subjectTemplate = templateHandler.getTemplate("subject",
				triggerName);
		String mailContent[] = templateHandler.populateData(bodyTemplate ,travelInfo);
//		for (int i = 0; i < mailContent.length; i++) {
//			System.out.println(mailContent[i]);
//			
//			System.out.println("====================");
//		}
//		
		System.out.println(mailContent[1].replace("MailBody:", ""));
		System.out.println("=============================");
		System.out.println(mailContent[0].replace("MailSubject:", ""));
		
		contentMap.put("body",mailContent[1].replace("MailBody:", ""));
		
		contentMap.put("subject", mailContent[0].replace("MailSubject:", ""));

		return contentMap;
	}
	public String getTriggerName(String requestType , String recieverType , boolean isEmployee){
		String triggerName = requestType;
		if(recieverType.equalsIgnoreCase("TravelDesk")){
			if(isEmployee)
				triggerName += "_"+recieverType+"_Employee";
			else
				triggerName += "_"+recieverType+"_NonEmployee";
		}else if(recieverType.equalsIgnoreCase("TravelAgent")){
			if(isEmployee)
				triggerName += "_"+recieverType+"_Employee";
			else
				triggerName += "_"+recieverType+"_NonEmployee";
		}else if(recieverType.equalsIgnoreCase("EditRequest")){
			if(isEmployee)
				triggerName += "_"+recieverType+"_Employee";
			else
				triggerName += "_"+recieverType+"_NonEmployee";
		}else{
			triggerName += "_"+recieverType;
		}
		return triggerName;
	}
}
