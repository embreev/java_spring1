BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO products (title, price) VALUES
('iPhone', 65),
('Samsung', 50),
('Xiaomi', 35),
('Huawei', 40),
('Honor', 25),
('HTC', 25),
('Sony', 35);

DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (id bigserial PRIMARY KEY, fio VARCHAR(255));
INSERT INTO customers (fio) VALUES
('Ivanov'),
('Petrov'),
('Sidorov');

DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders (id bigserial PRIMARY KEY, customer_id int, product_id int, cnt int);
INSERT INTO orders (customer_id, product_id, cnt) VALUES
(1, 1, 1),
(1, 2, 1),
(1, 4, 1),
(2, 3, 1),
(2, 5, 1),
(2, 7, 1),
(3, 4, 1),
(3, 5, 1);

COMMIT;