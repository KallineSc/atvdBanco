CREATE TABLE medico (
    id serial PRIMARY KEY, 
    crm varchar(45),
    nome varchar(255)
);

CREATE TABLE sigla_formacao (
    id serial PRIMARY KEY, 
    sigla varchar(45)
);

CREATE TABLE especialidade (
    id serial PRIMARY KEY, 
    descricao varchar(225),
    observacao varchar(225)
);

CREATE TABLE laboratorio (
    id serial PRIMARY KEY, 
    descricao varchar(225) NOT NULL,
    cnes varchar(45) NOT NULL,
    cnpj varchar(45) NOT NULL,
    crbm varchar(45) NOT NULL,
    nome_fantasia varchar(225)
);

CREATE TABLE contato (
    id serial PRIMARY KEY, 
    telefone varchar(45),
    laboratorio_id int NOT NULL, 
    FOREIGN KEY (laboratorio_id) REFERENCES laboratorio (id)  
);

ALTER TABLE sigla_formacao ALTER COLUMN sigla SET NOT NULL;
-------------------------------------
CREATE TABLE endereco (
    id serial PRIMARY KEY, 
    rua varchar(225) NOT NULL,
    numero varchar(45) NOT NULL,
    complemento varchar(45) ,
    bairro varchar(225) NOT NULL,
    cep varchar(45) NOT NULL,
    cidade varchar(225) NOT NULL, 
    laboratorio_id int NOT NULL, 
    FOREIGN KEY (laboratorio_id) REFERENCES laboratorio (id) 
);

CREATE TABLE paciente (
    id serial PRIMARY KEY, 
    nome varchar(45) NOT NULL,
    dt_nascimento date
);

CREATE TABLE consulta_medica (
    id serial PRIMARY KEY, 
    dt_consulta timestamp,
    nm_atendimento varchar(45) NOT NULL,
    medico_id int NOT NULL REFERENCES medico (id),
    paciente_id int NOT NULL REFERENCES paciente (id) 
);

CREATE TABLE tipo_exame (
    id serial PRIMARY KEY, 
    descricao varchar(45),
    observacao varchar(45)
);

CREATE TABLE habilitacao_exame (
    id serial PRIMARY KEY, 
    observacao varchar(45),
    custo bigint,
    laboratorio_id int NOT NULL REFERENCES laboratorio (id),
    tipo_exame int NOT NULL REFERENCES tipo_exame (id)
);

CREATE TABLE material_exame (
    id serial PRIMARY KEY, 
    material varchar(45) NOT NULL,
    observacao varchar(45)
);

CREATE TABLE exame (
    id serial PRIMARY KEY, 
    descricao varchar(45) NOT NULL,
    metodo varchar(225),
    tipo_exame int NOT NULL REFERENCES tipo_exame (id),
    meterial_exame_id int NOT NULL REFERENCES material_exame (id)
);

CREATE TABLE unidade_medida (
    id serial PRIMARY KEY, 
    descricao varchar(45)
);

CREATE TABLE composicao_exame (
    id serial PRIMARY KEY, 
    descricao varchar(45),
    unidade_medida_id int NOT NULL REFERENCES unidade_medida (id)
);

CREATE TABLE valor_referencia_composicao_exame (
    id serial PRIMARY KEY, 
    valor_minimo varchar(45),
    valor_maximo varchar(45),
    limitador_minimo varchar(45),
    limitador_maximo varchar(45),
    unidade_medida_id int NOT NULL REFERENCES unidade_medida (id)
);

CREATE TABLE composicao (
    id serial PRIMARY KEY, 
    exame_id int NOT NULL REFERENCES exame (id),
    composicao_exame_id int NOT NULL REFERENCES composicao_exame (id),
    valor_referencia_composicao_exame_id int NOT NULL REFERENCES valor_referencia_composicao_exame (id)
);


CREATE TABLE solicitacao_exame (
    id serial PRIMARY KEY, 
    nm_prescrito varchar(45),
    dt_solicitacao timestamp,
    consulta_medica_id int NOT NULL REFERENCES consulta_medica (id),
    habilitacao_exame_id int NOT NULL REFERENCES habilitacao_exame (id),
    exame_id int NOT NULL REFERENCES exame (id)
);


CREATE TABLE laudo (
    id serial PRIMARY KEY, 
    assinatura_digital varchar(45),
    dt_resultado varchar(45),
    codigo varchar(45),
    solicitacao_exame_id int NOT NULL REFERENCES solicitacao_exame (id)
);


CREATE TABLE resultado_exame (
    id serial PRIMARY KEY, 
    dt_exame timestamp,
    valor varchar(45),
    composicao_id int NOT NULL REFERENCES composicao (id),
    laudo_id int NOT NULL REFERENCES laudo (id)
);

CREATE TABLE responsavel_tecnico (
    id serial PRIMARY KEY, 
    nome varchar(45),
    conselho varchar(45),
    formacao varchar(45),
    sigla_formacao varchar(45),
    sigla_formacao_id int NOT NULL REFERENCES sigla_formacao (id)
);

CREATE TABLE responsavel_tecnico_has_laboratorio (
    responsavel_tecnico_id int NOT NULL REFERENCES responsavel_tecnico (id),
    laboratorio_id int NOT NULL REFERENCES laboratorio (id)
);

CREATE TABLE medico_has_especialidade (
    medico_id int NOT NULL REFERENCES medico (id),
    especialidade_id int NOT NULL REFERENCES especialidade (id)
);


