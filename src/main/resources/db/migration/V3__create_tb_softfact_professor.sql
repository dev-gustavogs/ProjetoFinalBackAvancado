-- Criação da tabela de professores
create table if not exists tb_softfact_professor (
    id            bigserial primary key,
    nome          varchar(200) not null,
    email         varchar(200) not null,
    telefone      varchar(40),
    departamento  varchar(120),

    constraint uk_professor_email unique (email)
);

-- Índices conforme padrão do projeto
create index if not exists idx_professor_nome
    on tb_softfact_professor (nome);

create index if not exists idx_professor_email
    on tb_softfact_professor (email);
