package com.springjenkinstut;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class SpringJenkinsCicdApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void fetchAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rides")
							.accept(MediaType.APPLICATION_JSON))
							.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	void fetchOne() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/ride/1")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	void returnNotFoundForInvalidSingleRide() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/ride/6")
							.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andReturn();
	}

	@Test
	void createRide() throws Exception {
		String newRide = "{\"name\":\"Akukulu\",\"description\":\"Ye Ethiopia Lijoch chewata\",\"thrillFactor\":15,\"vomitFactor\":3}";
		mockMvc.perform(MockMvcRequestBuilders.post("/ride")
						 .contentType(MediaType.APPLICATION_JSON)
						  .content(newRide)
				          .accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isCreated())
				.andReturn();
	}
}
