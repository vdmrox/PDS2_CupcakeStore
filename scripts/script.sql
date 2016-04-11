-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: dbCupcakeStore2
-- Source Schemata: dbCupcakeStore
-- Created: Mon Apr 11 15:06:39 2016
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;;

-- ----------------------------------------------------------------------------
-- Schema dbCupcakeStore2
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `dbCupcakeStore2` ;
CREATE SCHEMA IF NOT EXISTS `dbCupcakeStore2` ;

-- ----------------------------------------------------------------------------
-- Table dbCupcakeStore2.TB_PEDIDO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbCupcakeStore2`.`TB_PEDIDO` (
  `pe_id` INT(11) NOT NULL,
  `ps_id` INT(11) NULL DEFAULT NULL,
  `pe_data` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`pe_id`),
  INDEX `ps_id_idx` (`ps_id` ASC),
  CONSTRAINT `ps_id`
    FOREIGN KEY (`ps_id`)
    REFERENCES `dbCupcakeStore2`.`TB_PESSOA` (`ps_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table dbCupcakeStore2.TB_PESSOA
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbCupcakeStore2`.`TB_PESSOA` (
  `ps_id` INT(11) NOT NULL,
  `ps_tipo` VARCHAR(100) NULL DEFAULT NULL,
  `ps_nome` VARCHAR(200) NULL DEFAULT NULL,
  `ps_cidade` VARCHAR(45) NULL DEFAULT NULL,
  `ps_uf` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ps_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table dbCupcakeStore2.TB_SABORES
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbCupcakeStore2`.`TB_SABORES` (
  `sa_id` INT(11) NOT NULL AUTO_INCREMENT,
  `sa_desc` VARCHAR(100) NULL DEFAULT NULL,
  `sa_valor` DOUBLE(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`sa_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;
SET FOREIGN_KEY_CHECKS = 1;;
