package com.caincabrera.meat_manager.IT;

import com.caincabrera.meat_manager.client.domain.entity.Client;
import com.caincabrera.meat_manager.client.domain.port.ClientRepository;
import com.caincabrera.meat_manager.client.infrastructure.api.dto.ClientDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
public class ClientByIdIT {

    @Autowired
    private TestRestTemplate restTemplate;

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

}
