package com.salesianostriana.kerlix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@GetMapping("/services/{id}")
	public String userServices(@PathVariable("id") Long id, Model model) {
		model.addAttribute("userService", userService.findById(id));
		return "/admin/usuarios :: userService";
	}
}
