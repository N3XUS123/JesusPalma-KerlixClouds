package com.salesianostriana.kerlix.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.salesianostriana.kerlix.formbean.OrderProduct;
import com.salesianostriana.kerlix.model.Orders;
import com.salesianostriana.kerlix.model.User;

public interface OrdersService {

	public Orders create(Orders o);
	
	public Orders edit(Orders o);
	
	public List<Orders> findAll();
	
	public Orders findById(Long id);
	
	public boolean comprobarPrecio(Orders o, User user);;
	
	public Page<Orders> findAllPageable(Pageable pageable);
	
	public Page<Orders> searchOrders(String string, Pageable pageable);
	
	public Orders addOrder(OrderProduct op);
	
	public Orders renewOrder(Orders o, int meses);

	public List<Orders> findAllInactive();
	
}
