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
@RequestMapping("/devices")
public class DeviceController {

	@Autowired
	private DeviceRepository deviceRepository;

	/**
	 * Get all Devices list.
	 *
	 * @return the list
	 */
	@GetMapping // GET Method for reading operation
	public List<Device> getAllDevices() {
		return deviceRepository.findAll();
	}

	/**
	 * Gets devices by id.
	 *
	 * @param deviceId the device id
	 * @return the devices by id
	 * @throws Exception
	 */
	@GetMapping("/{id}") // GET Method for Read operation
	public ResponseEntity<Device> getDeviceById(@PathVariable(value = "id") Long deviceId) throws Exception {

		Device device = deviceRepository.findById(deviceId)
				.orElseThrow(() -> new Exception("Device " + deviceId + " not found"));
		return ResponseEntity.ok().body(device);
	}

	/**
	 * Create device.
	 *
	 * @param device the device
	 * @return the device
	 */
	@PostMapping // POST Method for Create operation
	public Device createDevice(@Valid @RequestBody Device device) {
		return deviceRepository.save(device);
	}

}
