--------natural
INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('natural', 'hidrofilico', 'boa regulacao de calor', 'baixa', 'Algodao', 'moderada', true, 'lento'),
('natural', 'hidrofobico', 'boa conservacao de calor', 'baixa', 'Couro', 'alta', false, 'rapido'),
('natural', 'hidrofilico', 'boa conservacao de calor', 'alta', 'La', 'alta', true, 'lento'),
('natural', 'hidrofobico', 'boa regulacao de calor', 'baixa', 'Linho', 'alta', true, 'rapido'),
('natural', 'hidrofilico', 'boa regulacao de calor', 'alta', 'Seda', 'moderada', true, 'lento');

--------artificial

INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('artificial', 'hidrofobico', 'boa conservacao de calor', 'baixa', 'Acetato', 'moderada', false, 'rapido'),
('artificial', 'hidrofilico', 'boa regulacao de calor', 'alta', 'Liocel', 'alta', true, 'rapido'),
('artificial', 'hidrofobico', 'boa regulacao de calor', 'alta', 'Modal', 'alta', true, 'rapido'),
('artificial', 'hidrofilico', 'boa regulacao de calor', 'baixa', 'Viscose', 'baixa', true, 'lento');

-------sintetica

INSERT INTO fibras
(tipo_fibra, absorcao_agua, comportamento_termico, elasticidade, nome_fibra, resistencia, respiravel, tempo_secagem)
VALUES('sintetica', 'hidrofobico', 'boa regulacao de calor', 'baixa', 'Acrilico', 'alta', true, 'rapido'),
('sintetica', 'hidrofobico', 'boa conservacao de calor', 'alta', 'Elastano', 'alta', true, 'rapido'),
('sintetica', 'hidrofobico', 'boa regulacao de calor', 'alta', 'Poliamida', 'alta', true, 'rapido'),
('sintetica', 'hidrofobico', 'boa conservacao de calor', 'alta', 'Poliester', 'alta', false, 'rapido');
