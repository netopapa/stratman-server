INSERT INTO public.cenario
(id, date_create, date_update, balance, date_reference, name)
VALUES(1, now(), now(), 20000, now(), 'ano que deu tudo errado');

INSERT INTO public.cenario
(id, date_create, date_update, balance, date_reference, name)
VALUES(2, now(), now(), 10000, now(), 'ano que o pietro entrou');

INSERT INTO public.item
(id, date_create, date_update, "name", value, cenario_id)
VALUES(1, now(), now(), 'Funcionarios', 10000, 1);

INSERT INTO public.item
(id, date_create, date_update, "name", value, cenario_id)
VALUES(2, now(), now(), 'Linha de desenvolvimento', 10000, 1);

INSERT INTO public.item
(id, date_create, date_update, "name", value, cenario_id)
VALUES(3, now(), now(), 'Funcionarios', 10000, 2);

INSERT INTO public.item
(id, date_create, date_update, "name", value, cenario_id)
VALUES(4, now(), now(), 'Linha de desenvolvimento', 20000, 2);

