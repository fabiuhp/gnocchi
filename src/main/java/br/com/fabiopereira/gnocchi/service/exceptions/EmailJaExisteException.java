package br.com.fabiopereira.gnocchi.service.exceptions;

public class EmailJaExisteException extends RuntimeException{
    public EmailJaExisteException() {
        super("Email já existe");
    }
}
