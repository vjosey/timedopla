-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema timedopla
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema timedopla
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `timedopla` DEFAULT CHARACTER SET utf8 ;
USE `timedopla` ;

-- -----------------------------------------------------
-- Table `timedopla`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timedopla`.`role` (
  `roleId` INT NOT NULL AUTO_INCREMENT,
  `roletype` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`roleId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `timedopla`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timedopla`.`user` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `firstname` VARCHAR(20) NOT NULL,
  `lastname` VARCHAR(20) NOT NULL,
  `pcode` VARCHAR(32) NOT NULL,
  `roleId` INT NULL,
  PRIMARY KEY (`userid`),
  CONSTRAINT `fk_user_role1`
    FOREIGN KEY (`roleId`)
    REFERENCES `timedopla`.`role` (`roleId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `timedopla`.`tsstatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timedopla`.`tsstatus` (
  `tsstaatusId` INT NOT NULL AUTO_INCREMENT,
  `statusname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tsstaatusId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `timedopla`.`timesheet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timedopla`.`timesheet` (
  `tsheetId` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  `startweek` DATE NOT NULL,
  `tsStatus` INT NULL,
  PRIMARY KEY (`tsheetId`),
  CONSTRAINT `userId`
    FOREIGN KEY (`userId`)
    REFERENCES `timedopla`.`user` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tsstatusId`
    FOREIGN KEY (`tsStatus`)
    REFERENCES `timedopla`.`tsstatus` (`tsstaatusId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
INSERT_METHOD = FIRST;


-- -----------------------------------------------------
-- Table `timedopla`.`Punchcard`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timedopla`.`Punchcard` (
  `pcardId` INT NOT NULL AUTO_INCREMENT,
  `timesheetId` INT NOT NULL,
  `date` DATE NOT NULL,
  `amIn` INT(64) NULL,
  `amOut` INT(64) NULL,
  `pmIn` INT(64) NULL,
  `pmOut` INT(64) NULL,
  PRIMARY KEY (`pcardId`, `timesheetId`),
  CONSTRAINT `timesheetId`
    FOREIGN KEY (`timesheetId`)
    REFERENCES `timedopla`.`timesheet` (`tsheetId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
