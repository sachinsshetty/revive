package slabs.tech.avti.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import slabs.tech.avti.persistance.model.Driver;

public interface ServiceHistoryRepository extends JpaRepository<Driver, Long> {
	  
}