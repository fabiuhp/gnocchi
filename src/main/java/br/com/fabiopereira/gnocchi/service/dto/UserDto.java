package br.com.fabiopereira.gnocchi.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record UserDto(
        UUID id,
        String name,
        String email,
        String createdAt,
        String updatedAt
) {
}
