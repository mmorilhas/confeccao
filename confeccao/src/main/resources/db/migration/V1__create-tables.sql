CREATE TABLE barras (
	id bigserial not null,
	descricao varchar(50),
	primary key (id)
);

CREATE TABLE fechamentos (
	id bigserial not null,
	aviamento varchar(100),
	local varchar(50),
	primary key (id)
);

CREATE TABLE silhuetas (
	id bigserial not null,
    descricao varchar(100),
    primary key (id)
);

CREATE TABLE tipos_pregas(
	id bigserial not null,
    descricao varchar(100),
    primary key (id)
);

CREATE TABLE mangas (
	id bigserial not null,
   comprimento varchar(150),
    tipo varchar(200),
    primary key (id)
);
 
 
-- CREATE TABLE mangas (
--	id bigserial not null,
--   comprimento_id bigint,
--    tipo_id bigint,
--    primary key (id)
-- );
 
 
 --CREATE TABLE mangas_comprimento (
--	id bigserial not null,
--   comprimento varchar(150),
--   primary key (id)
-- );

--CREATE TABLE mangas_tipo (
--	id bigserial not null,
--   tipo varchar(200),
--    primary key (id)
-- );
 
 
 CREATE TABLE decotes (
	id bigserial not null,
    descricao varchar(100),
    primary key (id)
);

 CREATE TABLE cavas (
	id bigserial not null,
    descricao varchar(100),
    primary key (id)
);


--- COMPRIMENTO
CREATE TABLE comprimentos_parte_de_cima (
	id bigserial not null,
	descricao varchar (200),
	
	primary key(id)
);


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
    primary key (id)
);

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

CREATE TABLE tecidos_composicao (
	tecido_id bigint not null,
	fibras_id bigint not null

);


CREATE TABLE roupas (
	id bigserial not null,
    cor varchar(80),
    genero varchar(50),
    nome varchar(250),
    tamanho integer,
    tem_bordado boolean,
    tem_estampa boolean,
	
	silhueta_id bigint, 
	fechamento_id bigint, 
	cinto boolean,
	passantes boolean,
	pences boolean,
	pala boolean, 
	prega_id bigint,
	babado boolean,
	fenda boolean,
	bolsos integer,
	forro boolean,
	barra_id bigint,
    
    decote_id bigint,
    manga_id bigint,
    capuz boolean,
    cava_id bigint,
	comprimento_id bigint,
	
	tecido_id bigint,
	


    primary key (id)
);



