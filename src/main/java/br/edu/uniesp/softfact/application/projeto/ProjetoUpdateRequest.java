package br.edu.uniesp.softfact.application.projeto;

import lombok.Data;

@Data
public class ProjetoUpdateRequest {
    private Long idProjeto;
    private String nome;
    private String descricao;
    private String tipo;
    private String nomeEmpresa;
    private String semestre;
    private String status;
    private Long idProfessor;
}
