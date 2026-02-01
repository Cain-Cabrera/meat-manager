package com.caincabrera.meat_manager.client.infrastructure.database;

import com.caincabrera.meat_manager.client.domain.Client;
import com.caincabrera.meat_manager.client.domain.ClientRepository;
import com.caincabrera.meat_manager.client.infrastructure.database.entity.ClientEntity;
import com.caincabrera.meat_manager.client.infrastructure.database.mapper.ClientEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private final List<ClientEntity> clients = new ArrayList<>();

    private final ClientEntityMapper clientEntityMapper;

    @Override
    public void upsert(Client client) {
        ClientEntity clientEntity = clientEntityMapper.mapToEntity(client);
        clients.removeIf(p -> p.getId().equals(client.getId()));
        clients.add(clientEntity);
    }

    @Override
    public List<Client> findAll() {
        return clients.stream()
                .map(clientEntityMapper::mapToClient)
                .toList();
    }

    @Override
    public void deleteClient(Long id) {
        clients.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clients.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(clientEntityMapper::mapToClient);
    }
}
