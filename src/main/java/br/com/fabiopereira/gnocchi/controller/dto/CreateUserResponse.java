package br.com.fabiopereira.gnocchi.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record CreateUserResponse(
        @Schema(description = "Id do usuario")
        UUID id
) {
}
