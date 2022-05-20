package slabs.tech.avti.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import slabs.tech.avti.persistance.model.Lease;

public interface LeaseRepository extends JpaRepository<Lease, Long> {
	  
}