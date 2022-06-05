package com.slabstech.revive.server.springboot.web;

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

import com.slabstech.revive.server.springboot.persistence.model.Setup;
import com.slabstech.revive.server.springboot.persistence.repo.SetupRepository;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/setup")
public class SetupController {

	@Autowired
	private SetupRepository setupRepository;


	/**
	 * Get all Setups list.
	 *
	 * @return the list
	 */
	@GetMapping // GET Method for reading operation
	public List<Setup> getAllSetups() {
		return setupRepository.findAll();
	}

	/**
	 * Gets setups by id.
	 *
	 * @param setupId the setup id
	 * @return the setups by id
	 * @throws Exception
	 */
	@GetMapping("/{id}") // GET Method for Read operation
	public ResponseEntity<Setup> getSetupById(@PathVariable(value = "id") Long setupId) throws Exception {

		Setup setup = setupRepository.findById(setupId)
				.orElseThrow(() -> new Exception("Setup " + setupId + " not found"));
		return ResponseEntity.ok().body(setup);
	}

	/**
	 * Create setup.
	 *
	 * @param setup the setup
	 * @return the setup
	 */
	@PostMapping // POST Method for Create operation
	@ResponseStatus(HttpStatus.CREATED)
	public Setup createSetup(@Valid @RequestBody Setup setup) {
		return setupRepository.save(setup);
	}

	/**
	 * Update setup response entity.
	 *
	 * @param setupId      the setup id
	 * @param setupDetails the setup details
	 * @return the response entity
	 * @throws Exception
	 */
	@PutMapping("/{id}") // PUT Method for Update operation
	public ResponseEntity<Setup> updateSetup(@PathVariable(value = "id") Long setupId,
			@Valid @RequestBody Setup setupDetails) throws Exception {

		Setup setup = setupRepository.findById(setupId)
				.orElseThrow(() -> new Exception("Setup " + setupId + " not found"));

		// setup.setCarName(setupDetails.getSetupName());
		// setup.setDoors(setupDetails.getOs());

		final Setup updatedSetup = setupRepository.save(setup);
		return ResponseEntity.ok(updatedSetup);
	}

	/**
	 * Delete setup map.
	 *
	 * @param setupId the setup id
	 * @return the map of the deleted setup
	 * @throws Exception the exception
	 */
	@DeleteMapping("/{id}") // DELETE Method for Delete operation
	public Map<String, Boolean> deleteSetup(@PathVariable(value = "id") Long setupId) throws Exception {
		Setup setup = setupRepository.findById(setupId)
				.orElseThrow(() -> new Exception("Setup " + setupId + " not found"));

		setupRepository.delete(setup);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
