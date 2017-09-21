-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema AxPortal
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `AxPortal` ;

-- -----------------------------------------------------
-- Schema AxPortal
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `AxPortal` DEFAULT CHARACTER SET utf8 ;
USE `AxPortal` ;

-- -----------------------------------------------------
-- Table `AxPortal`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AxPortal`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(50) NOT NULL,
  `nivel` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AxPortal`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AxPortal`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `password` VARCHAR(10) NOT NULL,
  `datacadastro` DATETIME NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_role_idx` (`role_id` ASC),
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `AxPortal`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AxPortal`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AxPortal`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `cpf` VARCHAR(20) NOT NULL,
  `email` VARCHAR(50) NULL,
  `phone` BIGINT(20) NULL,
  `vip` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
