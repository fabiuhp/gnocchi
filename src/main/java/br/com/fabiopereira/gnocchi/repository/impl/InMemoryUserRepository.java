package br.com.fabiopereira.gnocchi.repository.impl;

import br.com.fabiopereira.gnocchi.domain.User;
import br.com.fabiopereira.gnocchi.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final List<User> users = new ArrayList<>();

    @Override
    public Optional<User> findByEmail(String email) {
        return users.stream()
                .filter(user -> email.equals(user.getEmail()))
                .findAny();
    }

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public Optional<User> findById(UUID id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findAny();
    }
}
