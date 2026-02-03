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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ClientController implements ClientApi {

    private final Mediator mediator;

    private final ClientMapper clientMapper;


    @PostMapping()
    public ResponseEntity<ClientDto> saveClient(@RequestBody @Valid ClientDto clientDto) {

        CreateClientRequest request = clientMapper.mapToClient(clientDto);

        mediator.dispatch(request);

        return ResponseEntity.ok(null);
    }


    @PutMapping()
    public ResponseEntity<ClientDto> updateClient(@RequestBody @Valid ClientDto clientDto) {

        UpdateClientRequest request = clientMapper.mapToClientUpdate(clientDto);

        mediator.dispatch(request);

        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<ClientDto>> getAllClient() {

        GetAllClientResponse response = mediator.dispatch(new GetAllClientRequest());

        List<ClientDto> clients = response.getClients().stream().map(clientMapper::mapToClientDto).toList();

        return ResponseEntity.ok(clients);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getByIdClient(@PathVariable Long id) {

        GetClientByIdResponse response = mediator.dispatch(new GetClientByIdRequest(id));

        ClientDto clientDTO = clientMapper.mapToClientDto(response.getClient());

        return ResponseEntity.ok(clientDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {

        mediator.dispatch(new DeleteClientRequest(id));

        return ResponseEntity.accepted().build();
    }
}
