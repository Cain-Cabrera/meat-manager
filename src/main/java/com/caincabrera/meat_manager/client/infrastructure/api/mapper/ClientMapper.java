package com.caincabrera.meat_manager.client.infrastructure.api.mapper;

import com.caincabrera.meat_manager.client.application.common.create.CreateClientRequest;
import com.caincabrera.meat_manager.client.application.common.update.UpdateClientRequest;
import com.caincabrera.meat_manager.client.domain.Client;
import com.caincabrera.meat_manager.client.infrastructure.api.dto.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ClientMapper {


    CreateClientRequest mapToClient(ClientDto clientDto);

    UpdateClientRequest mapToClientUpdate(ClientDto clientDto);

    ClientDto mapToClientDto(Client client);
}
