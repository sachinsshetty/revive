package slabs.tech.avti.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import slabs.tech.avti.persistance.model.Location;
import slabs.tech.avti.persistance.repo.LocationRepository;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

	@Autowired
	private LocationRepository locationRepository;

	/**
	 * Get all Locations list.
	 *
	 * @return the list
	 */
	@GetMapping // GET Method for reading operation
	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}

	/**
	 * Gets locations by id.
	 *
	 * @param locationId the location id
	 * @return the locations by id
	 * @throws Exception
	 */
	@GetMapping("/{id}") // GET Method for Read operation
	public ResponseEntity<Location> getLocationById(@PathVariable(value = "id") Long locationId) throws Exception {

		Location location = locationRepository.findById(locationId)
				.orElseThrow(() -> new Exception("Location " + locationId + " not found"));
		return ResponseEntity.ok().body(location);
	}

	/**
	 * Create location.
	 *
	 * @param location the location
	 * @return the location
	 */
	@PostMapping // POST Method for Create operation
	public Location createLocation(@Valid @RequestBody Location location) {
		return locationRepository.save(location);
	}

}
