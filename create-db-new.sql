DROP SCHEMA IF EXISTS `Car-Sharing-db`;

CREATE SCHEMA `Car-Sharing-db`;

use `Car-Sharing-db`;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `Company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50)  NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `Car` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `company_id` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`company_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`company_id`) 
  REFERENCES `Company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  KEY `FK_INSTRUCTOR_idx` (`customer_id`),
  CONSTRAINT `FK_INSTRUCTOR` 
  FOREIGN KEY (`customer_id`) 
  REFERENCES `Customer` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `Customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  
  PRIMARY KEY (`id`),
  UNIQUE KEY `TITLE_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



SET FOREIGN_KEY_CHECKS = 1;
