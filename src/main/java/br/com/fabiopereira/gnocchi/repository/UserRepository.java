package br.com.fabiopereira.gnocchi.repository;

import br.com.fabiopereira.gnocchi.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    User createUser(User user);
}
