package com.caincabrera.meat_manager.client.application.query.getAll;

import com.caincabrera.meat_manager.client.domain.entity.Client;
import com.caincabrera.meat_manager.client.domain.port.ClientRepository;
import com.caincabrera.meat_manager.common.mediator.RequestHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class GetAllClientHandler implements RequestHandler<GetAllClientRequest, GetAllClientResponse> {

    private final ClientRepository clientRepository;

    @Override
    public GetAllClientResponse handle(GetAllClientRequest request) {

        log.info("getting all clients");

        List<Client> clients = clientRepository.findAll();

        log.info("found {} clients", clients.size());

        return new GetAllClientResponse(clients);
    }

    @Override
    public Class<GetAllClientRequest> getRequestType() {
        return GetAllClientRequest.class;
    }
}
