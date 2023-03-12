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
	
	ativo boolean,
	


    primary key (id)
);



