package slabs.tech.avti.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import slabs.tech.avti.persistance.model.Configuration;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
	  
}