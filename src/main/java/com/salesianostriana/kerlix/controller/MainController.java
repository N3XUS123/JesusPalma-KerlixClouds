package com.salesianostriana.kerlix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.kerlix.formbean.SupportEmail;
import com.salesianostriana.kerlix.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	ProductService productService;

	@GetMapping({ "/" })
	public String inicio(Model model) {
		model.addAttribute("email", new SupportEmail());
		model.addAttribute("products", productService.FindThreeRandomProducts());
		return "index";
	}

	@GetMapping("/error")
	public String error() {
		return "error";
	}

}
