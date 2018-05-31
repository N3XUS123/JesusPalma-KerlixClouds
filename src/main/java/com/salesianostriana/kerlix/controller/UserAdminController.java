package com.salesianostriana.kerlix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.kerlix.formbean.SupportEmail;
import com.salesianostriana.kerlix.service.UserService;

@Controller
@RequestMapping("/admin/users")
public class UserAdminController {

	@Autowired
	UserService userService;

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		userService.delete(id);
		return "redirect:/admin/users";
	}

	@GetMapping("/admin/{id}")
	public String makeAdminUser(@PathVariable("id") Long id) {
		userService.changeAdmin(userService.findById(id));
		return "redirect:/admin/users";
	}

	@GetMapping("/ajax/message/{id}")
	public String ajaxRenovar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("userEmail", userService.findById(id));
		model.addAttribute("email", new SupportEmail());
		return "/admin/usuarios :: email";
	}
}
