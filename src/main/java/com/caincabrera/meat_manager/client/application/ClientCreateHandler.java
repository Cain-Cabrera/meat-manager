package com.caincabrera.meat_manager.client.application;

import com.caincabrera.meat_manager.client.domain.Client;
import com.caincabrera.meat_manager.client.domain.ClientRepository;
import com.caincabrera.meat_manager.common.mediator.RequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientCreateHandler implements RequestHandler<ClientCreateRequest, Void> {

    private final ClientRepository clientRepository;

    @Override
    public Void handle(ClientCreateRequest request) {
        Client client = Client.builder()
                .id(1L)
                .firstname(request.getFirstName())
                .lastName(request.getLastname())
                .dni(request.getDni())
                .age(request.getAge())
                .email(request.getGmail())
                .build();

        clientRepository.upsert(client);
        return null;
    }

    @Override
    public Class<ClientCreateRequest> getRequestType() {
        return ClientCreateRequest.class;
    }
}
