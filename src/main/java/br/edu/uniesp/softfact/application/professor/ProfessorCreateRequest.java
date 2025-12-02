package br.edu.uniesp.softfact.application.professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProfessorCreateRequest(
        @NotBlank(message = "O nome é obrigatório.")
        @Size(max = 150)
        String nome,

        @NotBlank(message = "O email é obrigatório.")
        @Email(message = "Formato de email inválido.")
        @Size(max = 150)
        String email
) {}
