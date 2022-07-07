--This SQL Script will demonstrate 1st-3rd Normal Form 

--Then we'll get into joins and set operations


--A table in 1st NF (WE DO NOT WANT TO DO THIS)
--Tables must have a primary key (can be a composite key, which is a PK made up of multiple columns) (bad)
--Columns must be atomic (cells should contain the smallest pieces of data possible)
CREATE TABLE superheros(
	hero_name TEXT,
	hero_power TEXT,
	first_name TEXT,
	last_name TEXT,
	home_base TEXT,
	street_address TEXT,
	PRIMARY KEY (hero_name, first_name) --this is how you make a composite key. I'll never do this again.
);

INSERT INTO superheros(hero_name, hero_power, first_name, last_name, home_base, street_address)
VALUES ('Homelander', 'laser eyes? pretty much superman... yeah', 'John', 'Doe', 'New York', '123 street st'),
	   ('Spiderman', 'webby boi', 'peter', 'parker', 'with his aunt', '567 street ave'),
	   ('Spiderman', 'webby boi', 'miles', 'morales', 'with his aunt', '567 street ave');
	   --Note how the spiderman records are identical except for the names. This is legal in 1NF
	   --Here, spidermen are differentiated by their real names... wouldn't a superhero_id be easier though?
	  
SELECT * FROM superheros; 

DROP TABLE superheros;

--2NF--------------------

--Remove partial dependencies, which can be done with a single column primary key
CREATE TABLE superheros(
	hero_id serial PRIMARY KEY, --no more composite key, so no possibility of partial dependencies
	hero_name TEXT,
	hero_power TEXT,
	first_name TEXT,
	last_name TEXT,
	home_base TEXT,
	street_address TEXT
);

INSERT INTO superheros(hero_name, hero_power, first_name, last_name, home_base, street_address)
VALUES ('Homelander', 'laser eyes? pretty much superman... yeah', 'John', 'Doe', 'New York', '123 street st'),
	   ('Spiderman', 'webby boi', 'peter', 'parker', 'with his aunt', '567 street ave'),
	   ('Spiderman', 'webby boi', 'miles', 'morales', 'with his aunt', '567 street ave');
	  
SELECT * FROM superheros; 

DROP TABLE superheros;

--3NF---------------

--Remove transitive dependencies, which can be done by separating data into seperate tables where possible
--Home data doesn't necessarily NEED to be in the superheros tables

--create the homes table first, since superheros will have a reference (FK) to the homes table

CREATE TABLE homes (
	home_id serial PRIMARY KEY,
	home_name TEXT,
	street_address TEXT
);

CREATE TABLE superheros (
	hero_id serial PRIMARY KEY, 
	hero_name TEXT,
	hero_power TEXT,
	first_name TEXT,
	last_name TEXT,
	home_base_fk int REFERENCES homes(home_id)
);

INSERT INTO homes (home_name, street_address)
VALUES ('Homelander''s house', '123 street st'),
	   ('Aunt May''s house', '456 street ave');
--if you need a single quote within single quotes, you have to type 2 single quotes

SELECT * FROM homes;

INSERT INTO superheros(hero_name, hero_power, first_name, last_name, home_base_fk)
VALUES ('Homelander', 'laser eyes? pretty much superman... yeah', 'John', 'Doe', 1),
	   ('Spiderman', 'webby boi', 'peter', 'parker', 2),
	   ('Spiderman', 'webby boi', 'miles', 'morales', 2);

SELECT * FROM superheros;

--cool, this database schema is now fully 3NF (which is what we want, and what your P1 should be)
	  
	  