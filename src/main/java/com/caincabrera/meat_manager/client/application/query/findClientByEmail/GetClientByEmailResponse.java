package com.caincabrera.meat_manager.client.application.query.findClientByEmail;

import com.caincabrera.meat_manager.client.domain.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetClientByEmailResponse {

    private Client client;

}
