package br.edu.uniesp.softfact.application.professor;

public record ProfessorResponse(
        Integer idProfessor,
        String nome,
        String email
) {}

