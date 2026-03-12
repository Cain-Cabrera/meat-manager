package com.caincabrera.meat_manager.client.application.common.update;

import com.caincabrera.meat_manager.client.domain.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateClientResponse {
    private Client client;
}
