package com.caincabrera.meat_manager.client.application.query.getAll;

import com.caincabrera.meat_manager.client.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetAllClientResponse {

    private List<Client> clients;

}
