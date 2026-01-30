package com.caincabrera.meat_manager.client.infrastructure.api.dto;

import lombok.Data;


@Data
public class ClientDto {

    private Long id;
    private String firstname;
    private String lastName;
    private String dni;
    private String email;
    private int age;
}
