package com.slabstech.revive.server.springboot.persistence.repo;

import com.slabstech.revive.server.springboot.persistence.model.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
	  
}