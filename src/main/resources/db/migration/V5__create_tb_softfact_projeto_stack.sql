-- V5__create_tb_softfact_projeto_stack.sql

CREATE TABLE tb_softfact_projeto_stack (
    projeto_id BIGINT NOT NULL,
    stack_id BIGINT NOT NULL,
    PRIMARY KEY (projeto_id, stack_id),
    CONSTRAINT fk_projeto_stack_projeto
        FOREIGN KEY (projeto_id)
        REFERENCES tb_softfact_projeto(id_projeto)
        ON DELETE CASCADE,
    CONSTRAINT fk_projeto_stack_stack
        FOREIGN KEY (stack_id)
        REFERENCES tb_softfact_stack(id)
        ON DELETE CASCADE
);

-- Índices para melhorar performance das consultas
CREATE INDEX idx_projeto_stack_projeto_id ON tb_softfact_projeto_stack(projeto_id);
CREATE INDEX idx_projeto_stack_stack_id ON tb_softfact_projeto_stack(stack_id);

-- Comentários para documentação
COMMENT ON TABLE tb_softfact_projeto_stack IS 'Tabela de relacionamentoMany-to-Many entre Projeto e Stack';
COMMENT ON COLUMN tb_softfact_projeto_stack.projeto_id IS 'ID do projeto';
COMMENT ON COLUMN tb_softfact_projeto_stack.stack_id IS 'ID da stack tecnológica';