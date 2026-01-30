package com.caincabrera.meat_manager.client.infrastructure.database.entity;

import lombok.Data;

@Data
public class ClientEntity {

    private Long id;
    private String firstname;
    private String lastName;
    private String dni;
    private String email;
    private int age;
}
