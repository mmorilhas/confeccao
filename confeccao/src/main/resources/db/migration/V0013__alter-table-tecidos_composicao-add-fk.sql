ALTER TABLE tecidos_composicao ADD CONSTRAINT fk_composicao_fibra FOREIGN KEY (fibras_id) REFERENCES fibras;

ALTER TABLE tecidos_composicao ADD CONSTRAINT fk_composicao_tecido FOREIGN KEY (tecido_id) REFERENCES tecidos;