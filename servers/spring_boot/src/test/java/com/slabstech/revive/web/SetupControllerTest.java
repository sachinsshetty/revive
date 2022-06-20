package com.slabstech.revive.web;

import com.slabstech.revive.server.springboot.persistence.model.Setup;
import com.slabstech.revive.server.springboot.persistence.repo.SetupRepository;
import com.slabstech.revive.server.springboot.web.SetupController;
import com.slabstech.revive.server.springboot.web.exception.SetupNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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



    /*

    @MockBean
	private HomeRepository homeRepository;

	@Autowired
	HomeController homeController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void whenHomeControllerInjected_thenNotNull() throws Exception {
		assertThat(homeController).isNotNull();
	}

	@Test
	public void whenGetRequestToHomes_thenCorrectResponse() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/homes")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	public void whenPostRequestToHomesAndValidHome_thenCorrectResponse() throws Exception {
		MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
		String home = "{\"name\": \"bob\", \"email\" : \"bob@domain.com\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/homes")
						.content(home)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(textPlainUtf8));
	}

	@Test
	public void whenPostRequestToHomesAndInValidHome_thenCorrectReponse() throws Exception {
		String home = "{\"name\": \"\", \"email\" : \"bob@domain.com\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/homes")
						.content(home)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is("Name is mandatory")))
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
	}



     */
}