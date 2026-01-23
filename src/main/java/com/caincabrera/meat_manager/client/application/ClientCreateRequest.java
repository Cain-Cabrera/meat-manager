package com.caincabrera.meat_manager.client.application;

import com.caincabrera.meat_manager.common.mediator.Request;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ClientCreateRequest implements Request<Void> {

    private String firstName;
    private String lastname;
    private String dni;
    private int age;
    private String gmail;
}
