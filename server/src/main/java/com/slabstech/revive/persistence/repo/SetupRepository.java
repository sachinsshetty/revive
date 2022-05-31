package com.slabstech.revive.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slabstech.revive.persistence.model.Setup;

public interface SetupRepository extends JpaRepository<Setup, Long> {
	  
}