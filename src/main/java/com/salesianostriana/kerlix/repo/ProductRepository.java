package com.salesianostriana.kerlix.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.kerlix.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findByDisabled(Boolean disabled);
	
	public Page<Product> findAllByTipoIgnoreCaseContaining(String string, Pageable pageable);

}
