package com.caincabrera.meat_manager.client.application.common.update;

import com.caincabrera.meat_manager.client.domain.Client;
import com.caincabrera.meat_manager.client.domain.ClientRepository;
import com.caincabrera.meat_manager.common.mediator.RequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateClientHandler implements RequestHandler<UpdateClientRequest, Void> {

    private final ClientRepository clientRepository;

    @Override
    public Void handle(UpdateClientRequest request) {

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
    public Class<UpdateClientRequest> getRequestType() {
        return UpdateClientRequest.class;
    }
}
