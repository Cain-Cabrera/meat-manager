package com.caincabrera.meat_manager.client.infrastructure.database;

import com.caincabrera.meat_manager.client.domain.entity.Client;
import com.caincabrera.meat_manager.client.domain.port.ClientRepository;
import com.caincabrera.meat_manager.client.infrastructure.database.entity.ClientEntity;
import com.caincabrera.meat_manager.client.infrastructure.database.mapper.ClientEntityMapper;
import com.caincabrera.meat_manager.client.infrastructure.database.repository.QueryClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private final QueryClientRepository repository;

    private final ClientEntityMapper clientEntityMapper;

    @Override
    public Client upsert(Client client) {
        ClientEntity clientEntity = clientEntityMapper.mapToEntity(client);
        ClientEntity clientEntitySaved = repository.save(clientEntity);

        return clientEntityMapper.mapToClient(clientEntitySaved);
    }

    @Cacheable(value = "clients", key = "'all'")
    @Override
    public List<Client> findAll() {
        return repository.findAll().stream().map(clientEntityMapper::mapToClient).toList();
    }

    @CacheEvict(value = "client", key = "#id")
    @Override
    public void deleteClient(Long id) {
        repository.deleteById(id);
    }

    @CacheEvict(value = "client", key = "#id")
    @Override
    public Optional<Client> findById(Long id) {
        return repository.findById(id).map(clientEntityMapper::mapToClient);
    }

    @Override
    public Optional<Client> findClientByEmail(String email) {
        return repository.findByEmail(email).map(clientEntityMapper::mapToClient);
    }
}
