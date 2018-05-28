package com.salesianostriana.kerlix.service;

public interface EmailService {

	public void adminEmail(String to, String subject, String text);
	public void supportEmail(String name, String email, String subject, String text);
}
