package com.caincabrera.meat_manager.client.infrastructure;

import com.caincabrera.meat_manager.client.domain.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClientApi {
    //luego va a cambiar los voids, cuando creemos los dtos..
    ResponseEntity<Void> saveClient(@RequestBody Client client);

    ResponseEntity<Void> updateClient(@PathVariable Long id, @RequestBody Client client);

    ResponseEntity<Void> getAllClient();

    ResponseEntity<Void> getByidClient(@PathVariable Long id);

    ResponseEntity<Void> deleteClient(@PathVariable Long id);

}
