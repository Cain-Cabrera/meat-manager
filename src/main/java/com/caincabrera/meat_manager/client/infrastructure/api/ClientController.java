package com.caincabrera.meat_manager.client.infrastructure.api;


import com.caincabrera.meat_manager.client.application.common.create.CreateClientRequest;
import com.caincabrera.meat_manager.client.application.query.getByid.GetClientByIdRequest;
import com.caincabrera.meat_manager.client.application.query.getByid.GetClientByIdResponse;
import com.caincabrera.meat_manager.client.infrastructure.api.dto.ClientDto;
import com.caincabrera.meat_manager.client.infrastructure.api.mapper.ClientMapper;
import com.caincabrera.meat_manager.common.mediator.Mediator;
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


    @PostMapping("/crear")
    public ResponseEntity<ClientDto> saveClient(@RequestBody ClientDto clientDto) {

        CreateClientRequest request = clientMapper.mapToCreateClientRequest(clientDto);

        mediator.dispatch(request);

        return ResponseEntity.ok(null);
    }


    @PutMapping
    public ResponseEntity<ClientDto> updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<ClientDto>> getAllClient() {
        return null;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getByIdClient(@PathVariable Long id) {

        GetClientByIdResponse response = mediator.dispatch(new GetClientByIdRequest(id));

        ClientDto clientDTO = clientMapper.mapToClientDto(response.getClient());

        return ResponseEntity.ok(clientDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(Long id) {
        return ResponseEntity.noContent().build();
    }
}
