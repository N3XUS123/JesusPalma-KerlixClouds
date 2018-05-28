package com.salesianostriana.kerlix.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.salesianostriana.kerlix.formbean.OrderProduct;
import com.salesianostriana.kerlix.model.Orders;
import com.salesianostriana.kerlix.model.User;
import com.salesianostriana.kerlix.repo.OrdersRepository;
import com.salesianostriana.kerlix.service.OrdersService;

@Service
public class OrdersServiceImp implements OrdersService {

	@Autowired
	private OrdersRepository repo;

	@Override
	public Orders create(Orders o) {
		return repo.save(o);
	}

	@Override
	public Orders edit(Orders o) {
		return repo.save(o);
	}

	@Override
	public List<Orders> findAll() {
		return repo.findAll();
	}

	@Override
	public Orders findById(Long id) {
		Orders result = repo.findById(id).orElse(null);
		return result;
	}

	@Override
	public boolean comprobarPrecio(Orders o, User user) {
		if (user.getSaldo() <= o.getProducto().getMensualidad() * o.getMeses()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Page<Orders> findAllPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Page<Orders> searchOrders(String string, Pageable pageable) {
		return repo.findAllByUsuarioUsuarioContainingOrProductoTipoContainingOrNombreIgnoreCaseContaining(string, string, string, pageable);
	}
	
	
	@Override
	public Orders addOrder(OrderProduct op) {
			Orders o = new Orders(op.getNombre(), op.getMeses(), op.getProducto());
		return o;
	}

	@Override
	public Orders renewOrder(Orders o, int meses) {
		o = o.setMesesContrato(meses);
		return edit(o);
	}

}
