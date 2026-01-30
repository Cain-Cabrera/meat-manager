package com.caincabrera.meat_manager.client.application.query.getByid;

import com.caincabrera.meat_manager.client.domain.Client;
import com.caincabrera.meat_manager.client.domain.ClientRepository;
import com.caincabrera.meat_manager.common.mediator.RequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetClientByIdHandler implements RequestHandler<GetClientByIdRequest, GetClientByIdResponse> {

    private final ClientRepository clientRepository;


    @Override
    public GetClientByIdResponse handle(GetClientByIdRequest clientRequest) {

        Client client = clientRepository.findById(clientRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));

        return new GetClientByIdResponse(client);
    }

    @Override
    public Class<GetClientByIdRequest> getRequestType() {
        return GetClientByIdRequest.class;
    }
}
