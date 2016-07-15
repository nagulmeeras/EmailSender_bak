package com.pramati.emailsender.appconfig;

import java.io.IOException;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ApplicationConfig {

    @Value("${MAIL_SMTP_USERNAME}")
    private String username;
    @Value("${MAIL_SMTP_PASSWORD}")
    private String password = "my3solutions";

    @Value("${MAIL_SMTP_AUTH}")
    private String mailSmtpAuth;

    @Value("${MAIL_SMTP_STARTTLS_ENABLE}")
    private String mailSmtpStarttlsEnable;

    @Value("${MAIL_SMTP_HOST}")
    private String mailSmtpHost;

    @Value("${MAIL_SMTP_PORT}")
    private String mailSmtpPort;

    @Bean
    public static PropertyPlaceholderConfigurer placeholderConfigurer() throws IOException {
        FileSystemResource resource;

        PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();

        resource = new FileSystemResource("src/main/resources/mail.properties");
        
        if(resource.exists()){
            System.out.println("mail properties found");
        }

        placeholderConfigurer.setLocation(resource);
        placeholderConfigurer.setIgnoreResourceNotFound(true);
        placeholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        placeholderConfigurer.setLocalOverride(false);
        return placeholderConfigurer;
    }

    @Bean
    public Session getMailSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", mailSmtpAuth);
        props.put("mail.smtp.starttls.enable", mailSmtpStarttlsEnable);
        props.put("mail.smtp.host", mailSmtpHost);
        props.put("mail.smtp.port", mailSmtpPort);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        return session;

    }

}