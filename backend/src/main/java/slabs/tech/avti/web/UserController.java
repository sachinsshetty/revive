package slabs.tech.avti.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import slabs.tech.avti.persistance.model.User;
import slabs.tech.avti.persistance.repo.UserRepository;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/drivers")
public class UserController {

	@Autowired
	private UserRepository driverRepository;


	/**
	 * Get all Drivers list.
	 *
	 * @return the list
	 */
	@GetMapping // GET Method for reading operation
	public List<User> getAllDrivers() {
		return driverRepository.findAll();
	}

	/**
	 * Gets drivers by id.
	 *
	 * @param driverId the driver id
	 * @return the drivers by id
	 * @throws Exception
	 */
	@GetMapping("/{id}") // GET Method for Read operation
	public ResponseEntity<User> getDriverById(@PathVariable(value = "id") Long driverId) throws Exception {

		User driver = driverRepository.findById(driverId)
				.orElseThrow(() -> new Exception("Driver " + driverId + " not found"));
		return ResponseEntity.ok().body(driver);
	}

	/**
	 * Create driver.
	 *
	 * @param driver the driver
	 * @return the driver
	 */
	@PostMapping // POST Method for Create operation
	@ResponseStatus(HttpStatus.CREATED)
	public User createDriver(@Valid @RequestBody User driver) {
		return driverRepository.save(driver);
	}

	/**
	 * Update driver response entity.
	 *
	 * @param driverId      the driver id
	 * @param driverDetails the driver details
	 * @return the response entity
	 * @throws Exception
	 */
	@PutMapping("/{id}") // PUT Method for Update operation
	public ResponseEntity<User> updateDriver(@PathVariable(value = "id") Long driverId,
			@Valid @RequestBody User driverDetails) throws Exception {

		User driver = driverRepository.findById(driverId)
				.orElseThrow(() -> new Exception("Driver " + driverId + " not found"));

		// driver.setCarName(driverDetails.getDriverName());
		// driver.setDoors(driverDetails.getOs());

		final User updatedDriver = driverRepository.save(driver);
		return ResponseEntity.ok(updatedDriver);
	}

	/**
	 * Delete driver map.
	 *
	 * @param driverId the driver id
	 * @return the map of the deleted driver
	 * @throws Exception the exception
	 */
	@DeleteMapping("/{id}") // DELETE Method for Delete operation
	public Map<String, Boolean> deleteDriver(@PathVariable(value = "id") Long driverId) throws Exception {
		User driver = driverRepository.findById(driverId)
				.orElseThrow(() -> new Exception("Driver " + driverId + " not found"));

		driverRepository.delete(driver);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
