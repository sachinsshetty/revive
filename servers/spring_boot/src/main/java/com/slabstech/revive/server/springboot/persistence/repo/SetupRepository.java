package com.slabstech.revive.server.springboot.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slabstech.revive.server.springboot.persistence.model.Setup;

public interface SetupRepository extends JpaRepository<Setup, Long> {
    Setup findByName(String name);
}