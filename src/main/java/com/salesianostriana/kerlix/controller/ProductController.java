package com.salesianostriana.kerlix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.kerlix.formbean.CreateProduct;
import com.salesianostriana.kerlix.model.Hosting;
import com.salesianostriana.kerlix.model.Server;
import com.salesianostriana.kerlix.service.ProductService;

@Controller
@RequestMapping("/admin/plans")
public class ProductController {

	@Autowired
	ProductService productService;
	
	/*@GetMapping({"", "/"})
	public String productList(Model model) {
		model.addAttribute("products", productService.findAll());
		return "/admin/products";
	}*/
	
	@GetMapping("/add")
	public String newProd(Model model) {
		model.addAttribute("product", new CreateProduct());
		return "/admin/addproduct";
	}
	
	@PostMapping("/addHost")
	public String addHosts(@ModelAttribute Hosting product) {
		productService.create(product);	
		return "redirect:/admin/plans";
	}
	
	@PostMapping("/addServer")
	public String addServers(@ModelAttribute Server product) {
		productService.create(product);	
		return "redirect:/admin/plans";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProd(@PathVariable("id") Long id) {
		productService.changeDisabled(productService.findById(id));
		return "redirect:/admin/plans";
	}
	
	@GetMapping("/edit/{id}")
	public String editService(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", productService.findById(id));
		return "/admin/addProduct";
	}
}
