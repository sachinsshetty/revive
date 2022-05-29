package slabs.tech.avti.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import slabs.tech.avti.persistance.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	  
}