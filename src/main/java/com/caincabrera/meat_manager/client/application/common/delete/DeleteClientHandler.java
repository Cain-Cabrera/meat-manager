package com.caincabrera.meat_manager.client.application.common.delete;

import com.caincabrera.meat_manager.client.domain.port.ClientRepository;
import com.caincabrera.meat_manager.common.mediator.RequestHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DeleteClientHandler implements RequestHandler<DeleteClientRequest, Void> {

    private final ClientRepository clientRepository;


    @Override
    public Void handle(DeleteClientRequest request) {

        log.info("deleting client whit {} id", request.getId());

        clientRepository.deleteClient(request.getId());

        log.info("deleted client whit id {}", request.getId());

        return null;
    }

    @Override
    public Class<DeleteClientRequest> getRequestType() {
        return DeleteClientRequest.class;
    }
}
