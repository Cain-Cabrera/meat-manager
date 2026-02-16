package com.caincabrera.meat_manager.client.application.common.create;

import com.caincabrera.meat_manager.client.domain.entity.Client;
import com.caincabrera.meat_manager.client.domain.port.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateClientHandlerTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private CreateClientHandler handler;

    @Captor
    private ArgumentCaptor<Client> clientCaptor;

    @Test
    public void ShouldCreateClient() {

        CreateClientRequest request = new CreateClientRequest(1L, "Cain"
                , "Cabrera", "44200300", "cain@gmail.com", 24);

        doNothing().when(clientRepository).upsert(any(Client.class));

        handler.handle(request);

        verify(clientRepository).upsert(clientCaptor.capture());

        Client client = clientCaptor.getValue();

        assertEquals(1L, client.getId());
        assertEquals("Cain", client.getFirstname());
        assertEquals("Cabrera", client.getLastName());
        assertEquals("44200300", client.getDni());
    }

}