package slabs.tech.avti.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import slabs.tech.avti.persistance.model.RouteMap;

public interface RouteMapRepository extends JpaRepository<RouteMap, Long> {
	  
}