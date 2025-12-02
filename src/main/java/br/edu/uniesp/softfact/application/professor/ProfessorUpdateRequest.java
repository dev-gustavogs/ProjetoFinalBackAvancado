package br.edu.uniesp.softfact.application.professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record ProfessorUpdateRequest(
        @Size(max = 150)
        String nome,

        @Email(message = "Formato de email inválido.")
        @Size(max = 150)
        String email
) {}
