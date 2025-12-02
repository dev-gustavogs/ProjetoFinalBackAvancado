package br.edu.uniesp.softfact.infra.professor;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter
@Entity
@Table(name = "tb_softfact_professor",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_professor_email", columnNames = "email")
        })
@NoArgsConstructor @AllArgsConstructor @Builder
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @Email
    @Column(nullable = false)
    private String email;
}

