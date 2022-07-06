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


