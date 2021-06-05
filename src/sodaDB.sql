Create database if not exists soda;

Use soda;

Drop table if exists soda;

Create table soda (
	id int(10) not null auto_increment,
	name varchar(60) not null,
	quantity varchar(60),
	price decimal(6,2),
	primary key(id)
);

insert into soda (id, name, quantity, price) values (1, 'Diet Pepsi Wild Cherry', 1, 2.50);

insert into soda (id, name, quantity, price) values (2, 'Ramune Melon', 1, 3.50), 
(3, 'Fanta Orange', 1, 2.50), (4, 'Mountain Dew Major Melon', 1, 2.50), 
(5, 'Zevia Cream Soda', 1, 3.00), (6, 'Coca Cola', 1, 2.50), (7, 'Gatorade Glacier Cherry', 1, 2.75),
(8, 'Sierra Mist', 1, 1.75), (9, 'Canada Dry Ginger Ale', 1, 1.75), (10, 'Dr. Pepper', 1, 2.50), 
(11, 'Squirt', 1, 1.75);