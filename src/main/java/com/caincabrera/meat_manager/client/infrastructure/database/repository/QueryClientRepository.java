package com.caincabrera.meat_manager.client.infrastructure.database.repository;

import com.caincabrera.meat_manager.client.infrastructure.database.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface QueryClientRepository extends JpaRepository<ClientEntity, Long> {

    Optional<ClientEntity> findByEmail(String email);

}
