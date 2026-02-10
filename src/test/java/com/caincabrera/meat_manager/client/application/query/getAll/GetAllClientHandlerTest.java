package com.caincabrera.meat_manager.client.application.query.getAll;

import com.caincabrera.meat_manager.client.domain.entity.Client;
import com.caincabrera.meat_manager.client.domain.port.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllClientHandlerTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private GetAllClientHandler handler;

    @Test
    public void ShouldReturnListClient() {

        List<Client> clients = List.of(Client.builder().id(1L).build(),
                Client.builder().id(2L).build());

        when(clientRepository.findAll()).thenReturn(clients);

        GetAllClientResponse response = handler.handle(new GetAllClientRequest());

        assertEquals(response.getClients().size(), clients.size());
    }

}