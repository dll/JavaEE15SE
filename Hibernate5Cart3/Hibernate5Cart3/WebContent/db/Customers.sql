--<ScriptOptions statementTerminator=";"/>

CREATE TABLE customers (
	customerID INT NOT NULL,
	account VARCHAR(20),
	password VARCHAR(20),
	name VARCHAR(20),
	sex BIT,
	birthday DATE,
	phone VARCHAR(20),
	email VARCHAR(100),
	address VARCHAR(200),
	zipcode VARCHAR(10),
	fax VARCHAR(20),
	PRIMARY KEY (customerID)
) ENGINE=InnoDB;

CREATE UNIQUE INDEX UK_6wflf7tnihw0xbdoljdkcq02p ON customers (account ASC);

