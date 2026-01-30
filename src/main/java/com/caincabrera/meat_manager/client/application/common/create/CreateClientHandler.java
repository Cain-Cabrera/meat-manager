package com.caincabrera.meat_manager.client.application.common.create;

import com.caincabrera.meat_manager.client.domain.Client;
import com.caincabrera.meat_manager.client.domain.ClientRepository;
import com.caincabrera.meat_manager.common.mediator.RequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateClientHandler implements RequestHandler<CreateClientRequest, Void> {

    private final ClientRepository clientRepository;

    @Override
    public Void handle(CreateClientRequest request) {

        Client client = Client.builder()
                .id(request.getId())
                .dni(request.getDni())
                .age(request.getAge())
                .email(request.getEmail())
                .firstname(request.getFirstname())
                .lastName(request.getLastName())
                .build();

        clientRepository.upsert(client);

        return null;
    }

    @Override
    public Class<CreateClientRequest> getRequestType() {
        return CreateClientRequest.class;
    }
}
