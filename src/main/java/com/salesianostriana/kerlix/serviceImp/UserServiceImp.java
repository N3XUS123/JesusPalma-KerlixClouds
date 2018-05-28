package com.salesianostriana.kerlix.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.kerlix.model.Orders;
import com.salesianostriana.kerlix.model.User;
import com.salesianostriana.kerlix.repo.UserRepository;
import com.salesianostriana.kerlix.security.PasswordEncrypt;
import com.salesianostriana.kerlix.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public User validateUser(String usuario, String pass) {
		final User currentUser = findByUser(usuario);
		final BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		if (findByUser(usuario) != null) {
			if (pwEncoder.matches(pass, currentUser.getPass())) {
				return repo.findFirstByUsuarioIgnoreCaseAndPass(usuario, currentUser.getPass());
			}
		}
		return null;
	}

	@Override
	public User findByUser(String usuario) {
		return repo.findFirstByUsuarioIgnoreCase(usuario);
	}

	@Override
	public User create(User c) {
		c.setPass(PasswordEncrypt.encryptPassword(c.getPass()));
		return repo.save(c);
	}

	@Override
	public User edit(User c) {
		return repo.save(c);
	}

	@Override
	public User delete(Long id) {
		User aBorrar = findById(id);
		if (aBorrar != null)
			repo.delete(aBorrar);
		return aBorrar;
	}

	@Override
	public User findById(Long id) {
		User result = repo.findById(id).orElse(null);
		return result;
	}

	@Override
	public List<User> findAll() {
		return repo.findAll();
	}

	@Override
	public User changeAdmin(User c) {
		c.setAdmin(!c.isAdmin());
		return repo.save(c);
	}

	@Override
	public User addOrder(Orders o, User user) {
		actualizarSaldo(user, user.getSaldo() - (o.getProducto().getMensualidad() * o.getMeses()));
		return edit(user.addOrder(o));
	}

	@Override
	public User removeOrder(Orders o, User user) {
		return edit(user.removeOrder(o));
	}
	
	@Override
	public User renewOrder(Orders o, User user, int meses) {
		user.removeOrder(o);
		user.addOrder(o);
		actualizarSaldo(user, user.getSaldo() - (o.getProducto().getMensualidad()*meses));
		return edit(user);
	}

	@Override
	public User actualizarSaldo(User u, double saldo) {
		u.setSaldo(saldo);
		return edit(u);
	}

	@Override
	public User changePass(User u, String pass) {
		u.setPass(pass);
		return create(u);
	}

	@Override
	public Page<User> findAllPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Page<User> searchUser(String string, Pageable pageable) {
		return repo.findAllByUsuarioIgnoreCaseContainingOrEmailIgnoreCaseContaining(string, string, pageable);
	}	

}
