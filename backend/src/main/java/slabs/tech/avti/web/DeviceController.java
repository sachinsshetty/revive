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

import slabs.tech.avti.persistance.model.Device;
import slabs.tech.avti.persistance.repo.DeviceRepository;

@RestController
@RequestMapping("/vehicles")
public class DeviceController {

	@Autowired
	private DeviceRepository vehicleRepository;

	/**
	 * Get all Vehicles list.
	 *
	 * @return the list
	 */
	@GetMapping // GET Method for reading operation
	public List<Device> getAllVehicles() {
		return vehicleRepository.findAll();
	}

	/**
	 * Gets vehicles by id.
	 *
	 * @param vehicleId the vehicle id
	 * @return the vehicles by id
	 * @throws Exception
	 */
	@GetMapping("/{id}") // GET Method for Read operation
	public ResponseEntity<Device> getVehicleById(@PathVariable(value = "id") Long vehicleId) throws Exception {

		Device vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new Exception("Vehicle " + vehicleId + " not found"));
		return ResponseEntity.ok().body(vehicle);
	}

	/**
	 * Create vehicle.
	 *
	 * @param vehicle the vehicle
	 * @return the vehicle
	 */
	@PostMapping // POST Method for Create operation
	public Device createVehicle(@Valid @RequestBody Device vehicle) {
		return vehicleRepository.save(vehicle);
	}

}
