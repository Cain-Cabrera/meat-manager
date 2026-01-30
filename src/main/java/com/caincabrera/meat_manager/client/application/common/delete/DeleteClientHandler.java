package com.caincabrera.meat_manager.client.application.common.delete;

import com.caincabrera.meat_manager.client.domain.ClientRepository;
import com.caincabrera.meat_manager.common.mediator.RequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteClientHandler implements RequestHandler<DeleteClientRequest, Void> {

    private final ClientRepository clientRepository;


    @Override
    public Void handle(DeleteClientRequest request) {

        clientRepository.deleteClient(request.getId());

        return null;
    }

    @Override
    public Class<DeleteClientRequest> getRequestType() {
        return DeleteClientRequest.class;
    }
}
