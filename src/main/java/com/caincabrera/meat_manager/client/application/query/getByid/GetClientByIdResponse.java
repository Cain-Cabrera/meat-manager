package com.caincabrera.meat_manager.client.application.query.getByid;

import com.caincabrera.meat_manager.client.domain.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetClientByIdResponse {

    private Client client;

}
