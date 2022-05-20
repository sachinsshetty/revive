package slabs.tech.avti.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import slabs.tech.avti.persistance.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
	  
}