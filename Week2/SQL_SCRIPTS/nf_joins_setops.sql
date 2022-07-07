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

DROP TABLE homes;

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
	  
--(JOINS)---------------------------------------

--Remember, joins are necessary when we want to SELECT data from multiple tables. Multi-table queries!

--one more INSERT for each table to better demonstrate joins

--this superhero has no home, it'll help demonstrate joins
INSERT INTO superheros(hero_name, hero_power, first_name, last_name)
VALUES ('Hancock', 'slappin'' people',  'Will', 'Smith');

--this home will not have any hero with it as a home_base_fk
INSERT INTO homes (home_name, street_address)
VALUES ('Panera Bread', '1337 bread blvd');

--note the keywords used in joins:
--we specify the type of join, and what table/column we're joining ON

--INNER JOIN
--returns all records with matching data (from the PK/FK) in both table
SELECT * FROM superheros INNER JOIN homes ON home_id = home_base_fk;
--"select every record from superheros and homes where the home_id and home_base_fk match
--Notice we don't get Hancock here, or Panera Bread, because they don't have any FK/PK matches

--FULL OUTER JOIN
--returns all records regardless of matches
SELECT * FROM superheros FULL OUTER JOIN homes ON home_id = home_base_fk; 

--LEFT OUTER JOIN
--return everything in the LEFT TABLE, and matching rows in the right table
SELECT * FROM superheros LEFT OUTER JOIN homes ON home_id = home_base_fk; 
--we get hancock since superheros are on the left, but we don't get panera, because it's on the right

--RIGHT OUTER JOIN
--return everything in the RIGHT TABLE, and matching rows in the left table
SELECT * FROM superheros RIGHT OUTER JOIN homes ON home_id = home_base_fk; 
--we get panera since it's on the right table, but not hancock, because it's on the left with no matches.

--Joins are how we make our select statements include more data (spanning multiple tables)
--we can select * from superheros, and the most home data we would get is the home_id
--what if we need all the data from heros and homes? Better use a join!

--(SET OPERATIONS)--------------------------------------

SELECT * FROM superheros;
SELECT * FROM homes;

--UNION
--All distinct records from both queries - no duplicates
SELECT home_base_fk FROM superheros UNION SELECT home_id FROM homes;

--UNION ALL
--All distinct records from both queries - including duplicates
SELECT home_base_fk FROM superheros UNION ALL SELECT home_id FROM homes;

--INTERSECT
--Returns unique rows (no duplicates) found in BOTH queries
SELECT home_base_fk FROM superheros INTERSECT SELECT home_id FROM homes;

--EXCEPT
--Return unique rows (no duplicates) in the first query that DON'T appear in the second query
SELECT home_base_fk FROM superheros EXCEPT SELECT home_id FROM homes;



	  