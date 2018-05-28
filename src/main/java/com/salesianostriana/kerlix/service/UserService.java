package com.salesianostriana.kerlix.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.salesianostriana.kerlix.model.Orders;
import com.salesianostriana.kerlix.model.User;

public interface UserService {

	public User validateUser(String usuario, String pass);

	public User findByUser(String usuario);

	public User create(User c);

	public User edit(User c);

	public User delete(Long id);

	public User findById(Long id);

	public List<User> findAll();

	public User changeAdmin(User c);

	public User addOrder(Orders o, User user);

	public User removeOrder(Orders o, User user);

	public User actualizarSaldo(User u, double saldo);

	public User changePass(User u, String pass);
	
	public Page<User> findAllPageable(Pageable pageable);
	
	public Page<User> searchUser(String evalSearch, Pageable pageable);

	public User renewOrder(Orders o, User user, int meses);
	
}
