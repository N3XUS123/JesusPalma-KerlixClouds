package com.salesianostriana.kerlix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.kerlix.formbean.LoginUser;
import com.salesianostriana.kerlix.model.User;
import com.salesianostriana.kerlix.service.UserService;

@Controller
@RequestMapping("/registro")
public class RegisterController {

	@Autowired
	UserService userService;

	@PostMapping("")
	public String registrarUsuario(@ModelAttribute User cuenta, Model model) {
		if (userService.findByUser(cuenta.getUsuario()) != null) {
			model.addAttribute("loginUser", new LoginUser());
			model.addAttribute("cuenta", new User());
			model.addAttribute("regError", "El usuario ya existe");
			return "login";
		} else {
			userService.create(cuenta);
			return "redirect:/login";
		}
	}
}
