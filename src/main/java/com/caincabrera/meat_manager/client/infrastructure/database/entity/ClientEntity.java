package com.caincabrera.meat_manager.client.infrastructure.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Table(name = "client")
@Data
@Entity
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 3, max = 58)
    @Column(nullable = false)
    private String firstname;

    @Length(min = 3, max = 58)
    @Column(nullable = false)
    private String lastName;

    @Length(min = 7, max = 8)
    @Column(nullable = false)
    private String dni;

    @Column(nullable = false, unique = true)
    private String email;

    @Min(14)
    private int age;
}
