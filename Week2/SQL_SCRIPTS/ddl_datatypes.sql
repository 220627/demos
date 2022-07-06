--To create a new schema (which we'll do for each individual project): 
--right click the schemas folder, create new schema, give it a name

--Then, to create this file, right click your schema, SQL editor, new SQL script

--Data Definition Language (DDL): CREATE, ALTER, TRUNCATE, DROP
--DDL is any SQL command that relates to building the structure of your data (typically tables)

--the create command will CREATE a database table
CREATE TABLE users(
	username TEXT --username is the name of a column, text is the datatype
);

--we created a (bad) table of users that simply tracks usernames

--we can view this table by right clicking the schema -> view diagram
--don't forget to right click schema and refresh for the changes to actually show

--OH NO! I meant to add an age column to my table. I can use the ALTER command to change or add columns
ALTER TABLE users ADD user_age int;

--I won't run the two commands below, but I will write them out for the sake of syntax

--we can use TRUNCATE to wipe all the data from a table
TRUNCATE TABLE users;

--we can use DROP to delete a table entirely
DROP TABLE users;


--DATA TYPES-------------------------------------------------------------------

--I'm going to make a horribly designed table just to demonstrate SQL data types
--Why is this table bad? No primary key, not normalized

--Note that each column is delimited by commas
CREATE TABLE datatypes(
	small_number int2, --2 bytes, for smaller numbers (like a short in Java)
	normal_number int, --4 bytes, most common int type (also known as int4)
	big_number int8, --8 bytes, for big numbers (like a long in Java)
	standard_decimal decimal(10, 2), --2 parameters: (total # of digits, # of decimal places)
	--so this decimal has 10 total digits, with 2 decimal places
	
	"boolean" boolean, --double quotes let you use keywords as column names, etc.
	
	fixed_length_text char(2), --text field that can hold the amount of characters specified. 2 in this case
	variable_length_text varchar(15), --text field that can hold UP TO the amount of characters given
	unlimited_length_text TEXT, --unlimited length, best practice if you don't need to limit your characters
	
	"date" date --lets you input a date in YYYY-MM-DD format
	
	--because date is the last column, we don't a comma
);

--This is NOT all the datatypes we have... there are so many
--but most likely you won't need to use any that aren't listed here.






