package com.pramati.emailsender;

<<<<<<< HEAD
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.emailsender.beans.TravelInfo;

@RestController
public class ApplicationInitializer {

	private static DataParser dataParser;
	private static MailSenderService mailSenderService;
	private static final Logger logger = org.apache.log4j.Logger.getLogger(ApplicationInitializer.class);

	@Autowired
	public void setDataParser(DataParser dataParser) {
		ApplicationInitializer.dataParser = dataParser;
	}

	@Autowired
	public void setMailSenderService(MailSenderService mailSenderService) {
		ApplicationInitializer.mailSenderService = mailSenderService;
	}

	@RequestMapping("/")
	public void test() {

		try {
			HashMap<String, String> input = new HashMap<String, String>();
			TravelInfo travelInfo = dataParser.parseRequestData(input);
			String requestType = "new";
			logger.debug("Initailzer starts");
			System.out.println("Coming ");
			mailSenderService.sendMail(requestType, travelInfo);
			logger.debug("Initialiser stops");
			System.out.println("ends");
=======
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

>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

<<<<<<< HEAD
=======
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
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
}
