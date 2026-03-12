package com.caincabrera.meat_manager.client.application.common.create;

import com.caincabrera.meat_manager.client.domain.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateClientResponse {
    private Client client;
}
