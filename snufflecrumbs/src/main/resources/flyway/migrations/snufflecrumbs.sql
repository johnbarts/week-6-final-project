DROP DATABASE IF EXISTS snufflecrumbs;
CREATE DATABASE IF NOT EXISTS snufflecrumbs;
USE snufflecrumbs;

DROP TABLE IF EXISTS shipping_address;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS treats;
DROP TABLE IF EXISTS pets;
DROP TABLE IF EXISTS customers;


CREATE TABLE customers (
	customer_pk int unsigned NOT NULL AUTO_INCREMENT,
	first_name varchar(50) NOT NULL, 
	last_name varchar(50) NOT NULL,
	phone varchar(15) NOT NULL,
	email varchar(100) NOT NULL,
	PRIMARY KEY (customer_pk)
); 

CREATE TABLE pets (
	pet_pk int unsigned NOT NULL AUTO_INCREMENT,
	customer_fk int unsigned NOT NULL,
	pet_name varchar(50) NOT NULL, 
	pet_type enum('DOG', 'CAT', 'BIRD', 'HAMSTER') NOT NULL,
	breed varchar(50),
	age int unsigned,
	PRIMARY KEY (pet_pk),
	FOREIGN KEY (customer_fk) REFERENCES customers (customer_pk) ON DELETE CASCADE
);

CREATE TABLE treats (
    	treat_pk int unsigned NOT NULL AUTO_INCREMENT,
   	treat_brand enum('PURINA', 'BLUE_BUFFALO', 'LONG_HORN', 'CLUCKEN_GOOD', 'TASTEY_CHOICE', 	'SNOUTS_BEST') NOT NULL,
    	treat_flavor enum('BEEF', 'CHICKEN', 'FISH', 'PORK', 'SEED') NOT NULL,
   	treat_count int unsigned NOT NULL,
   	price decimal(4, 2) unsigned NOT NULL,
   	PRIMARY KEY (treat_pk)
);

CREATE TABLE orders (
	order_pk int unsigned NOT NULL AUTO_INCREMENT,
    	customer_fk int unsigned NOT NULL,
    	pet_fk int unsigned NOT NULL,
    	treat_fk int unsigned NOT NULL,
    	order_price decimal(9, 2) unsigned NOT NULL,
    	order_status enum('SHIPPED','UNSHIPPED', 'CANCELLED') NOT NULL,
    	PRIMARY KEY (order_pk),
    	FOREIGN KEY (customer_fk) REFERENCES customers (customer_pk) ON DELETE CASCADE,
    	FOREIGN KEY (pet_fk) REFERENCES pets (pet_pk) ON DELETE CASCADE,
    	FOREIGN KEY (treat_fk) REFERENCES treats (treat_pk) ON DELETE CASCADE
);

CREATE TABLE shipping_address (
    customer_fk int unsigned NOT NULL,
    address varchar(150) NOT NULL,
    city varchar(100) NOT NULL,
    state enum('AK','AL','AR','AZ','CA','CO','CT','DC','DE','FL','GA','HI','IA','ID','IL','IN','KS',
    'KY','LA','MA','MD','ME','MI','MN','MO','MS','MT','NC','ND','NE','NH','NJ','NM','NV','NY','OH',
    'OK','OR','PA','RI','SC','SD','TN','TX','UT','VA','VT','WI','WV','WY') NOT NULL,
    zip int(5) unsigned NOT NULL,
    FOREIGN KEY (customer_fk) REFERENCES customers (customer_pk) ON DELETE CASCADE
);




        