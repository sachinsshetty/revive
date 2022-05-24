package slabs.tech.avti.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import slabs.tech.avti.persistance.model.Stall;

public interface StallRepository extends JpaRepository<Stall, Long> {
	  
}