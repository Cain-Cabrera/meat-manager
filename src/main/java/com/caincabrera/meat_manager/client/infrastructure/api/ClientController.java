package com.caincabrera.meat_manager.client.infrastructure.api;


import com.caincabrera.meat_manager.client.application.common.create.CreateClientRequest;
import com.caincabrera.meat_manager.client.application.common.create.CreateClientResponse;
import com.caincabrera.meat_manager.client.application.common.delete.DeleteClientRequest;
import com.caincabrera.meat_manager.client.application.common.update.UpdateClientRequest;
import com.caincabrera.meat_manager.client.application.common.update.UpdateClientResponse;
import com.caincabrera.meat_manager.client.application.query.findClientByEmail.GetClientByEmailRequest;
import com.caincabrera.meat_manager.client.application.query.findClientByEmail.GetClientByEmailResponse;
import com.caincabrera.meat_manager.client.application.query.getAll.GetAllClientRequest;
import com.caincabrera.meat_manager.client.application.query.getAll.GetAllClientResponse;
import com.caincabrera.meat_manager.client.application.query.getByid.GetClientByIdRequest;
import com.caincabrera.meat_manager.client.application.query.getByid.GetClientByIdResponse;
import com.caincabrera.meat_manager.client.domain.entity.Client;
import com.caincabrera.meat_manager.client.infrastructure.api.dto.ClientDto;
import com.caincabrera.meat_manager.client.infrastructure.api.mapper.ClientMapper;
import com.caincabrera.meat_manager.common.mediator.Mediator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Client API methods")
@Slf4j
public class ClientController implements ClientApi {

    private final Mediator mediator;

    private final ClientMapper clientMapper;

    @Operation(summary = "Save client", description = "Register a new client")
    @PostMapping()
    public ResponseEntity<ClientDto> saveClient(@RequestBody @Valid ClientDto clientDto) {

        log.info("saving client ");

        CreateClientRequest request = clientMapper.mapToClientDtoToCreateClientRequest(clientDto);

        CreateClientResponse response = mediator.dispatch(request);

        Client clientResponse = response.getClient();

        log.info("saved client whit id {}", clientResponse.getId());

        return ResponseEntity.created(URI.create("/api/v1".concat(clientResponse.getId().toString()))).build();
    }

    @Operation(summary = "Update client", description = "Update client exist")
    @PutMapping()
    public ResponseEntity<ClientDto> updateClient(@RequestBody @Valid ClientDto clientDto) {

        log.info("updating client");

        UpdateClientRequest request = clientMapper.mapToClientUpdate(clientDto);

        UpdateClientResponse response = mediator.dispatch(request);

        Client client = response.getClient();

        log.info("updated client whit id {}", client.getId());

        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get all client", description = "Get all clients")
    @GetMapping()
    public ResponseEntity<List<ClientDto>> getAllClient() {

        log.info("getting all clients");

        GetAllClientResponse response = mediator.dispatch(new GetAllClientRequest());

        List<ClientDto> clients = response.getClients().stream().map(clientMapper::mapToClientDto).toList();

        log.info("found {} clients", clients.size());

        return ResponseEntity.ok(clients);
    }

    @Operation(summary = "Get by Id client", description = "Get a client by id")
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getByIdClient(@PathVariable Long id) {

        log.info("getting client whit id {}", id);

        GetClientByIdResponse response = mediator.dispatch(new GetClientByIdRequest(id));

        ClientDto clientDTO = clientMapper.mapToClientDto(response.getClient());

        log.info("found {} client whit id", id);

        return ResponseEntity.ok(clientDTO);
    }

    @Operation(summary = "Delete client if id exist", description = "Delete a client by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {

        log.info("deleting client with id {}", id);

        mediator.dispatch(new DeleteClientRequest(id));

        log.info("deleted client whit id {}", id);

        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Get client by Email", description = "Get a client by email")
    @GetMapping("/email/{email}")
    public ResponseEntity<ClientDto> getClientByEmail(@PathVariable String email) {

        log.info("getting client by email {}", email);

        GetClientByEmailResponse response = mediator.dispatch(new GetClientByEmailRequest(email));

        ClientDto clientDTO = clientMapper.mapToClientDto(response.getClient());

        log.info("found client by email {}", email);

        return ResponseEntity.ok(clientDTO);
    }
}
