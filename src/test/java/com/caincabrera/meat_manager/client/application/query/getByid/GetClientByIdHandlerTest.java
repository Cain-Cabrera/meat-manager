package com.caincabrera.meat_manager.client.application.query.getByid;

import com.caincabrera.meat_manager.client.domain.entity.Client;
import com.caincabrera.meat_manager.client.domain.exception.ClientNotFoundException;
import com.caincabrera.meat_manager.client.domain.port.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetClientByIdHandlerTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private GetClientByIdHandler handler;


    @Test
    public void ShouldReturnClientWhenFound() {

        long id = 1L;

        Client clientMock = Client.builder()
                .id(id)
                .build();


        GetClientByIdRequest request = new GetClientByIdRequest(id);
        when(clientRepository.findById(id)).thenReturn(Optional.of(clientMock));

        GetClientByIdResponse response = handler.handle(request);

        assertEquals(response.getClient(), clientMock);
    }

    @Test
    public void ShouldThrowExceptionWhenClientNotFound() {
        long id = 1L;

        GetClientByIdRequest request = new GetClientByIdRequest(id);
        when(clientRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ClientNotFoundException.class, () -> handler.handle(request));

    }

}