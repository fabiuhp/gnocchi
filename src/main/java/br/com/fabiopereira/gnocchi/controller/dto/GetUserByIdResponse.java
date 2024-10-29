package br.com.fabiopereira.gnocchi.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record GetUserByIdResponse(
        @Schema(description = "User id")
        UUID id,

        @Schema(description = "User name")
        String name,

        @Schema(description = "User email")
        String email,

        @Schema(description = "User creation date")
        String createdAt,

        @Schema(description = "User updated date")
        String updatedAt
) {
}
