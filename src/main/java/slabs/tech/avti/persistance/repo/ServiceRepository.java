package slabs.tech.avti.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import slabs.tech.avti.persistance.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
	  
}