insert into product (date_create, date_update, description, name, price, id) values (now() , now(), 'carne crua', 'hamburguer', 50.99, 1);

insert into restaurant_table (date_create, date_update, busy, number, id) values (now() , now(), true, 4, 1);


insert into shopping_cart (date_create, date_update, closed, table_id, id) values (now() , now(), false, 1, 1);


insert into cooking_request (date_create, date_update, is_cooking, product_id, shopping_cart_id, id) values (now() , now(), false, 1, 1, 1);