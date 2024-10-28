package br.com.fabiopereira.gnocchi.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record CreateUserRequest(
        @Schema(description = "Nome usuario")
        @NotEmpty
        String name,

        @Schema(description = "Email usuario")
        @NotEmpty
        String email,

        @Schema(description = "Senha usuario")
        @NotEmpty
        String password
) {
}
