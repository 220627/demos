--The first thing I want to do is create two tables with a relationship
--(using primary keys and foreign keys)

--This schema will track owners and their capybaras

--owners table
CREATE TABLE owners(
	owner_id serial PRIMARY KEY, --The primary key uniquely identifies each record in a table. Typically an ID.
	--serial is an auto-incrementing int data type. We don't need to give it a value when we insert data.
	--whenever we insert a new owner, the owner_id field will be auto-generated
	owner_name TEXT NOT NULL -- since this column has a NOT NULL constraint, we must provide values
);

--capybaras table 
CREATE TABLE capybaras(
	capy_id serial PRIMARY KEY,
	fur_color TEXT,
	age int CHECK(age > 1), --no baby capybaras are allows to be pets
	--this check makes it so that we can't insert a capybara with age 1 or lower.
	owner_id_fk int REFERENCES owners (owner_id) --this is a FOREIGN KEY. (note the use of "references")
	--this is saying, this column is bound to the primary key of the owners table (owner_id)
	--THIS IS HOW WE ESTABLISH RELATIONSHIPS BETWEEN TABLES. 
	--Now, every capybara must have one owner whereas an owner can have zero, one, or multiple capybaras
);

--Would it have been possible to create the capybara table first?
--No, because it would refernce the owners table which wouldn't exist yet.
--As a rule of thumb, you want to make the table that other tables depend on FIRST.

--what if we try to DROP the owners table while capybara depends on it?
DROP TABLE owners;
--if a table has other tables referencing it, SQL won't allow you unless you use CASCADE 

DROP TABLE owners CASCADE; --this CASCADEs any changes to all dependent tables. the changes cascade over 
DROP TABLE capybaras;

--DML------------------------------------------------------------------

--DML (Data Manipulation Language): Select, Insert, Update, Delete

--INSERT some data into the owners and capybaras tables

--In INSERT statements, we specify what table and what column we're inserting data into
--and then, we can specify one or many records to insert.
--so Constantine, Sekhar, and Matthew are 3 individual owner records
INSERT INTO owners (owner_name)
VALUES ('Constantine'), ('Sekhar'), ('Matthew'); 

--we can use SELECT to view the data in the table
SELECT * FROM owners; --we use * to select every column from the records (as opposed to only selecting some)
--Notice how the owner_id was made for us - it's serial so we don't have to include it in the insert statement.

INSERT INTO capybaras (fur_color, age, owner_id_fk)
VALUES ('brown', 5, 1), ('brown', 10, 1), ('tan', 6, 2), ('black', 2, 3);

SELECT * FROM capybaras;

--Notice how every capybara need one and only one owner (owner_id_fk is a column)
--BUT an owner can have zero or no capybaras
--This is what's known as a one-to-many relationship (more on multiplicity later)
--In this case, one owner can have many (or zero) capybaras. Capybaras can only have one owner.
--the capybaras table is the "many" side, and the owners table is the "one" side.

--we can also SELECT data from specific columns instead of all columns
SELECT owner_name FROM owners;

SELECT age, owner_id_fk FROM capybaras; 

--the WHERE clause-----------------------------------------------------------

--the WHERE clause in a SELECT statement lets us further filter our data

--all capybaras with brown fur (=)
SELECT * FROM capybaras WHERE fur_color = 'brown';

--all capybaras who don't have brown fur (!=)
SELECT * FROM capybaras WHERE fur_color != 'brown';

--all capybaras who are younger than 7 (<)
SELECT * FROM capybaras WHERE age < 7;

--all owners whos names start with C (like) (%)
SELECT * FROM owners WHERE owner_name LIKE 'C%'; --must start with "C", anything after doesn't matter

--all owners with an 'e' in their name
SELECT * FROM owners WHERE owner_name LIKE '%e%'; --must contain "e", anything before or after doesn't matter

--capybaras who are between 5 and 8 years old (between) (and)
SELECT * FROM capybaras WHERE age BETWEEN 5 AND 8;

--capybaras who are owned by Sekhar or Matthew (or) or (in)
SELECT * FROM capybaras WHERE owner_id_fk = 2 OR owner_id_fk = 3;
SELECT * FROM capybaras WHERE owner_id_fk IN (2, 3); --this is faster

--Also important is the ORDER BY clause, which lets us return data in some order

SELECT * FROM capybaras ORDER BY age; --this returns the capybaras in ascending age order

SELECT * FROM capybaras ORDER BY age DESC; --this returns the capybaras in descending age order

--we can also order by alphabetical order
SELECT * FROM owners ORDER BY owner_name; 

--functions------------------------------------------------------------------

--scalar functions take in one value (or zero values), and return one value

SELECT now();

--aggregate functions take in mulitple values and return one value

SELECT avg(age) FROM capybaras;

--What is this "AS minimum age" thing?
--this is an alias, which essentially renames a column to be used in the output
SELECT min(age) AS "minimum age" FROM capybaras;

-----------------------------------------------------------------------------

--we can also UPDATE values in our tables
--be careful! you should ALWAYS use a WHERE clause, or every single row will get updated

--This will update Matthew's name to "Matt"
UPDATE owners SET owner_name = 'Matt' WHERE owner_name = 'Matthew';

SELECT * FROM owners;

--we can DELETE rows too. I don't delete data often... when you save (persist) data, it's usually meant to stay
DELETE FROM capybaras WHERE capy_id = 1; --sorry Constantine

--we wouldn't be able to delete an owner though
DELETE FROM owners WHERE owner_id = 1;

--we would have needed to add "on delete cascade" to the capybaras table in order for deletes to work. 
--this would be added after the foreign key declaration, but we didn't do it here

--how come cascade works with the DROP statement?
--DROP is DDL, which just needs CASCADE at the end
--for DML like delete and update you need "on delete cascade" or "on update cascade" on your foreign key
