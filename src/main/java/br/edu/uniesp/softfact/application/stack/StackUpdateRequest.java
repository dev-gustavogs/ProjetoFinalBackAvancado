package br.edu.uniesp.softfact.application.stack;


import br.edu.uniesp.softfact.shared.enums.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class StackUpdateRequest {
    private String nome;
    private Categoria categoria;
}