package com.caincabrera.meat_manager.client.infrastructure.api;

import com.caincabrera.meat_manager.client.infrastructure.api.dto.ClientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ClientApi {

    ResponseEntity<ClientDto> saveClient(@RequestBody ClientDto clientDto);

    ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto clientDto);

    ResponseEntity<List<ClientDto>> getAllClient();

    ResponseEntity<ClientDto> getByIdClient(@PathVariable Long id);

    ResponseEntity<Void> deleteClient(@PathVariable Long id);

}
