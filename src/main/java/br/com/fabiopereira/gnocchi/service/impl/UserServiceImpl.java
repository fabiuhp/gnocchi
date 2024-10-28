package br.com.fabiopereira.gnocchi.service.impl;

import br.com.fabiopereira.gnocchi.domain.User;
import br.com.fabiopereira.gnocchi.repository.impl.InMemoryUserRepository;
import br.com.fabiopereira.gnocchi.service.dto.CreateUserCommand;
import br.com.fabiopereira.gnocchi.service.exceptions.EmailJaExisteException;
import br.com.fabiopereira.gnocchi.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final InMemoryUserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UUID createUser(CreateUserCommand command) {
        var userOptional = repository.findByEmail(command.email());

        if (userOptional.isPresent()) {
            throw new EmailJaExisteException();
        }

        var passwordEncoded = passwordEncoder.encode(command.password());

        var user = User.builder()
                .name(command.name())
                .email(command.email())
                .password(passwordEncoded)
                .build();

        repository.createUser(user);

        return user.getId();
    }
}
