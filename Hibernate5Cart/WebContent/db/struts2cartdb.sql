--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `struts2cartdb`.`customerpo` DROP PRIMARY KEY;

ALTER TABLE `struts2cartdb`.`items` DROP PRIMARY KEY;

ALTER TABLE `struts2cartdb`.`cards` DROP PRIMARY KEY;

ALTER TABLE `struts2cartdb`.`users` DROP PRIMARY KEY;

ALTER TABLE `struts2cartdb`.`orders` DROP PRIMARY KEY;

DROP TABLE `struts2cartdb`.`items`;

DROP TABLE `struts2cartdb`.`orders`;

DROP TABLE `struts2cartdb`.`users`;

DROP TABLE `struts2cartdb`.`cards`;

DROP TABLE `struts2cartdb`.`customerpo`;

CREATE TABLE `struts2cartdb`.`cards` (
	`name` VARCHAR(20) NOT NULL,
	`cardno` VARCHAR(20),
	`password` VARCHAR(20),
	PRIMARY KEY (`name`)
) ENGINE=InnoDB;

CREATE TABLE `struts2cartdb`.`items` (
	`itemID` VARCHAR(20) NOT NULL,
	`title` VARCHAR(20),
	`description` VARCHAR(255),
	`cost` DOUBLE,
	`inventory` INT,
	`image` VARCHAR(100),
	PRIMARY KEY (`itemID`)
) ENGINE=InnoDB;

CREATE TABLE `struts2cartdb`.`orders` (
	`orderid` VARCHAR(20) NOT NULL,
	`productname` VARCHAR(20),
	`productnum` VARCHAR(20),
	`username` VARCHAR(20),
	`setstate` VARCHAR(20),
	`paystate` VARCHAR(20),
	`receiver` VARCHAR(20),
	`settime` VARCHAR(20),
	`gettime` VARCHAR(20),
	`email` VARCHAR(20),
	`telephone` VARCHAR(20),
	`address` VARCHAR(20),
	PRIMARY KEY (`orderid`)
) ENGINE=InnoDB;

CREATE TABLE `struts2cartdb`.`customerpo` (
	`id` INT NOT NULL,
	`account` VARCHAR(20),
	`password` VARCHAR(20),
	`name` VARCHAR(20),
	`gender` VARCHAR(10),
	`birthday` DATETIME,
	`address` VARCHAR(100),
	`phone` VARCHAR(20),
	`email` VARCHAR(20),
	`usertype` INT,
	`hobby` VARCHAR(100),
	`introduction` VARCHAR(255),
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `struts2cartdb`.`users` (
	`account` VARCHAR(20) NOT NULL,
	`password` VARCHAR(20),
	`usertype` INT,
	PRIMARY KEY (`account`)
) ENGINE=InnoDB;

