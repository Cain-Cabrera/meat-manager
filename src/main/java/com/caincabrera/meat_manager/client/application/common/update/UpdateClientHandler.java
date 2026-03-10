package com.caincabrera.meat_manager.client.application.common.update;

import com.caincabrera.meat_manager.client.domain.entity.Client;
import com.caincabrera.meat_manager.client.domain.port.ClientRepository;
import com.caincabrera.meat_manager.common.mediator.RequestHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UpdateClientHandler implements RequestHandler<UpdateClientRequest, UpdateClientResponse> {

    private final ClientRepository clientRepository;

    @Override
    public UpdateClientResponse handle(UpdateClientRequest request) {

        log.info("updating client ");

        Client client = Client.builder()
                .dni(request.getDni())
                .age(request.getAge())
                .email(request.getEmail())
                .firstname(request.getFirstname())
                .lastName(request.getLastName())
                .build();

        Client clientUpdate = clientRepository.upsert(client);

        log.info("created client whit {} id", clientUpdate.getId());

        return new UpdateClientResponse(client);
    }

    @Override
    public Class<UpdateClientRequest> getRequestType() {
        return UpdateClientRequest.class;
    }
}
