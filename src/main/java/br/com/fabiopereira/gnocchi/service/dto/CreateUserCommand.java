package br.com.fabiopereira.gnocchi.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record CreateUserCommand(
        String name,
        String email,
        String password
) {
}