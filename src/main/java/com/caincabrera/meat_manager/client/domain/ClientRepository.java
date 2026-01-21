package com.caincabrera.meat_manager.client.domain;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    void upsert(Client client);

    List<Client> findAll();

    void deleteClient(Long id);

    Optional<Client> findById(Long id);
}
