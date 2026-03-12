package com.caincabrera.meat_manager.client.application.query.findClientByEmail;

import com.caincabrera.meat_manager.client.domain.entity.Client;
import com.caincabrera.meat_manager.client.domain.port.ClientRepository;
import com.caincabrera.meat_manager.common.mediator.RequestHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class GetClientByEmailHandler implements RequestHandler<GetClientByEmailRequest, GetClientByEmailResponse> {

    private final ClientRepository clientRepository;

    @Override
    public GetClientByEmailResponse handle(GetClientByEmailRequest request) {

        log.info("getting client by email: {}", request.getEmail());

        Client client = clientRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("client not found"));

        return new GetClientByEmailResponse(client);
    }

    @Override
    public Class<GetClientByEmailRequest> getRequestType() {
        return GetClientByEmailRequest.class;
    }
}
