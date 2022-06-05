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

import com.slabstech.revive.server.springboot.persistence.model.Configuration;
import com.slabstech.revive.server.springboot.persistence.repo.ConfigurationRepository;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/configurations")
public class ConfigurationController {

  @Autowired
  private ConfigurationRepository configurationRepository;

  /**
   * Get all Configurations list.
   *
   * @return the list
   */
  @GetMapping				   // GET Method for reading operation
	public List<Configuration> getAllConfigurations() {
    return configurationRepository.findAll();
  }

  /**
   * Gets configurations by id.
   *
   * @param configurationId the configuration id
   * @return the configurations by id
   * @throws Exception
   */
  @GetMapping("/{id}")    // GET Method for Read operation
  public ResponseEntity<Configuration> getConfigurationById(@PathVariable(value = "id") Long configurationId)
      throws Exception {

    Configuration configuration = configurationRepository.findById(configurationId)
                .orElseThrow(() -> new Exception("Configuration " + configurationId + " not found"));
    return ResponseEntity.ok().body(configuration);
  }

  /**
   * Create configuration.
   *
   * @param configuration the configuration
   * @return the configuration
   */
  @PostMapping   // POST Method for Create operation
  @ResponseStatus(HttpStatus.CREATED)
  public Configuration createConfiguration(@Valid @RequestBody Configuration configuration) {
    return configurationRepository.save(configuration);
  }

  /**
   * Update configuration response entity.
   *
   * @param configurationId the configuration id
   * @param configurationDetails the configuration details
   * @return the response entity
   * @throws Exception
   */
  @PutMapping("/{id}")    // PUT Method for Update operation
  public ResponseEntity<Configuration> updateConfiguration(
      @PathVariable(value = "id") Long configurationId, @Valid @RequestBody Configuration configurationDetails)
      throws Exception {

    Configuration configuration = configurationRepository.findById(configurationId)
                .orElseThrow(() -> new Exception("Configuration " + configurationId + " not found"));

    //configuration.setCarName(configurationDetails.getConfigurationName());
    //configuration.setDoors(configurationDetails.getOs());

    final Configuration updatedConfiguration = configurationRepository.save(configuration);
    return ResponseEntity.ok(updatedConfiguration);
  }

  /**
   * Delete configuration map.
   *
   * @param configurationId the configuration id
   * @return the map of the deleted configuration
   * @throws Exception the exception
   */
  @DeleteMapping("/{id}")    // DELETE Method for Delete operation
  public Map<String, Boolean> deleteConfiguration(@PathVariable(value = "id") Long configurationId) throws Exception {
    Configuration configuration = configurationRepository.findById(configurationId)
                .orElseThrow(() -> new Exception("Configuration " + configurationId + " not found"));

    configurationRepository.delete(configuration);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
