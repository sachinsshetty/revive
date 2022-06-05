package com.slabstech.revive.web;

import com.slabstech.revive.persistence.model.Setup;
import com.slabstech.revive.persistence.repo.SetupRepository;
import com.slabstech.revive.web.exception.SetupNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringRunner.class)
@WebMvcTest(SetupController.class)
public class SetupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SetupRepository setupRepository;


    @Test
    public void getSetup_ShouldReturnChess()throws Exception{
        org.mockito.BDDMockito.given(setupRepository.findByName(anyString()))
                .willReturn(new Setup("Server")) ;
        mockMvc.perform(MockMvcRequestBuilders.get("/api/setup/v0.0.1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("type_name").value("Spring"));
    }

    @Test
    public void getSetup_notFound()throws Exception{

        org.mockito.BDDMockito.given(setupRepository.findByName(anyString())).willThrow(new SetupNotFoundException());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/setup/v0.0.1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void getAllSetups() {
    }

    @Test
    public void getSetupById() {
    }

    @Test
    public void createSetup() {
    }

    @Test
    public void updateSetup() {
    }

    @Test
    public void deleteSetup() {
    }
}