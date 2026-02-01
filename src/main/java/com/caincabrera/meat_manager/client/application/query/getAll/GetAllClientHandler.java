package com.caincabrera.meat_manager.client.application.query.getAll;

import com.caincabrera.meat_manager.client.domain.Client;
import com.caincabrera.meat_manager.client.domain.ClientRepository;
import com.caincabrera.meat_manager.common.mediator.RequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllClientHandler implements RequestHandler<GetAllClientRequest, GetAllClientResponse> {

    private final ClientRepository clientRepository;

    @Override
    public GetAllClientResponse handle(GetAllClientRequest request) {

        List<Client> clients = clientRepository.findAll();

        return new GetAllClientResponse(clients);
    }

    @Override
    public Class<GetAllClientRequest> getRequestType() {
        return GetAllClientRequest.class;
    }
}
