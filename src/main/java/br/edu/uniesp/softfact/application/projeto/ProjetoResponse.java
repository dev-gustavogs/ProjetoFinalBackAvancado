package br.edu.uniesp.softfact.application.projeto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjetoResponse {
    private Long idProjeto;
    private String nome;
    private String descricao;
    private String tipo;
    private String nomeEmpresa;
    private String semestre;
    private String status;
    private Long idProfessor;
}
