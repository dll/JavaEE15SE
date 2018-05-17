--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `hibernate5cartdb`.`customers` DROP PRIMARY KEY;

ALTER TABLE `hibernate5cartdb`.`addresses` DROP PRIMARY KEY;

ALTER TABLE `hibernate5cartdb`.`customers` DROP INDEX `hibernate5cartdb`.`UK_6wflf7tnihw0xbdoljdkcq02p`;

ALTER TABLE `hibernate5cartdb`.`addresses` DROP INDEX `hibernate5cartdb`.`FKtlnpkjb7p8bgb9kl7m3wx3dcs`;

DROP TABLE `hibernate5cartdb`.`customers`;

DROP TABLE `hibernate5cartdb`.`addresses`;

CREATE TABLE `hibernate5cartdb`.`customers` (
	`customerID` INT NOT NULL,
	`account` VARCHAR(20),
	`password` VARCHAR(20),
	`name` VARCHAR(20),
	`sex` BIT,
	`birthday` DATE,
	`phone` VARCHAR(20),
	`email` VARCHAR(100),
	`address` VARCHAR(200),
	`zipcode` VARCHAR(10),
	`fax` VARCHAR(20),
	PRIMARY KEY (`customerID`)
) ENGINE=InnoDB;

CREATE TABLE `hibernate5cartdb`.`addresses` (
	`addressID` INT NOT NULL,
	`detail` VARCHAR(200),
	`zipcode` VARCHAR(10),
	`phone` VARCHAR(20),
	`type` VARCHAR(20),
	`cust_id` INT,
	PRIMARY KEY (`addressID`)
) ENGINE=InnoDB;

CREATE UNIQUE INDEX `UK_6wflf7tnihw0xbdoljdkcq02p` ON `hibernate5cartdb`.`customers` (`account` ASC);

CREATE INDEX `FKtlnpkjb7p8bgb9kl7m3wx3dcs` ON `hibernate5cartdb`.`addresses` (`cust_id` ASC);

