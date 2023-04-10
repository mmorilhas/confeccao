CREATE TABLE TB_DOM_MANGA (
	PK_ID_MANGA bigserial not null,
   	VAR_COMPRIMENTO_MANGA varchar(150),
    VAR_TIPO_MANGA varchar(200),
    primary key (PK_ID_MANGA)
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