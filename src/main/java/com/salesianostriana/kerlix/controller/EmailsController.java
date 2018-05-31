package com.salesianostriana.kerlix.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.kerlix.formbean.SupportEmail;
import com.salesianostriana.kerlix.model.User;
import com.salesianostriana.kerlix.service.EmailService;
import com.salesianostriana.kerlix.service.UserService;

@Controller
public class EmailsController {

	@Autowired
	private EmailService emailService;

	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;

	@PostMapping("/sendEmail")
	public String sendEmail(SupportEmail email) {
		emailService.supportEmail(email.getName(), email.getEmail(), email.getSubject(), email.getMessage());
		return "redirect:/";
	}

	@PostMapping("/supportEmail")
	public String sendUserEmail(SupportEmail email) {
		User user = (User) session.getAttribute("usuarioActual");
		emailService.supportEmail(user.getUsuario(), user.getEmail(), email.getSubject(), email.getMessage());
		return "redirect:/app";
	}

	@PostMapping("/adminEmail/{id}")
	public String sendAdminEmail(@PathVariable("id") Long id, SupportEmail email) {
		emailService.adminEmail(userService.findById(id).getEmail(), email.getSubject(), email.getMessage());
		return "redirect:/admin";
	}

}
