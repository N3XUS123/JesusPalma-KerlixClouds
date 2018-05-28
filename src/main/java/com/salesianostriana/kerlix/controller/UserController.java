package com.salesianostriana.kerlix.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.kerlix.formbean.SupportEmail;
import com.salesianostriana.kerlix.model.User;
import com.salesianostriana.kerlix.service.UserService;

@Controller
@RequestMapping("/app")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	private HttpSession session;

	// APP
	@GetMapping({ "", "/", "/index" })
	public String appIndex(Model model) {
		model.addAttribute("loginUser", session.getAttribute("usuarioActual"));
		model.addAttribute("email", new SupportEmail());
		return "app/contratado";
	}

	@GetMapping("/perfil")
	public String perfil(Model model) {
		model.addAttribute("loginUser", session.getAttribute("usuarioActual"));
		return "app/perfil";
	}

	@PostMapping("/changeBalance")
	public String changeBalance(User cuenta) {
		userService.actualizarSaldo((User) session.getAttribute("usuarioActual"), cuenta.getSaldo());
		return "redirect:/app/perfil";
	}

	@PostMapping("/changePass")
	public String changePass(User user) {
		userService.changePass((User) session.getAttribute("usuarioActual"), user.getPass());
		return "redirect:/app/perfil";
	}
	
	

}
