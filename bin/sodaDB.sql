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