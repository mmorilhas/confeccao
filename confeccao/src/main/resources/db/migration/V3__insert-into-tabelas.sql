INSERT INTO tipos_pregas
(descricao)
VALUES('simples');

INSERT INTO tipos_pregas
(descricao)
VALUES('macho');

INSERT INTO tipos_pregas
(descricao)
VALUES('femea');

INSERT INTO tipos_pregas
(descricao)
VALUES('plissado');


INSERT INTO mangas
(comprimento, tipo)
VALUES('regata', 'raglan');

INSERT INTO mangas
(comprimento, tipo)
VALUES('regata', 'alcinha');

INSERT INTO mangas
(comprimento, tipo)
VALUES('regata', 'muscle tee');

INSERT INTO mangas
(comprimento, tipo)
VALUES('curta', 'raglan');

INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('natural', 'hidrofilico', 'boa regulacao de calor', 'baixa', 'Algodao', 'moderada', true, 'lento');


INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('natural', 'hidrofobico', 'boa conservacao de calor', 'baixa', 'Couro', 'alta', false, 'rapido');



INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('artificial', 'hidrofilico', 'boa regulacao de calor', 'baixa', 'Viscose', 'baixa', true, 'lento');


INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('sintetica', 'hidrofobico', 'boa regulacao de calor', 'alta', 'Poliamida', 'baixa', true, 'rapido');



INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('sintetica', 'hidrofobico', 'boa regulacao de calor', 'alta', 'Poliester', 'baixa', true, 'rapido');

INSERT INTO fechamentos
(aviamento, "local")
VALUES('ziper', 'lateral');

INSERT INTO fechamentos
(aviamento, "local")
VALUES('ziper', 'frente');

INSERT INTO fechamentos
(aviamento, "local")
VALUES('ziper', 'costas');

INSERT INTO fechamentos
(aviamento, "local")
VALUES('botao', 'lateral');

INSERT INTO fechamentos
(aviamento, "local")
VALUES('botao', 'costas');




INSERT INTO decotes
(descricao)
VALUES('canoa');

INSERT INTO decotes
(descricao)
VALUES('gola alta');

INSERT INTO decotes
(descricao)
VALUES('tomara que caia');

INSERT INTO decotes
(descricao)
VALUES('v');

INSERT INTO decotes
(descricao)
VALUES('u');

INSERT INTO decotes
(descricao)
VALUES('colarinho ingles');

INSERT INTO decotes
(descricao)
VALUES('lapela xale');



INSERT INTO barras
(descricao)
VALUES('invisivel');

INSERT INTO barras
(descricao)
VALUES('lenco');

INSERT INTO barras
(descricao)
VALUES('italiana');

INSERT INTO barras
(descricao)
VALUES('simples');



INSERT INTO silhuetas
(descricao)
VALUES('justa');

INSERT INTO silhuetas
(descricao)
VALUES('reta');

INSERT INTO silhuetas
(descricao)
VALUES('larga');

