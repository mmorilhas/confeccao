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

--MANGAS
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
VALUES('regata', 'inteira');

INSERT INTO mangas
(comprimento, tipo)
VALUES('curta', 'raglan');

--FIBRAS
INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('natural', 'hidrofilico', 'boa regulacao de calor', 'baixa', 'Algodao', 'moderada', true, 'lento');


INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('natural', 'hidrofobico', 'boa conservacao de calor', 'baixa', 'Couro', 'alta', false, 'rapido');


INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('natural', 'hidrofilico', 'boa conservacao de calor', 'alta', 'La', 'alta', true, 'lento');

INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('natural', 'hidrofobico', 'boa regulacao de calor', 'baixa', 'Linho', 'alta', true, 'rapido');

INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('natural', 'hidrofilico', 'boa regulacao de calor', 'alta', 'Seda', 'moderada', true, 'lento');

--------artificial

INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('artificial', 'hidrofobico', 'boa conservacao de calor', 'baixa', 'Acetato', 'moderada', false, 'rapido');

INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('artificial', 'hidrofilico', 'boa regulacao de calor', 'alta', 'Liocel', 'alta', true, 'rapido');

INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('artificial', 'hidrofobico', 'boa regulacao de calor', 'alta', 'Modal', 'alta', true, 'rapido');


INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('artificial', 'hidrofilico', 'boa regulacao de calor', 'baixa', 'Viscose', 'baixa', true, 'lento');

-------sintetica

INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('sintetica', 'hidrofobico', 'boa regulacao de calor', 'baixa', 'Acrilico', 'alta', true, 'rapido');

INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('sintetica', 'hidrofobico', 'boa conservacao de calor', 'alta', 'Elastano', 'alta', true, 'rapido');

INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('sintetica', 'hidrofobico', 'boa regulacao de calor', 'alta', 'Poliamida', 'alta', true, 'rapido');

INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('sintetica', 'hidrofobico', 'boa conservacao de calor', 'alta', 'Poliester', 'alta', false, 'rapido');

---fechamentos
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

INSERT INTO fechamentos
(aviamento, "local")
VALUES('botao', 'frente');

INSERT INTO fechamentos
(aviamento, "local")
VALUES('colchete', 'costas');

INSERT INTO fechamentos
(aviamento, "local")
VALUES('colchete', 'lateral');

INSERT INTO fechamentos
(aviamento, "local")
VALUES('colchete', 'frente');

INSERT INTO fechamentos
(aviamento, "local")
VALUES('fita', 'costas');

INSERT INTO fechamentos
(aviamento, "local")
VALUES('fita', 'lateral');

INSERT INTO fechamentos
(aviamento, "local")
VALUES('fita', 'frente');




------decotes

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
VALUES('quadrado');

INSERT INTO decotes
(descricao)
VALUES('careca');

INSERT INTO decotes
(descricao)
VALUES('oversized');


INSERT INTO decotes
(descricao)
VALUES('colarinho ingles');

INSERT INTO decotes
(descricao)
VALUES('colarinho americano');

INSERT INTO decotes
(descricao)
VALUES('colarinho italiano');

INSERT INTO decotes
(descricao)
VALUES('colarinho curto');

INSERT INTO decotes
(descricao)
VALUES('colarinho mao');

INSERT INTO decotes
(descricao)
VALUES('colarinho opera');

INSERT INTO decotes
(descricao)
VALUES('colarinho quebrado');

INSERT INTO decotes
(descricao)
VALUES('lapela xale');

INSERT INTO decotes
(descricao)
VALUES('lapela quadrada');

INSERT INTO decotes
(descricao)
VALUES('lapela pontuda');



----barras
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

INSERT INTO barras
(descricao)
VALUES('galoneira');

INSERT INTO barras
(descricao)
VALUES('vies');

INSERT INTO barras
(descricao)
VALUES('desfiada');



---silhuetas

INSERT INTO silhuetas
(descricao)
VALUES('justa');

INSERT INTO silhuetas
(descricao)
VALUES('reta');

INSERT INTO silhuetas
(descricao)
VALUES('larga');


--- cavas

INSERT INTO cavas
(descricao)
VALUES('justa');

INSERT INTO cavas
(descricao)
VALUES('baixa');


INSERT INTO cavas
(descricao)
VALUES('sem');


-- comprimentos_de_peca

INSERT INTO comprimentos_parte_de_cima
(descricao)
VALUES('cropped');

INSERT INTO comprimentos_parte_de_cima
(descricao)
VALUES('cintura');

INSERT INTO comprimentos_parte_de_cima
(descricao)
VALUES('quadril');

INSERT INTO comprimentos_parte_de_cima
(descricao)
VALUES('torax');

INSERT INTO comprimentos_parte_de_cima
(descricao)
VALUES('abaixo do quadril');


--- para casacos

INSERT INTO comprimentos_parte_de_cima
(descricao)
VALUES('meio da coxa');

INSERT INTO comprimentos_parte_de_cima
(descricao)
VALUES('joelho');

INSERT INTO comprimentos_parte_de_cima
(descricao)
VALUES('abaixo do joelho');

INSERT INTO comprimentos_parte_de_cima
(descricao)
VALUES('meio da canela');

INSERT INTO comprimentos_parte_de_cima
(descricao)
VALUES('tornozelo');