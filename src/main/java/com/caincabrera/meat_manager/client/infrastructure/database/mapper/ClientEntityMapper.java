package com.caincabrera.meat_manager.client.infrastructure.database.mapper;

import com.caincabrera.meat_manager.client.domain.entity.Client;
import com.caincabrera.meat_manager.client.infrastructure.database.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ClientEntityMapper {

    ClientEntity mapToEntity(Client client);

    Client mapToClient(ClientEntity clientEntity);
}
