package slabs.tech.avti.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import slabs.tech.avti.persistance.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	  
}