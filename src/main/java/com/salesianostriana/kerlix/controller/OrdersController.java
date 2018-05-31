package com.salesianostriana.kerlix.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.kerlix.formbean.OrderProduct;
import com.salesianostriana.kerlix.model.Orders;
import com.salesianostriana.kerlix.model.User;
import com.salesianostriana.kerlix.service.OrdersService;
import com.salesianostriana.kerlix.service.ProductService;
import com.salesianostriana.kerlix.service.UserService;

@Controller
@RequestMapping("/app")
public class OrdersController {

	@Autowired
	private UserService userService;

	@Autowired
	private OrdersService orderService;

	@Autowired
	private ProductService productService;

	@Autowired
	private HttpSession session;

	@GetMapping("/deleteservice/{id}")
	public String delService(@PathVariable("id") Long id) {
		User user = orderService.findById(id).getUsuario();
		if (user.getId() == ((User) session.getAttribute("usuarioActual")).getId()) {
			userService.removeOrder(orderService.findById(id), user);
			session.setAttribute("usuarioActual", user);
		}
		return "redirect:/app";
	}

	@GetMapping("/contratar")
	public String newService(Model model) {
		model.addAttribute("loginUser", session.getAttribute("usuarioActual"));
		model.addAttribute("products", productService.findAllAble());
		model.addAttribute("order", new OrderProduct());
		return "/app/contratar";
	}

	@GetMapping("/ajax/product/{id}")
	public String newSelectService(@PathVariable("id") Long id, Model model) {
		model.addAttribute("prod", productService.findById(id));
		return "/app/contratar :: prod";
	}

	@PostMapping("/addOrder")
	public String addService(@ModelAttribute("order") OrderProduct order, Model model) {
		Orders o = orderService.addOrder(order);
		if (orderService.comprobarPrecio(o, (User) session.getAttribute("usuarioActual"))) {
			User user = userService.addOrder(o, (User) session.getAttribute("usuarioActual"));
			session.setAttribute("usuarioActual", user);
			return "redirect:/app";
		} else {
			model.addAttribute("sinSaldo", "No hay saldo");
			model.addAttribute("loginUser", session.getAttribute("usuarioActual"));
			model.addAttribute("products", productService.findAllAble());
			return "/app/contratar";
		}
	}

	@GetMapping("/ajax/order/{id}")
	public String ajaxRenovar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("order", orderService.findById(id));
		model.addAttribute("op", new OrderProduct());
		return "/app/contratado :: order";
	}

	@GetMapping("/renovar")
	public String renovar(Long id, OrderProduct o, Model model) {
		User tempUs = (User) session.getAttribute("usuarioActual");
		if (orderService.comprobarPrecio(orderService.findById(id), tempUs) || orderService.findById(id).getMeses()+o.getMeses() <= 24) {
			Orders or = orderService.renewOrder(orderService.findById(id), o.getMeses());
			tempUs = userService.renewOrder(or, tempUs, o.getMeses());
			return "redirect:/app";
		} else {
			model.addAttribute("sinSaldo");
			model.addAttribute("loginUser", session.getAttribute("usuarioActual"));
			return "/app/contratado";
		} 
	}
}
