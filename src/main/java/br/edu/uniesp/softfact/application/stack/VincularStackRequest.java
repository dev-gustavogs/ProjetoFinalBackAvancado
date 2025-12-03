package br.edu.uniesp.softfact.application.stack;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class VincularStackRequest {

    @NotNull(message = "ID da stack é obrigatório")
    private Long stackId;
}