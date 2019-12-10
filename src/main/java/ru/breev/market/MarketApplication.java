package ru.breev.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketApplication {
	// Домашнее задание:
	// 1. Добавить сортировку
	// 2. * Добавьте категории в качестве отдельной сущности
	// и опоробуйте сделать по ней фильтрацию

	// CREATE TABLE items (id bigserial, title varchar(255), category varchar(255), description varchar(255), price int, PRIMARY KEY (id));
	// INSERT INTO items (title, category, price) (SELECT products.title, categories.title, products.price FROM products, categories WHERE products.category_id = categories.id);
	// Воспользовался таблицами с прошлого задания

	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);
	}
}
