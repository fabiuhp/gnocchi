package br.com.fabiopereira.gnocchi.service.interfaces;

import br.com.fabiopereira.gnocchi.service.dto.CreateUserCommand;
import br.com.fabiopereira.gnocchi.service.dto.UserDto;

import java.util.UUID;

public interface UserService {
    UUID createUser(CreateUserCommand command);
    UserDto getUserById(UUID id);
}
