package com.caincabrera.meat_manager.client.infrastructure.api;


import com.caincabrera.meat_manager.client.domain.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ClientController implements ClientApi {

    @Override
    public ResponseEntity<Void> saveClient(Client client) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateClient(Long id, Client client) {
        return null;
    }

    @Override
    public ResponseEntity<Void> getAllClient() {
        return null;
    }

    @Override
    public ResponseEntity<Void> getByidClient(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteClient(Long id) {
        return null;
    }
}
