package br.edu.uniesp.softfact.infra.stack;

import br.edu.uniesp.softfact.infra.aluno.AlunoEntity;
import br.edu.uniesp.softfact.shared.enums.Categoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "tb_softfact_stack",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_stack_nome", columnNames = "nome")
        })
@NoArgsConstructor @AllArgsConstructor @Builder
public class StackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

    @ManyToMany(mappedBy = "stacks")
    private Set<AlunoEntity> alunos = new HashSet<>();
}