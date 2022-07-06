package com.slabstech.revive.server.springboot.persistence.repo;

import com.slabstech.revive.server.springboot.persistence.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Home, Long> {
}
