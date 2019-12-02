BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price int, category_id int
REFERENCES categories (id));
INSERT INTO products (title, price, category_id) VALUES
('iPhone', 65, 1),
('Samsung', 50, 1),
('Xiaomi', 35, 1),
('Huawei', 40, 1),
('Honor', 25, 1),
('HTC', 25, 1),
('Sony', 35, 1),
('Acer', 75, 2),
('Asus', 95, 2),
('HP', 80, 2),
('Lenovo', 90, 2);

DROP TABLE IF EXISTS categories CASCADE;
CREATE TABLE categories (id bigserial PRIMARY KEY, title VARCHAR(255));
INSERT INTO categories (title) VALUES
('phone'),
('notebook');

DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (id bigserial PRIMARY KEY, fio VARCHAR(255));
INSERT INTO customers (fio) VALUES
('Ivanov'),
('Petrov'),
('Sidorov');

DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders (id bigserial PRIMARY KEY, customer_id int REFERENCES customers(id), product_id int REFERENCES products(id), cnt int);
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