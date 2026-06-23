-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema inscripcion_cursos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema inscripcion_cursos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `inscripcion_cursos` DEFAULT CHARACTER SET utf8 ;
USE `inscripcion_cursos` ;

-- -----------------------------------------------------
-- Table `inscripcion_cursos`.`cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inscripcion_cursos`.`cursos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre_cursos` VARCHAR(45) NOT NULL,
  `duracion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idcursos_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inscripcion_cursos`.`estudiantes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inscripcion_cursos`.`estudiantes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre_estudiante` VARCHAR(45) NOT NULL,
  `edad` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inscripcion_cursos`.`inscripciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inscripcion_cursos`.`inscripciones` (
  `cursos_id` INT NOT NULL,
  `estudiantes_id` INT NOT NULL,
  PRIMARY KEY (`cursos_id`, `estudiantes_id`),
  INDEX `fk_cursos_has_estudiantes_estudiantes1_idx` (`estudiantes_id` ASC) VISIBLE,
  INDEX `fk_cursos_has_estudiantes_cursos_idx` (`cursos_id` ASC) VISIBLE,
  CONSTRAINT `fk_cursos_has_estudiantes_cursos`
    FOREIGN KEY (`cursos_id`)
    REFERENCES `inscripcion_cursos`.`cursos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursos_has_estudiantes_estudiantes1`
    FOREIGN KEY (`estudiantes_id`)
    REFERENCES `inscripcion_cursos`.`estudiantes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
