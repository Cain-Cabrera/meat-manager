package com.caincabrera.meat_manager.client.application.common.create;

import com.caincabrera.meat_manager.client.domain.entity.Client;
import com.caincabrera.meat_manager.client.domain.port.ClientRepository;
import com.caincabrera.meat_manager.common.mediator.RequestHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateClientHandler implements RequestHandler<CreateClientRequest, CreateClientResponse> {

    private final ClientRepository clientRepository;

    @Override
    public CreateClientResponse handle(CreateClientRequest request) {

        log.info("creating client");

        Client client = Client.builder()
                .dni(request.getDni())
                .age(request.getAge())
                .email(request.getEmail())
                .firstname(request.getFirstname())
                .lastName(request.getLastName())
                .build();

        Client clientUpsert = clientRepository.upsert(client);

        log.info("created client whit id {}", clientUpsert.getId());

        return new CreateClientResponse(clientUpsert);
    }

    @Override
    public Class<CreateClientRequest> getRequestType() {
        return CreateClientRequest.class;
    }
}
