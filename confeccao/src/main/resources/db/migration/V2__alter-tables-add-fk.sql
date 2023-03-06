ALTER TABLE fibras ADD CONSTRAINT nomeUnicoFibra unique (nome_fibra);

ALTER TABLE tecidos_composicao ADD CONSTRAINT fk_composicao_fibra FOREIGN KEY (composicao_id) REFERENCES fibras;

ALTER TABLE tecidos_composicao ADD CONSTRAINT fk_composicao_tecido FOREIGN KEY (tecido_id) REFERENCES tecidos;

ALTER TABLE modelagens ADD CONSTRAINT fk_modelagens_barra FOREIGN KEY (barra_id) REFERENCES barras;

ALTER TABLE modelagens ADD CONSTRAINT fk_modelagens_fechamento FOREIGN KEY (fechamento_id) REFERENCES fechamentos;

ALTER TABLE modelagens ADD CONSTRAINT fk_modelagens_prega FOREIGN KEY (prega_id) REFERENCES tipos_pregas;

ALTER TABLE modelagens ADD CONSTRAINT fk_modelagens_silhueta FOREIGN KEY (silhueta_id) REFERENCES silhuetas;

ALTER TABLE roupas ADD CONSTRAINT fk_roupa_modelagem FOREIGN KEY (modelagem_id) REFERENCES modelagens;

ALTER TABLE roupas ADD CONSTRAINT fk_roupa_tecido FOREIGN KEY (tecido_id) REFERENCES tecidos;

ALTER TABLE roupas ADD CONSTRAINT fk_roupa_decote FOREIGN KEY (decote_id) REFERENCES decotes;

ALTER TABLE roupas ADD CONSTRAINT fk_roupa_manga FOREIGN KEY (manga_id) REFERENCES mangas;