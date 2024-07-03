-- MySQL Script generated by MySQL Workbench
-- Wed Jul  3 13:34:27 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema s201n1e1_relational_model
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema s201n1e1_relational_model
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `s201n1e1_relational_model` ;
USE `s201n1e1_relational_model` ;

-- -----------------------------------------------------
-- Table `s201n1e1_relational_model`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s201n1e1_relational_model`.`address` (
  `id_address` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(60) NULL,
  `number` VARCHAR(6) NULL,
  `floor` INT NULL,
  `door` VARCHAR(2) NULL,
  `city` VARCHAR(40) NULL,
  `postal_code` INT NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id_address`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `s201n1e1_relational_model`.`providers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s201n1e1_relational_model`.`providers` (
  `id_provider` INT NOT NULL AUTO_INCREMENT,
  `address_id` INT NULL,
  `catalogue_id` INT NULL,
  `name` VARCHAR(45) NULL,
  `nif` VARCHAR(15) NOT NULL,
  `phone_number` VARCHAR(20) NULL,
  `fax_number` VARCHAR(20) NULL,
  PRIMARY KEY (`id_provider`),
  INDEX `fk_providers_address1_idx` (`address_id` ASC) VISIBLE,
  CONSTRAINT `fk_providers_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `s201n1e1_relational_model`.`address` (`id_address`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `s201n1e1_relational_model`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s201n1e1_relational_model`.`customers` (
  `id_customer` INT UNSIGNED NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `address_id` INT NULL,
  `telephone_number` VARCHAR(20) NOT NULL,
  `e_mail` VARCHAR(45) NULL,
  `registration_date` DATE NOT NULL,
  `reference_customer` VARCHAR(45) NULL,
  `sale_invoice_id` VARCHAR(10) NULL,
  INDEX `fk_customers_address1_idx` (`address_id` ASC) VISIBLE,
  PRIMARY KEY (`id_customer`),
  INDEX `fk_customers_customers1_idx` (`reference_customer` ASC) VISIBLE,
  CONSTRAINT `fk_customers_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `s201n1e1_relational_model`.`address` (`id_address`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customers_customers1`
    FOREIGN KEY (`reference_customer`)
    REFERENCES `s201n1e1_relational_model`.`customers` (`id_customer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `s201n1e1_relational_model`.`employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s201n1e1_relational_model`.`employees` (
  `id_employee` INT NOT NULL AUTO_INCREMENT,
  `adress_id` INT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id_employee`),
  INDEX `fk_employees_address1_idx` (`adress_id` ASC) VISIBLE,
  CONSTRAINT `fk_employees_address1`
    FOREIGN KEY (`adress_id`)
    REFERENCES `s201n1e1_relational_model`.`address` (`id_address`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `s201n1e1_relational_model`.`sale_invoices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s201n1e1_relational_model`.`sale_invoices` (
  `id_sale_invoice` INT NOT NULL AUTO_INCREMENT,
  `employee_id` INT NOT NULL,
  `glasses_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  `sale_invoice_date` DATE NOT NULL,
  PRIMARY KEY (`id_sale_invoice`),
  INDEX `fk_sale_customers1_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `fk_sale_customers1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `s201n1e1_relational_model`.`customers` (`id_customer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sales_employees1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `s201n1e1_relational_model`.`employees` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `s201n1e1_relational_model`.`brands`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s201n1e1_relational_model`.`brands` (
  `id_brand` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) NULL,
  PRIMARY KEY (`id_brand`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `s201n1e1_relational_model`.`glasses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s201n1e1_relational_model`.`glasses` (
  `id_glasses` INT UNSIGNED NOT NULL,
  `provider_id` INT UNSIGNED NOT NULL,
  `sale_invoice_id` INT UNSIGNED NULL,
  `brand_id` INT UNSIGNED NULL,
  `prescription` VARCHAR(45) NULL,
  `frame_type` ENUM("floating", "paste", "metallic") NOT NULL,
  `frame_color` VARCHAR(45) NOT NULL,
  `glass_color` VARCHAR(45) NOT NULL,
  `price` DECIMAL(6,2) NOT NULL,
  `model` VARCHAR(45) NULL,
  PRIMARY KEY (`id_glasses`),
  INDEX `fk_glasses_providers_idx` (`provider_id` ASC) VISIBLE,
  INDEX `fk_glasses_brands1_idx` (`brand_id` ASC) VISIBLE,
  CONSTRAINT `fk_glasses_providers`
    FOREIGN KEY (`provider_id`)
    REFERENCES `s201n1e1_relational_model`.`providers` (`id_provider`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_glasses_sale1`
    FOREIGN KEY (`sale_invoice_id`)
    REFERENCES `s201n1e1_relational_model`.`sale_invoices` (`id_sale_invoice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_glasses_brands1`
    FOREIGN KEY (`brand_id`)
    REFERENCES `s201n1e1_relational_model`.`brands` (`id_brand`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `s201n1e1_relational_model`.`provider_catalogues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s201n1e1_relational_model`.`provider_catalogues` (
  `id_catalogue` INT NOT NULL AUTO_INCREMENT,
  `brand_id` INT NULL,
  `provider_id` INT NULL,
  PRIMARY KEY (`id_catalogue`),
  INDEX `fk_brandsCatalogues(deprecated)_brands1_idx` (`brand_id` ASC) VISIBLE,
  INDEX `fk_brandsCatalogues(deprecated)_providers1_idx` (`provider_id` ASC) VISIBLE,
  CONSTRAINT `fk_brandsCatalogues(deprecated)_brands1`
    FOREIGN KEY (`brand_id`)
    REFERENCES `s201n1e1_relational_model`.`brands` (`id_brand`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_brandsCatalogues(deprecated)_providers1`
    FOREIGN KEY (`provider_id`)
    REFERENCES `s201n1e1_relational_model`.`providers` (`id_provider`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
