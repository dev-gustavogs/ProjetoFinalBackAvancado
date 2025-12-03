-- V7__create_tb_softfact_projeto_aluno.sql

CREATE TABLE tb_softfact_projeto_aluno (
    projeto_id BIGINT NOT NULL,
    aluno_id BIGINT NOT NULL,
    PRIMARY KEY (projeto_id, aluno_id),
    CONSTRAINT fk_projeto_aluno_projeto
        FOREIGN KEY (projeto_id)
        REFERENCES tb_softfact_projeto(id_projeto)
        ON DELETE CASCADE,
    CONSTRAINT fk_projeto_aluno_aluno
        FOREIGN KEY (aluno_id)
        REFERENCES tb_softfact_aluno(id)
        ON DELETE CASCADE
);

-- Índices para melhorar performance das consultas
CREATE INDEX idx_projeto_aluno_projeto_id ON tb_softfact_projeto_aluno(projeto_id);
CREATE INDEX idx_projeto_aluno_aluno_id ON tb_softfact_projeto_aluno(aluno_id);

-- Comentários para documentação
COMMENT ON TABLE tb_softfact_projeto_aluno IS 'Tabela de relacionamento Many-to-Many entre Projeto e Aluno';
COMMENT ON COLUMN tb_softfact_projeto_aluno.projeto_id IS 'ID do projeto';
COMMENT ON COLUMN tb_softfact_projeto_aluno.aluno_id IS 'ID do aluno';