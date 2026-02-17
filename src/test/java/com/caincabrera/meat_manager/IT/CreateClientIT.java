package com.caincabrera.meat_manager.IT;

import com.caincabrera.meat_manager.client.domain.port.ClientRepository;
import com.caincabrera.meat_manager.client.infrastructure.api.dto.ClientDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CreateClientIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ClientRepository clientRepository;

    @AfterEach
    void tearDown() {
        log.info("Tearing down integration test");
        clientRepository.deleteClient(1L);
    }

    @Test
    void saveClient() {

        ClientDto client = ClientDto.builder()
                .id(1L)
                .email("test@gmail.com")
                .dni("44200300").age(24)
                .firstname("Cain")
                .lastName("Cabrera")
                .build();

        ResponseEntity<ClientDto> response = restTemplate.postForEntity("/api/v1", client, ClientDto.class);

        assertNotNull(response);
        assertEquals("Cain", response.getBody().getFirstname());
        assertEquals("Cabrera", response.getBody().getLastName());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
