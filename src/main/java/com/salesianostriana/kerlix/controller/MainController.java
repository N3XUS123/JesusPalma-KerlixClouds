package com.salesianostriana.kerlix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.kerlix.formbean.SupportEmail;

@Controller
public class MainController {

	@GetMapping({ "/" })
	public String inicio(Model model) {
		model.addAttribute("email", new SupportEmail());
		return "index";
	}

	@GetMapping({ "/admin/", "/admin", "/admin/index" })
	public String adminIndex(Model model) {
		return "admin/index";
	}

	@GetMapping("/error")
	public String error() {
		return "error";
	}

}
