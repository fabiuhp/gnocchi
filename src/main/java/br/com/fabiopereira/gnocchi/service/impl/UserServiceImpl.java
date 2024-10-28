package br.com.fabiopereira.gnocchi.service.impl;

import br.com.fabiopereira.gnocchi.domain.User;
import br.com.fabiopereira.gnocchi.service.dto.CreateUserCommand;
import br.com.fabiopereira.gnocchi.service.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UUID createUser(CreateUserCommand command) {
        var user = User.builder()
                .name(command.name())
                .email(command.email())
                .password(command.password())
                .build();

        return user.getId();
    }
}
