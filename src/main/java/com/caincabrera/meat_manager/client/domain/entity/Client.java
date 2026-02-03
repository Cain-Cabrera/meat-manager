package com.caincabrera.meat_manager.client.domain.entity;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class Client {

    private Long id;
    private String firstname;
    private String lastName;
    private String dni;
    private String email;
    private int age;

}
