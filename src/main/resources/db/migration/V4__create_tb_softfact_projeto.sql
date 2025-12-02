-- Criação da tabela de projetos
create table if not exists tb_softfact_projeto (
    id_projeto     bigserial primary key,
    nome           varchar(200) not null,
    descricao      varchar(500),
    tipo           varchar(100),
    nome_empresa   varchar(200),
    semestre       varchar(20),
    status         varchar(60),
    id_professor   bigint not null,

    constraint fk_projeto__professor
        foreign key (id_professor) references tb_softfact_professor(id)
        on delete cascade
);

-- Índices para melhorar buscas
create index if not exists idx_projeto_nome
    on tb_softfact_projeto (nome);

create index if not exists idx_projeto_tipo
    on tb_softfact_projeto (tipo);

create index if not exists idx_projeto_status
    on tb_softfact_projeto (status);

create index if not exists idx_projeto_id_professor
    on tb_softfact_projeto (id_professor);
