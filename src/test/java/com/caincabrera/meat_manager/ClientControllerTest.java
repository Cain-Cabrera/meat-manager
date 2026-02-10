package com.caincabrera.meat_manager;

import com.caincabrera.meat_manager.client.application.query.getAll.GetAllClientRequest;
import com.caincabrera.meat_manager.client.application.query.getAll.GetAllClientResponse;
import com.caincabrera.meat_manager.client.domain.entity.Client;
import com.caincabrera.meat_manager.client.infrastructure.api.ClientController;
import com.caincabrera.meat_manager.client.infrastructure.api.dto.ClientDto;
import com.caincabrera.meat_manager.client.infrastructure.api.mapper.ClientMapper;
import com.caincabrera.meat_manager.common.mediator.Mediator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {

    @Mock
    private Mediator mediator;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientController clientController;

    @Test
    public void GetAllClients() {

        GetAllClientResponse getAllClientResponse = new GetAllClientResponse(List.of(Client.builder().id(1L).build()));

        Client client = Client.builder()
                .id(1L)
                .dni("44222000")
                .age(23)
                .email("test@gmail.com")
                .firstname("Cain")
                .lastName("Cabrera")
                .build();

        ClientDto clientDto = ClientDto.builder()
                .id(1L)
                .build();


        when(mediator.dispatch(new GetAllClientRequest())).thenReturn(getAllClientResponse);
        when(clientMapper.mapToClientDto(any(Client.class))).thenReturn(any(ClientDto.class));

        ResponseEntity<List<ClientDto>> response = clientController.getAllClient();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        assertEquals(client.getId(), clientDto.getId());
        assertNotNull(clientDto);
    }
}
