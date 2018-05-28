package com.salesianostriana.kerlix.serviceImp;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.salesianostriana.kerlix.service.EmailService;

@Component
public class EmailServiceImpl implements EmailService {

	@Autowired
	public JavaMailSender emailSender;

	@Override
	public void adminEmail(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);

	}

	@Override
	public void supportEmail(String name, String email, String subject, String text) {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {
			helper.setTo("kerlixclouds@gmail.com");
			helper.setSubject(name + " - " + subject);
			helper.setText("Mensaje \n" + text);
			message.addHeaderLine("Correo \n" + email);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		emailSender.send(message);
	}
}