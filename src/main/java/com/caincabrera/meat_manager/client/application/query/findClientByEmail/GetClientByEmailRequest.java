package com.caincabrera.meat_manager.client.application.query.findClientByEmail;

import com.caincabrera.meat_manager.common.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetClientByEmailRequest implements Request<GetClientByEmailResponse> {

    private String email;
}
