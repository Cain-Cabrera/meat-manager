package com.caincabrera.meat_manager.client.domain.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Long id) {
        super("client whit id " + id + " was not found");
    }
}
