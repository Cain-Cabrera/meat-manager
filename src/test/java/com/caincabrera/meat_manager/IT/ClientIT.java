package com.caincabrera.meat_manager.IT;

import com.caincabrera.meat_manager.client.domain.entity.Client;
import com.caincabrera.meat_manager.client.domain.port.ClientRepository;
import com.caincabrera.meat_manager.client.infrastructure.api.dto.ClientDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@Slf4j
public class ClientIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        log.info("Setting up integration");
        clientRepository.upsert(Client.builder().id(1L).email("test@gmail.com").dni("44200300").age(24)
                .firstname("Cain").lastName("Cabrera").build());
    }

    @AfterEach
    void tearDown() {
        log.info("Tearing down integration test");
        clientRepository.deleteClient(1L);
    }

    @Test
    public void getClientByIdExist() {

        ResponseEntity<ClientDto> response = restTemplate.getForEntity("http://localhost:8080/api/v1/1", ClientDto.class);

        assertNotNull(response);
        assertEquals("Cain", response.getBody().getFirstname());
        assertEquals("Cabrera", response.getBody().getLastName());
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }


    @Test
    public void saveClient() throws Exception {

        ClientDto client = ClientDto.builder()
                .id(1L)
                .firstname("Cain")
                .lastName("Cabrera")
                .email("test@gmail.com")
                .dni("44200300")
                .age(24)
                .build();

        String jsonClient = objectMapper.writeValueAsString(client);

        mockMvc.perform(post("/api/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonClient))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.firstname").value("Cain"))
                .andExpect(jsonPath("$.lastName").value("Cabrera"))
                .andExpect(jsonPath("$.dni").value("44200300"))
                .andExpect(jsonPath("$.age").value("24"))
                .andExpect(jsonPath("$.email").value("test@gmail.com"));

    }

}
