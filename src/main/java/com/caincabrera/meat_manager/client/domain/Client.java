package com.caincabrera.meat_manager.client.domain;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@Builder
@RequiredArgsConstructor
public class Client {

    private Long id;
    private String firstname;
    private String lastName;
    private String dni;
    private String email;
    private int age;

}
