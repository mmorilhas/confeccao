ALTER TABLE roupas ADD CONSTRAINT fk_roupa_silhueta FOREIGN KEY (silhueta_id) REFERENCES silhuetas;

ALTER TABLE roupas ADD CONSTRAINT fk_roupa_fechamento FOREIGN KEY (fechamento_id) REFERENCES fechamentos;

ALTER TABLE roupas ADD CONSTRAINT fk_roupa_prega FOREIGN KEY (prega_id) REFERENCES pregas;

ALTER TABLE roupas ADD CONSTRAINT fk_roupa_barra FOREIGN KEY (barra_id) REFERENCES barras;

ALTER TABLE roupas ADD CONSTRAINT fk_roupa_tecido FOREIGN KEY (tecido_id) REFERENCES tecidos;

ALTER TABLE roupas ADD CONSTRAINT fk_roupa_decote FOREIGN KEY (decote_id) REFERENCES decotes;

ALTER TABLE roupas ADD CONSTRAINT fk_roupa_manga FOREIGN KEY (manga_id) REFERENCES mangas;

ALTER TABLE roupas ADD CONSTRAINT fk_roupas_cava FOREIGN KEY (cava_id) REFERENCES cavas;

ALTER TABLE roupas ADD CONSTRAINT fk_roupa_comprimento_parte_cima FOREIGN KEY (comprimento_id) REFERENCES comprimentos_parte_de_cima;