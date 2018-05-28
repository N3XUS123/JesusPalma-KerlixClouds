package com.salesianostriana.kerlix.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.salesianostriana.kerlix.model.Product;

public interface ProductService {

	public Product create(Product p);
	
	public Product edit(Product product);
	
	public List<Product> findAll();
	
	public Product findById(Long id);
	
	public List<Product> findAllAble();
	
	public Product changeDisabled(Product p);
	
	Page<Product> findAllPageable(Pageable pageable);
	
	public Page<Product> searchProduct(String evalSearch, Pageable pageable);
}
