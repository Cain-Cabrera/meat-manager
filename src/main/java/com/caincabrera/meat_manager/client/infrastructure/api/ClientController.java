package com.caincabrera.meat_manager.client.infrastructure.api;


import com.caincabrera.meat_manager.client.application.common.create.CreateClientRequest;
import com.caincabrera.meat_manager.client.application.common.delete.DeleteClientRequest;
import com.caincabrera.meat_manager.client.application.common.update.UpdateClientRequest;
import com.caincabrera.meat_manager.client.application.query.getAll.GetAllClientRequest;
import com.caincabrera.meat_manager.client.application.query.getAll.GetAllClientResponse;
import com.caincabrera.meat_manager.client.application.query.getByid.GetClientByIdRequest;
import com.caincabrera.meat_manager.client.application.query.getByid.GetClientByIdResponse;
import com.caincabrera.meat_manager.client.infrastructure.api.dto.ClientDto;
import com.caincabrera.meat_manager.client.infrastructure.api.mapper.ClientMapper;
import com.caincabrera.meat_manager.common.mediator.Mediator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class ClientController implements ClientApi {

    private final Mediator mediator;

    private final ClientMapper clientMapper;

    @PostMapping()
    public ResponseEntity<ClientDto> saveClient(@RequestBody @Valid ClientDto clientDto) {

        log.info("saving client whit id {}", clientDto.getId());

        CreateClientRequest request = clientMapper.mapToClient(clientDto);

        mediator.dispatch(request);

        ClientDto client = clientMapper.mapToClientDtoToRequest(request);

        log.info("saved client whit id {}", clientDto.getId());

        return ResponseEntity.ok(client);
    }


    @PutMapping()
    public ResponseEntity<ClientDto> updateClient(@RequestBody @Valid ClientDto clientDto) {

        log.info("updating client whit id {}", clientDto.getId());

        UpdateClientRequest request = clientMapper.mapToClientUpdate(clientDto);

        mediator.dispatch(request);

        log.info("updated client whit id {}", clientDto.getId());

        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<ClientDto>> getAllClient() {

        log.info("getting all clients");

        GetAllClientResponse response = mediator.dispatch(new GetAllClientRequest());

        List<ClientDto> clients = response.getClients().stream().map(clientMapper::mapToClientDto).toList();

        log.info("found {} clients", clients.size());

        return ResponseEntity.ok(clients);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getByIdClient(@PathVariable Long id) {

        log.info("getting client whit id {}", id);

        GetClientByIdResponse response = mediator.dispatch(new GetClientByIdRequest(id));

        ClientDto clientDTO = clientMapper.mapToClientDto(response.getClient());

        log.info("found {} client whit id", id);

        return ResponseEntity.ok(clientDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {

        log.info("deleting client with id {}", id);

        mediator.dispatch(new DeleteClientRequest(id));

        log.info("deleted client whit id {}", id);

        return ResponseEntity.accepted().build();
    }
}
