package com.salesianostriana.kerlix.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.kerlix.model.Orders;
import com.salesianostriana.kerlix.model.Pager;
import com.salesianostriana.kerlix.model.Product;
import com.salesianostriana.kerlix.model.User;
import com.salesianostriana.kerlix.service.OrdersService;
import com.salesianostriana.kerlix.service.ProductService;
import com.salesianostriana.kerlix.service.UserService;

@Controller
@RequestMapping("/admin")
public class PagerController {

	private static final int BUTTONS_TO_SHOW = 5;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final String INITIAL_DIRATTRIBUTE = "id";
	private static final int[] PAGE_SIZES = { 5, 10, 20 };
	private static final String INITIAL_DIRECTION = "ASC";
	private static final String INITIAL_SEARCH = "";

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrdersService ordersService;

	@GetMapping("/users")
	public String showUsers(@RequestParam("l") Optional<Integer> pageSize,
			@RequestParam("p") Optional<Integer> page, @RequestParam("d") Optional<String> dirAttribute,
			@RequestParam("o") Optional<String> direction, @RequestParam("q") Optional<String> search, Model model) {
		
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		String evalDirAttribute = dirAttribute.orElse(INITIAL_DIRATTRIBUTE);
		String evalDirection = direction.orElse(INITIAL_DIRECTION);
		String evalSearch = search.orElse(INITIAL_SEARCH);
		
		Page<User> users = userService.searchUser(evalSearch, PageRequest.of(evalPage, evalPageSize, Sort.Direction.fromString(evalDirection), evalDirAttribute));
		//findAllPageable(PageRequest.of(evalPage, evalPageSize, Sort.Direction.fromString(evalDirection), evalDirAttribute));

		Pager pager = new Pager(users.getTotalPages(), users.getNumber(), BUTTONS_TO_SHOW);
		
		model.addAttribute("search", evalSearch);
		model.addAttribute("users", users);
		model.addAttribute("selectedPageSize", evalPageSize);
		model.addAttribute("pageSizes", PAGE_SIZES);
		model.addAttribute("pager", pager);
		model.addAttribute("dirAttribute", evalDirAttribute);
		model.addAttribute("direction", evalDirection);

		return "admin/usuarios";
	}
	
	@GetMapping("/plans")
	public String showProducts(@RequestParam("l") Optional<Integer> pageSize,
			@RequestParam("p") Optional<Integer> page, @RequestParam("d") Optional<String> dirAttribute,
			@RequestParam("o") Optional<String> direction, @RequestParam("q") Optional<String> search, Model model) {
		
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		String evalDirAttribute = dirAttribute.orElse(INITIAL_DIRATTRIBUTE);
		String evalDirection = direction.orElse(INITIAL_DIRECTION);
		String evalSearch = search.orElse(INITIAL_SEARCH);
		
		Page<Product> products = productService.searchProduct(evalSearch, PageRequest.of(evalPage, evalPageSize, Sort.Direction.fromString(evalDirection), evalDirAttribute));
		
		Pager pager = new Pager(products.getTotalPages(), products.getNumber(), BUTTONS_TO_SHOW);
		
		model.addAttribute("search", evalSearch);
		model.addAttribute("products", products);
		model.addAttribute("selectedPageSize", evalPageSize);
		model.addAttribute("pageSizes", PAGE_SIZES);
		model.addAttribute("pager", pager);
		model.addAttribute("dirAttribute", evalDirAttribute);
		model.addAttribute("direction", evalDirection);

		return "admin/products";
	}
	
	@GetMapping("/services")
	public String showServices(@RequestParam("l") Optional<Integer> pageSize,
			@RequestParam("p") Optional<Integer> page, @RequestParam("d") Optional<String> dirAttribute,
			@RequestParam("o") Optional<String> direction, @RequestParam("q") Optional<String> search, Model model) {
		
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		String evalDirAttribute = dirAttribute.orElse(INITIAL_DIRATTRIBUTE);
		String evalDirection = direction.orElse(INITIAL_DIRECTION);
		String evalSearch = search.orElse(INITIAL_SEARCH);
		
		Page<Orders> services = ordersService.searchOrders(evalSearch, PageRequest.of(evalPage, evalPageSize, Sort.Direction.fromString(evalDirection), evalDirAttribute));
		
		Pager pager = new Pager(services.getTotalPages(), services.getNumber(), BUTTONS_TO_SHOW);
		
		model.addAttribute("search", evalSearch);
		model.addAttribute("services", services);
		model.addAttribute("selectedPageSize", evalPageSize);
		model.addAttribute("pageSizes", PAGE_SIZES);
		model.addAttribute("pager", pager);
		model.addAttribute("dirAttribute", evalDirAttribute);
		model.addAttribute("direction", evalDirection);

		return "admin/services";
	}
}
