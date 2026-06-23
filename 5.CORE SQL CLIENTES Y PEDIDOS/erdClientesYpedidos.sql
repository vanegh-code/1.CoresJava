-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema CoreClientesYpedidos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CoreClientesYpedidos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CoreClientesYpedidos` DEFAULT CHARACTER SET utf8 ;
USE `CoreClientesYpedidos` ;

-- -----------------------------------------------------
-- Table `CoreClientesYpedidos`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CoreClientesYpedidos`.`clientes` (
  `id_clientes` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_clientes`),
  UNIQUE INDEX `id_clientes_UNIQUE` (`id_clientes` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CoreClientesYpedidos`.`pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CoreClientesYpedidos`.`pedidos` (
  `id_pedidos` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `total` INT NOT NULL,
  `clientes_id_clientes` INT NOT NULL,
  PRIMARY KEY (`id_pedidos`, `clientes_id_clientes`),
  UNIQUE INDEX `id_pedidos_UNIQUE` (`id_pedidos` ASC) VISIBLE,
  INDEX `fk_pedidos_clientes_idx` (`clientes_id_clientes` ASC) VISIBLE,
  CONSTRAINT `fk_pedidos_clientes`
    FOREIGN KEY (`clientes_id_clientes`)
    REFERENCES `CoreClientesYpedidos`.`clientes` (`id_clientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
