CREATE TABLE tecidos (
	 id bigserial not null,
     absorcao_agua varchar(250),
     comportamento_termico varchar(250),
     construcao varchar(200),
     elasticidade varchar(200),
     resistencia varchar(200),
     respiravel boolean,
     tempo_secagem varchar(200),
     tipo_de_tecido varchar(100),
     primary key (id)
);