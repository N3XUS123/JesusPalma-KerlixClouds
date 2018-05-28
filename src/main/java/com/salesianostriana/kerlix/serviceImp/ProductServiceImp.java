package com.salesianostriana.kerlix.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.salesianostriana.kerlix.model.Product;
import com.salesianostriana.kerlix.repo.ProductRepository;
import com.salesianostriana.kerlix.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public Product create(Product p) {
		return repo.save(p);
	}

	@Override
	public List<Product> findAll() {
		return repo.findAll();
	}

	@Override
	public Product findById(Long id) {
		Product result = repo.findById(id).orElse(null);
		return result;
	}

	@Override
	public List<Product> findAllAble() {
		return repo.findByDisabled(false);
	}

	@Override
	public Product changeDisabled(Product p) {
		p.setDisabled(!p.isDisabled());
		return repo.save(p);
	}

	@Override
	public Product edit(Product product) {
		return repo.save(product);
	}

	@Override
	public Page<Product> findAllPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Page<Product> searchProduct(String evalSearch, Pageable pageable) {
		return repo.findAllByTipoIgnoreCaseContaining(evalSearch, pageable);
	}
}
