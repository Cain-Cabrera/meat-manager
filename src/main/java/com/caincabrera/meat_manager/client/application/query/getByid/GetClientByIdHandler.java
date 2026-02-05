package com.caincabrera.meat_manager.client.application.query.getByid;

import com.caincabrera.meat_manager.client.domain.entity.Client;
import com.caincabrera.meat_manager.client.domain.exception.ClientNotFoundException;
import com.caincabrera.meat_manager.client.domain.port.ClientRepository;
import com.caincabrera.meat_manager.common.mediator.RequestHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class GetClientByIdHandler implements RequestHandler<GetClientByIdRequest, GetClientByIdResponse> {

    private final ClientRepository clientRepository;

    @Override
    public GetClientByIdResponse handle(GetClientByIdRequest request) {

        log.info("getting client whit id {}", request.getId());

        Client client = clientRepository.findById(request.getId())
                .orElseThrow(() -> new ClientNotFoundException(request.getId()));

        log.info("found client whit id {}", request.getId());

        return new GetClientByIdResponse(client);
    }

    @Override
    public Class<GetClientByIdRequest> getRequestType() {
        return GetClientByIdRequest.class;
    }
}
