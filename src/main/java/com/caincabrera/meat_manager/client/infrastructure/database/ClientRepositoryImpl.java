package com.caincabrera.meat_manager.client.infrastructure.database;

import com.caincabrera.meat_manager.client.domain.Client;
import com.caincabrera.meat_manager.client.domain.ClientRepository;

import java.util.List;
import java.util.Optional;

public class ClientRepositoryImpl implements ClientRepository {
    @Override
    public void upsert(Client client) {

    }

    @Override
    public List<Client> findAll() {
        return List.of();
    }

    @Override
    public void deleteClient(Long id) {

    }

    @Override
    public Optional<Client> findById(Long id) {
        return Optional.empty();
    }
}
