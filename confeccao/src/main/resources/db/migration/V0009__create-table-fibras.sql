CREATE TABLE fibras (
	id bigserial not null,
    absorcao_agua varchar(200),
    comportamento_termico varchar(200),
    elasticidade varchar(100),
    nome_fibra varchar(250),
    resistencia varchar(100),
    respiravel boolean,
    tempo_secagem varchar(100),
    tipo_fibra varchar(100),
    
    primary key (id),
    
    CONSTRAINT nomeUnicoFibra unique (nome_fibra)
);