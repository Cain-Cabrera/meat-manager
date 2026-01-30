package com.caincabrera.meat_manager.client.application.common.delete;

import com.caincabrera.meat_manager.common.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteClientRequest implements Request<Void> {

    private Long id;

}
