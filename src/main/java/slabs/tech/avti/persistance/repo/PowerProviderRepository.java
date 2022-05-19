package slabs.tech.avti.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import slabs.tech.avti.persistance.model.PowerProvider;

public interface PowerProviderRepository extends JpaRepository<PowerProvider, Long> {
	  
}