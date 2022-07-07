--This SQL Script will demonstrate 1st-3rd Normal Form 

--Then we'll get into joins and set operations


--A table in 1st NF
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

--2NF--------------------


	  
	  
	  
	  