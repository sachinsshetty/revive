package com.slabstech.revive;

import com.slabstech.revive.web.SetupController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.web.JsonPath;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@ExtendWith(SpringExtension.class)
@WebMvcTest(SetupController.class)
public class SetupControllerTest {
/*
    @Autowired
    private MockMvc mockMvc;
*/
    @Test
    public void getSetup_ShoudldReturnSetup()throws Exception{

        /*
        mockMvc.perform(MockMvcRequestBuilders.get("/api/setup/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("type_name").value("Server"))
                .andExpect(MockMvcResultMatchers.jsonPath("option_value").value("SpringBoot"));
       */
    }
    
}
