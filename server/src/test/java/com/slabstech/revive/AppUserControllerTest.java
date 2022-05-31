package com.slabstech.revive;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.web.JsonPath;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@ExtendWith(SpringExtension.class)
@WebMvcTest
public class AppUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAppUser_ShoudldReturnAppUser()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/app_users/1"));
       
    }
    
}
