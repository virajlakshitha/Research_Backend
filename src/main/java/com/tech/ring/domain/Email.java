package com.tech.ring.domain;

public class Email {
	
	private String to;
	private String subject;
	private String from;
	
	public Email() {
		
	}

	public Email(String to, String subject, String from) {
		super();
		this.to = to;
		this.subject = subject;
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

}
