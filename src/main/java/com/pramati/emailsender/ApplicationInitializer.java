package com.pramati.emailsender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.pramati.emailsender.beans.Mail;
import com.pramati.emailsender.beans.TravelInfo;
import com.pramati.emailsender.util.PropertiesUtil;
import com.pramati.emailsender.util.SendMail;

@EnableAutoConfiguration
@Component
@ComponentScan
public class ApplicationInitializer {

	private static TemplateController templateController;
	private static SendMail sendMail;
	private static DataParser dataParser;

	public TemplateController getTemplateController() {
		return templateController;
	}

	@Autowired
	public void setSendMail(SendMail sendMail) {
		this.sendMail = sendMail;
	}

	@Autowired
	public void setTemplateController(TemplateController templateController) {
		this.templateController = templateController;
	}

	@Autowired
	public void setDataParser(DataParser dataParser) {
		ApplicationInitializer.dataParser = dataParser;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationInitializer.class, args);
		try {
			HashMap<String, String> input = new HashMap<String, String>();
			TravelInfo travelInfo = dataParser.parseRequestData(input);
			String requestType = "NewRequest";
			String recieverType = "ApprovingManager";

			PropertiesUtil.loadPropertyFile();
			String triggerName = templateController.getTriggerName(requestType, recieverType, travelInfo.isEmployee());
			HashMap<String, String> contentMap = templateController.loadTemplate(triggerName,
					travelInfo.getWorkLocation(), travelInfo);
			List<String> toMail = new ArrayList<String>();
			if (travelInfo.getBilledTo().equalsIgnoreCase("client")) {
				String clientName = travelInfo.getClientName();
				toMail.add(PropertiesUtil.getPropertyValue("dl.client." + clientName));
			} else {
				toMail.add(PropertiesUtil.getPropertyValue(getMailByLocation(travelInfo)));
			}

			Mail mail = new Mail();
			mail.setFormAddress("sknagulmeera06@gmail.com");
			mail.getToAddresses().add("nagulmeera.shaik@imaginea.com");
			mail.setSubject(contentMap.get("subject").trim());
			mail.setBody(contentMap.get("body").trim());
			// System.out.println(contentMap.get("subject"));

			System.out.println(mail);

			sendMail.sendMail(mail);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getMailByLocation(TravelInfo travelInfo) {
		String propertyName = "dl.";
		if (travelInfo.isEmployee()) {
			propertyName += "employee.";
		} else {
			propertyName += "nonemployee.";
		}

		if (travelInfo.isTicketChecked()) {
			propertyName += "ticket.";
		} else {
			propertyName += "nonticket.";
		}

		if (travelInfo.getWorkLocation().equalsIgnoreCase("Bangalore")) {
			propertyName += "bangalore";
		} else if (travelInfo.getWorkLocation().equalsIgnoreCase("Chennai")) {
			propertyName += "chennai";
		} else if (travelInfo.getWorkLocation().equalsIgnoreCase("Hyderabad")) {
			propertyName += "hyderabad";
		} else {
			propertyName += "hyderabad";
		}
		return propertyName;
	}
}
