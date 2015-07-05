DROP DATABASE `baymax`;

create database `baymax`;

USE `baymax`;

CREATE TABLE `identity.USER` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DEVICE_ID` varchar(45) DEFAULT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `PASSWORD` varchar(45) DEFAULT NULL,
  `DATE_CREATED` datetime DEFAULT NULL,
  `DATE_MODIFIED` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema baymax
-- -----------------------------------------------------
-- Schema used with the CommerceY application

-- -----------------------------------------------------
-- Schema baymax
--
-- Schema used with the CommerceY application
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `baymax` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `baymax` ;

-- -----------------------------------------------------
-- Table `baymax`.`customer_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baymax`.`customer_type` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = 'maintain the type of the customer';


-- -----------------------------------------------------
-- Table `baymax`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baymax`.`customer` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(2) NOT NULL,
  `customer_type_id` INT UNSIGNED NOT NULL,
  `wechat_openid` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_customer_customer_type1_idx` (`customer_type_id` ASC),
  CONSTRAINT `fk_customer_customer_type1`
    FOREIGN KEY (`customer_type_id`)
    REFERENCES `baymax`.`customer_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = 'maintains customer details';


-- -----------------------------------------------------
-- Table `baymax`.`product_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baymax`.`product_category` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = 'maitain the category of the product';


-- -----------------------------------------------------
-- Table `baymax`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baymax`.`product` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL(5,2) NOT NULL,
  `description` TINYTEXT NULL,
  `last_update` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `product_category_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_product_category1_idx` (`product_category_id` ASC),
  CONSTRAINT `fk_product_product_category1`
    FOREIGN KEY (`product_category_id`)
    REFERENCES `baymax`.`product_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = 'maintain product details';


-- -----------------------------------------------------
-- Table `baymax`.`order_state`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baymax`.`order_state` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = 'maintain state of an order';


-- -----------------------------------------------------
-- Table `baymax`.`payment_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baymax`.`payment_type` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` NVARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = 'maintain the payment type of an order';


-- -----------------------------------------------------
-- Table `baymax`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baymax`.`order` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `amount` DECIMAL(6,2) NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `order_state_id` INT UNSIGNED NOT NULL,
  `customer_id` INT UNSIGNED NOT NULL,
  `payment_time` TIMESTAMP NULL,
  `payment_result` INT NOT NULL,
  `payment_type_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_order_state_idx` (`order_state_id` ASC),
  INDEX `fk_order_customer1_idx` (`customer_id` ASC),
  INDEX `fk_order_payment_type1_idx` (`payment_type_id` ASC),
  CONSTRAINT `fk_order_order_state`
    FOREIGN KEY (`order_state_id`)
    REFERENCES `baymax`.`order_state` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `baymax`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_payment_type1`
    FOREIGN KEY (`payment_type_id`)
    REFERENCES `baymax`.`payment_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = 'maintain the order info';


-- -----------------------------------------------------
-- Table `baymax`.`basket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baymax`.`basket` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `amount` DECIMAL(6,2) NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `customer_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_basket_customer1_idx` (`customer_id` ASC),
  CONSTRAINT `fk_basket_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `baymax`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = 'maintain the basket when customer buying products';


-- -----------------------------------------------------
-- Table `baymax`.`order_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baymax`.`order_item` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_id` INT UNSIGNED NOT NULL,
  `product_id` INT UNSIGNED NOT NULL,
  `quantity` INT NOT NULL,
  INDEX `fk_order_has_product_product1_idx` (`product_id` ASC),
  INDEX `fk_order_has_product_order1_idx` (`order_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_order_has_product_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `baymax`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_has_product_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `baymax`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `baymax`.`basket_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baymax`.`basket_item` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `basket_id` INT UNSIGNED NOT NULL,
  `product_id` INT UNSIGNED NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_basket_has_product_product1_idx` (`product_id` ASC),
  INDEX `fk_basket_has_product_basket1_idx` (`basket_id` ASC),
  CONSTRAINT `fk_basket_has_product_basket1`
    FOREIGN KEY (`basket_id`)
    REFERENCES `baymax`.`basket` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_basket_has_product_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `baymax`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;