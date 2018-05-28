package com.salesianostriana.kerlix.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.kerlix.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{

	public Page<Orders> findAllByUsuarioUsuarioContainingOrProductoTipoContainingOrNombreIgnoreCaseContaining(String string, String string2, String string3, Pageable pageable);

	
}
