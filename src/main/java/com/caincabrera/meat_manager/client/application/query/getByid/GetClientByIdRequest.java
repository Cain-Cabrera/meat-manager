package com.caincabrera.meat_manager.client.application.query.getByid;

import com.caincabrera.meat_manager.common.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetClientByIdRequest implements Request<GetClientByIdResponse> {

    private Long id;

}
