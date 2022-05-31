package com.slabstech.revive;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.slabstech.revive.persistence.model.AppUser;

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
        ResponseEntity<AppUser> responseEntity = restTemplate.getForEntity("/api/app_users/1", AppUser.class);



        // assert
        assertEquals(responseEntity.getStatusCode() , HttpStatus.OK.value());
        
        assertEquals(responseEntity.getBody().getUser_name() , "Max");

        assertEquals(responseEntity.getBody().getStatus() , true);

        
        
    }
    
}
