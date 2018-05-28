package com.salesianostriana.kerlix.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.kerlix.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findFirstByUsuarioIgnoreCaseAndPass(String usuario, String pass);

	public User findFirstByUsuarioIgnoreCase(String usuario);

	public Page<User> findAllByUsuarioIgnoreCaseContainingOrEmailIgnoreCaseContaining(String string, String string2, Pageable pageable);

}
