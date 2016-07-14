package com.pramati.EmailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@EnableAutoConfiguration
@Component
@ComponentScan
public class App {

	private static TemplateController templateController;

	public TemplateController getTemplateController() {
		return templateController;
	}

	@Autowired
	public void setTemplateController(TemplateController templateController) {
		System.out.println("coming");
		this.templateController = templateController;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
		// TemplateController controller = (TemplateController)
		// ctx.getBeansOfType(TemplateController.class);/
		templateController.loadTemplate(true, "Hyderabad", true);
	}
}
