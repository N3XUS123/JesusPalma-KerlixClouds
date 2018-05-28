package com.salesianostriana.kerlix.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.kerlix.formbean.SupportEmail;
import com.salesianostriana.kerlix.model.User;
import com.salesianostriana.kerlix.service.EmailService;

@Controller
public class EmailsController {

	@Autowired
	private EmailService emailService;
	
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
	// TODO Enviar emails a usuarios.
	/*@PostMapping("/adminEmail")
	public String sendAdminEmail(@PathVariable("id") Long id, SupportEmail email) {
		User user = userService.findById(id);
		emailService.adminEmail(user.getEmail(), email.getSubject(), email.getMessage());
		return "redirect:/app";
	}*/
	
}
