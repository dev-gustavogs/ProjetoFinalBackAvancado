package br.edu.uniesp.softfact.application.aluno;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class VincularAlunoRequest {

    @NotNull(message = "ID do aluno é obrigatório")
    private Long alunoId;
}
