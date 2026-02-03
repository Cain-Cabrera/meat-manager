package com.caincabrera.meat_manager.client.application.query.getByid;

import com.caincabrera.meat_manager.client.domain.entity.Client;
import com.caincabrera.meat_manager.client.domain.exception.ClientNotFoundException;
import com.caincabrera.meat_manager.client.domain.port.ClientRepository;
import com.caincabrera.meat_manager.common.mediator.RequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetClientByIdHandler implements RequestHandler<GetClientByIdRequest, GetClientByIdResponse> {

    private final ClientRepository clientRepository;


    @Override
    public GetClientByIdResponse handle(GetClientByIdRequest request) {

        Client client = clientRepository.findById(request.getId())
                .orElseThrow(() -> new ClientNotFoundException(request.getId()));

        return new GetClientByIdResponse(client);
    }

    @Override
    public Class<GetClientByIdRequest> getRequestType() {
        return GetClientByIdRequest.class;
    }
}
