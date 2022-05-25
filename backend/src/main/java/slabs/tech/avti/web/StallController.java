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

import slabs.tech.avti.persistance.model.Stall;
import slabs.tech.avti.persistance.model.Stall;
import slabs.tech.avti.persistance.repo.StallRepository;

@RestController
@RequestMapping("/stalls")
public class StallController {

	@Autowired
	private StallRepository stallRepository;

	/**
	 * Get all Stalls list.
	 *
	 * @return the list
	 */
	@GetMapping				 // GET Method for reading operation
	public List<Stall> getAllStalls() {
		return stallRepository.findAll();
	}

	/**
	 * Gets stalls by id.
	 *
	 * @param stallId the stall id
	 * @return the stalls by id
	 * @throws Exception
	 */
	@GetMapping("/{id}") // GET Method for Read operation
	public ResponseEntity<Stall> getStallById(@PathVariable(value = "id") Long stallId) throws Exception {

		Stall stall = stallRepository.findById(stallId)
				.orElseThrow(() -> new Exception("Stall " + stallId + " not found"));
		return ResponseEntity.ok().body(stall);
	}

	/**
	 * Create stall.
	 *
	 * @param stall the stall
	 * @return the stall
	 */
	@PostMapping // POST Method for Create operation
	public Stall createStall(@Valid @RequestBody Stall stall) {
		return stallRepository.save(stall);
	}
}
