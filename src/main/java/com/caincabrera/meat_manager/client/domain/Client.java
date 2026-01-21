package com.caincabrera.meat_manager.client.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Client {

    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private String email;
    private int age;

}
