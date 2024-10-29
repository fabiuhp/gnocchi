package br.com.fabiopereira.gnocchi.controller;

import br.com.fabiopereira.gnocchi.controller.dto.CreateUserRequest;
import br.com.fabiopereira.gnocchi.controller.dto.CreateUserResponse;
import br.com.fabiopereira.gnocchi.controller.dto.GetUserByIdResponse;
import br.com.fabiopereira.gnocchi.service.dto.CreateUserCommand;
import br.com.fabiopereira.gnocchi.service.interfaces.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@Tag(name = "user")
public class UserController {
    private final UserService service;

    @PostMapping
    @Operation(summary = "Criar novo usuário")
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        var command = new CreateUserCommand(
                createUserRequest.name(),
                createUserRequest.email(),
                createUserRequest.password()
        );

        UUID userId = service.createUser(command);

        return ResponseEntity.ok(new CreateUserResponse(UUID.randomUUID()));
    }

    @GetMapping("{id}")
    public ResponseEntity<GetUserByIdResponse> getUserById(@PathVariable UUID id) {
        var user = service.getUserById(id);
        var response = new GetUserByIdResponse(
                user.id(),
                user.name(),
                user.email(),
                user.createdAt(),
                user.updatedAt()
        );
        return ResponseEntity.ok(response);
    }
}
