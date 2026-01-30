package com.caincabrera.meat_manager.client.application.common.create;

import com.caincabrera.meat_manager.common.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateClientRequest implements Request<Void> {

    private Long id;
    private String firstname;
    private String lastName;
    private String dni;
    private String email;
    private int age;

}
