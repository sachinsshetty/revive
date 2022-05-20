package slabs.tech.avti.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import slabs.tech.avti.persistance.model.CarbonCredits;

public interface CarbonCreditsRepository extends JpaRepository<CarbonCredits, Long> {
	  
}