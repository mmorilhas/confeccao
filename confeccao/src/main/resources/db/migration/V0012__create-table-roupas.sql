CREATE TABLE TB_ROUPA (
	PK_ID_ROUPA bigserial not null,
    VAR_COR_ROUPA varchar(80),
    VAR_GENERO_ROUPA varchar(50),
    VAR_NOME_ROUPA varchar(250) not null,
    INT_TAMANHO_ROUPA integer,
    BOOL_BORDADO_ROUPA boolean,
    BOOL_ESTAMPA_ROUPA boolean,
	
	FK_ID_SILHUETA bigint, 
	FK_ID_FECHAMENTO bigint, 
	BOOL_CINTO_ROUPA boolean,
	BOOL_PASSANTE_ROUPA boolean,
	BOOL_PENCE_ROUPA boolean,
	BOOL_PALA_ROUPA boolean, 
	FK_ID_PREGA bigint,
	BOOL_BABADO_ROUPA boolean,
	BOOL_FENDA_ROUPA boolean,
	INT_BOLSOS_ROUPA integer,
	BOOL_FORRO_ROUPA boolean,
	FK_ID_BARRA bigint,
    
    FK_ID_DECOTE bigint,
    FK_ID_MANGA bigint,
    BOOL_CAPUZ_ROUPA boolean,
    FK_ID_CAVA bigint,
	FK_ID_COMPRIMENTO bigint,
	
	FK_ID_TECIDO bigint,
	
	BOOL_ATIVO boolean,
	


    primary key (PK_ID_ROUPA)
);



