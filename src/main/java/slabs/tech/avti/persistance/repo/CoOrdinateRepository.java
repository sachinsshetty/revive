package slabs.tech.avti.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import slabs.tech.avti.persistance.model.CoOrdinate;

public interface CoOrdinateRepository extends JpaRepository<CoOrdinate, Long> {
	  
}