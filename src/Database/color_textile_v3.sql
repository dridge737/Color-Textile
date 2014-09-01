SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `color_textile` DEFAULT CHARACTER SET latin1 ;
USE `color_textile` ;

-- -----------------------------------------------------
-- Table `color_textile`.`colorway`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `color_textile`.`colorway` (
  `id_colorway` INT(11) NOT NULL AUTO_INCREMENT ,
  `colorway_name` VARCHAR(45) NULL DEFAULT NULL ,
  `binder` FLOAT NULL DEFAULT NULL ,
  `weight_kg` FLOAT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_colorway`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `color_textile`.`colorway_screen_connect`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `color_textile`.`colorway_screen_connect` (
  `id_color_screen` INT(11) NOT NULL AUTO_INCREMENT ,
  `id_screen` INT(11) NULL DEFAULT NULL ,
  `id_colorway` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_color_screen`) )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `color_textile`.`customer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `color_textile`.`customer` (
  `id_customer` INT(11) NOT NULL AUTO_INCREMENT ,
  `customer_name` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_customer`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `color_textile`.`design`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `color_textile`.`design` (
  `design_code` VARCHAR(45) NOT NULL ,
  `design_name` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`design_code`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `color_textile`.`design_colorway_connect`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `color_textile`.`design_colorway_connect` (
  `id_design_colorway` INT(11) NOT NULL AUTO_INCREMENT ,
  `design_code` VARCHAR(45) NULL DEFAULT NULL ,
  `id_colorway` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_design_colorway`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `color_textile`.`job_order`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `color_textile`.`job_order` (
  `id_job_order` INT(11) NOT NULL AUTO_INCREMENT ,
  `date` DATE NULL DEFAULT NULL ,
  `quantity` INT(11) NULL DEFAULT NULL ,
  `fabric_style` VARCHAR(45) NULL DEFAULT NULL ,
  `id_customer` INT(11) NULL DEFAULT NULL ,
  `design_code` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_job_order`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `color_textile`.`pigment`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `color_textile`.`pigment` (
  `pigment_no` INT(11) NOT NULL AUTO_INCREMENT ,
  `pigment_name` VARCHAR(45) NOT NULL ,
  `stock` INT(11) NULL DEFAULT NULL ,
  `tingi` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`pigment_no`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `color_textile`.`screen_pigment`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `color_textile`.`screen_pigment` (
  `id_screen` INT(11) NOT NULL ,
  `pigment_no` INT(11) NULL DEFAULT NULL ,
  `pigment_percentage` FLOAT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_screen`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

USE `color_textile` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
