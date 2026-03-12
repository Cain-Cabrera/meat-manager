package com.caincabrera.meat_manager.client.domain.port;

import com.caincabrera.meat_manager.client.domain.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Client upsert(Client client);

    List<Client> findAll();

    void deleteClient(Long id);

    Optional<Client> findById(Long id);

    Optional<Client> findClientByEmail(String email);

}
