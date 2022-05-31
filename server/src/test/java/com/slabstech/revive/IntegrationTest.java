package com.slabstech.revive;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.slabstech.revive.persistence.model.Setup;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test 
    public void testAppUser() throws Exception {

        // Arrange 


        // act
        ResponseEntity<Setup> responseEntity = restTemplate.getForEntity("/api/setup/1", Setup.class);



        // assert
        assertEquals(responseEntity.getStatusCode() , HttpStatus.OK.value());
        
        assertEquals(responseEntity.getBody().getType_name() , "Max");

        
        
    }
    
}
