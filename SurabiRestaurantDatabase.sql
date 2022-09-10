create database SurabiRestaurantDatabase_rachana;

use SurabiRestaurantDatabase_rachana;

CREATE TABLE admin(
email VARCHAR(100) PRIMARY KEY,
password VARCHAR(100)
);

CREATE TABLE user(
email VARCHAR(100) PRIMARY KEY,
password VARCHAR(100)
);

insert into admin
values ("admin@gmail.com", "admin");
insert into admin
values ("admin1@gmail.com", "admin1");
insert into admin
values ("admin2@gmail.com", "admin2");



CREATE TABLE menu(
item_id int primary key,
item_name varchar(100),
item_price float
);
drop table menu;

insert into menu 
value(101, "Momos", 190);

insert into menu 
value(102, "Chilly Potato", 210);

CREATE TABLE my_cart(
email varchar(100),
item_id int,
item_name varchar(100),
number_of_plates int,
total_price float,
foreign key (email) references user(email),
foreign key (item_id) references menu(item_id),
primary key (email,item_id)
);
drop table my_cart;

CREATE TABLE orders(
date_and_time varchar(50),
email varchar(100),
item_id int,
item_name varchar(100),
number_of_plate int,
total_price float,
foreign key (email) references user(email),
foreign key (item_id) references menu(item_id),
primary key (date_and_time,email,item_id)
);
drop table orders;
select * from admin;
select * from user;
select * from my_cart;
select * from orders;
