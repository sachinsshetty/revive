package com.slabstech.revive.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slabstech.revive.persistence.model.Configuration;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
	  
}