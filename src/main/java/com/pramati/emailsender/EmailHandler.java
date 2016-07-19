package com.pramati.emailsender;

public class EmailHandler {
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void setEmailContent(String workLocation , boolean isEmployee , boolean isTicketChecked , String triggerName , String billedTo){
		if(billedTo.equalsIgnoreCase("client")){
			
		}
	}
}
