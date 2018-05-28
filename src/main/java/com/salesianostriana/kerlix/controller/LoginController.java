package com.salesianostriana.kerlix.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.kerlix.formbean.LoginUser;
import com.salesianostriana.kerlix.model.User;
import com.salesianostriana.kerlix.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping({"/login" })
	public String showLogin(Model model) {
		if(session.getAttribute("usuarioActual") == null) {
			model.addAttribute("loginUser", new LoginUser());
			model.addAttribute("cuenta", new User());
			return "login";
		} else {
			return "redirect:/app";
		}
		
	}
	
	@PostMapping("/checkLogin")
	public String doLogin(@ModelAttribute("loginUser") LoginUser loginUser, BindingResult bindingResult, Model model) {
		User cuenta = userService.validateUser(loginUser.getUsuario(), loginUser.getPass());
		if (cuenta != null) {
			session.setAttribute("usuarioActual", cuenta);
			return "redirect:/app";
		} else {
			model.addAttribute("cuenta", new User());
			model.addAttribute("loginError", "El usuario o contraseña no es válido");
			return "login";
		}

	}
	
	@GetMapping("/logout")
	public String doLogout(Model model) {
		session.removeAttribute("usuarioActual");
		return "redirect:/";
	}
	
}
