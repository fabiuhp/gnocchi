package br.com.fabiopereira.gnocchi.service.interfaces;

import br.com.fabiopereira.gnocchi.service.dto.CreateUserCommand;

import java.util.UUID;

public interface UserService {
    UUID createUser(CreateUserCommand command);
}
