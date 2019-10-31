-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ShmokersTravel
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ShmokersTravel
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ShmokersTravel` DEFAULT CHARACTER SET utf8mb4 ;
USE `ShmokersTravel` ;

-- -----------------------------------------------------
-- Table `ShmokersTravel`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ShmokersTravel`.`User` ;

CREATE TABLE IF NOT EXISTS `ShmokersTravel`.`User` (
  `id` INT(6) NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(45) NOT NULL,
  `phone` INT(11) NULL DEFAULT NULL,
  `email` VARCHAR(45) NOT NULL,
  `FirstName` VARCHAR(45) NULL DEFAULT NULL,
  `LastName` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `ShmokersTravel`.`TrainStation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ShmokersTravel`.`TrainStation` ;

CREATE TABLE IF NOT EXISTS `ShmokersTravel`.`TrainStation` (
  `Name` VARCHAR(45) NOT NULL,
  `Address` VARCHAR(45) NULL,
  PRIMARY KEY (`Name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ShmokersTravel`.`Route`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ShmokersTravel`.`Route` ;

CREATE TABLE IF NOT EXISTS `ShmokersTravel`.`Route` (
  `RouteId` INT NOT NULL,
  `DepartureTrainStationName` VARCHAR(45) NOT NULL,
  `ArribalTrainStationName` VARCHAR(45) NOT NULL,
  `DepartureDate` DATETIME NULL,
  `ArrivalDate` DATETIME NULL,
  PRIMARY KEY (`RouteId`, `DepartureTrainStationName`, `ArribalTrainStationName`),
  INDEX `DepartureTrainStationName_idx` (`DepartureTrainStationName` ASC) VISIBLE,
  INDEX `ArrivalTrainStationName_idx` (`ArribalTrainStationName` ASC) VISIBLE,
  CONSTRAINT `DepartureTrainStationName`
    FOREIGN KEY (`DepartureTrainStationName`)
    REFERENCES `ShmokersTravel`.`TrainStation` (`Name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ArrivalTrainStationName`
    FOREIGN KEY (`ArribalTrainStationName`)
    REFERENCES `ShmokersTravel`.`TrainStation` (`Name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ShmokersTravel`.`Train`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ShmokersTravel`.`Train` ;

CREATE TABLE IF NOT EXISTS `ShmokersTravel`.`Train` (
  `TrainNumber` INT NOT NULL,
  `RouteId` INT NULL,
  `DeaprtureTrainStationName` VARCHAR(45) NULL,
  `ArrivalTrainStationName` VARCHAR(45) NULL,
  PRIMARY KEY (`TrainNumber`),
  INDEX `ArrivalTrainStationName_idx` (`ArrivalTrainStationName` ASC) VISIBLE,
  INDEX `DepartureTrainStationName_idx` (`DeaprtureTrainStationName` ASC) VISIBLE,
  INDEX `RouteId_idx` (`RouteId` ASC) VISIBLE,
  CONSTRAINT `RouteId`
    FOREIGN KEY (`RouteId`)
    REFERENCES `ShmokersTravel`.`Route` (`RouteId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `DepartureTrainStationName`
    FOREIGN KEY (`DeaprtureTrainStationName`)
    REFERENCES `ShmokersTravel`.`Route` (`DepartureTrainStationName`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ArrivalTrainStationName`
    FOREIGN KEY (`ArrivalTrainStationName`)
    REFERENCES `ShmokersTravel`.`Route` (`ArribalTrainStationName`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ShmokersTravel`.`Seat`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ShmokersTravel`.`Seat` ;

CREATE TABLE IF NOT EXISTS `ShmokersTravel`.`Seat` (
  `SeatNumber` INT NOT NULL,
  `VagonNumber` INT NOT NULL,
  `TrainNumber` INT NOT NULL,
  PRIMARY KEY (`SeatNumber`, `VagonNumber`, `TrainNumber`),
  INDEX `TrainNumber_idx` (`TrainNumber` ASC) VISIBLE,
  CONSTRAINT `TrainNumber`
    FOREIGN KEY (`TrainNumber`)
    REFERENCES `ShmokersTravel`.`Train` (`TrainNumber`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ShmokersTravel`.`Ticket`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ShmokersTravel`.`Ticket` ;

CREATE TABLE IF NOT EXISTS `ShmokersTravel`.`Ticket` (
  `id` INT NOT NULL,
  `Price` INT NULL,
  `Date` DATETIME NULL,
  `PassengerId` INT NULL,
  `RouteId` INT NOT NULL,
  `DepartureTrainStationName` VARCHAR(45) NOT NULL,
  `ArrivalTrainStationName` VARCHAR(45) NOT NULL,
  `SeatNumber` INT NULL,
  `VagonNumber` INT NULL,
  `TrainNumber` INT NULL,
  PRIMARY KEY (`id`, `ArrivalTrainStationName`, `DepartureTrainStationName`, `RouteId`),
  INDEX `PassengerId_idx` (`PassengerId` ASC) VISIBLE,
  INDEX `ArrivalTrainStationName_idx` (`ArrivalTrainStationName` ASC) VISIBLE,
  INDEX `DeaprtureTrainStatoinName_idx` (`DepartureTrainStationName` ASC) VISIBLE,
  INDEX `RouteId_idx` (`RouteId` ASC) VISIBLE,
  INDEX `TrainNumber_idx` (`TrainNumber` ASC) VISIBLE,
  INDEX `VagonNumber_idx` (`VagonNumber` ASC) VISIBLE,
  INDEX `SeatNumber_idx` (`SeatNumber` ASC) VISIBLE,
  CONSTRAINT `PassengerId`
    FOREIGN KEY (`PassengerId`)
    REFERENCES `ShmokersTravel`.`User` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `RouteId`
    FOREIGN KEY (`RouteId`)
    REFERENCES `ShmokersTravel`.`Route` (`RouteId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `DeaprtureTrainStatoinName`
    FOREIGN KEY (`DepartureTrainStationName`)
    REFERENCES `ShmokersTravel`.`Route` (`DepartureTrainStationName`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ArrivalTrainStationName`
    FOREIGN KEY (`ArrivalTrainStationName`)
    REFERENCES `ShmokersTravel`.`Route` (`ArribalTrainStationName`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `SeatNumber`
    FOREIGN KEY (`SeatNumber`)
    REFERENCES `ShmokersTravel`.`Seat` (`SeatNumber`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `VagonNumber`
    FOREIGN KEY (`VagonNumber`)
    REFERENCES `ShmokersTravel`.`Seat` (`VagonNumber`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `TrainNumber`
    FOREIGN KEY (`TrainNumber`)
    REFERENCES `ShmokersTravel`.`Seat` (`TrainNumber`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ShmokersTravel`.`AvailiableRoute`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ShmokersTravel`.`AvailiableRoute` ;

CREATE TABLE IF NOT EXISTS `ShmokersTravel`.`AvailiableRoute` (
  `SeatNumber` INT NOT NULL,
  `VagonNumber` INT NOT NULL,
  `RouteId` INT NOT NULL,
  `DepartureTrainStationName` VARCHAR(45) NOT NULL,
  `ArrivalTrainStationName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`RouteId`, `ArrivalTrainStationName`, `DepartureTrainStationName`, `SeatNumber`, `VagonNumber`),
  INDEX `ArrivalTrainStationName_idx` (`ArrivalTrainStationName` ASC) VISIBLE,
  INDEX `DepartureTrainStationName_idx` (`DepartureTrainStationName` ASC) VISIBLE,
  INDEX `RouteId_idx` (`RouteId` ASC) VISIBLE,
  INDEX `VagonNumber_idx` (`VagonNumber` ASC) VISIBLE,
  CONSTRAINT `SeatNumber`
    FOREIGN KEY (`SeatNumber`)
    REFERENCES `ShmokersTravel`.`Seat` (`SeatNumber`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `VagonNumber`
    FOREIGN KEY (`VagonNumber`)
    REFERENCES `ShmokersTravel`.`Seat` (`VagonNumber`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `RouteId`
    FOREIGN KEY (`RouteId`)
    REFERENCES `ShmokersTravel`.`Route` (`RouteId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `DepartureTrainStationName`
    FOREIGN KEY (`DepartureTrainStationName`)
    REFERENCES `ShmokersTravel`.`Route` (`DepartureTrainStationName`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ArrivalTrainStationName`
    FOREIGN KEY (`ArrivalTrainStationName`)
    REFERENCES `ShmokersTravel`.`Route` (`ArribalTrainStationName`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ShmokersTravel`.`MidStations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ShmokersTravel`.`MidStations` ;

CREATE TABLE IF NOT EXISTS `ShmokersTravel`.`MidStations` (
  `RouteId` INT NOT NULL,
  `TrainStationName` VARCHAR(45) NOT NULL,
  `DateTime` DATETIME NULL,
  PRIMARY KEY (`RouteId`, `TrainStationName`),
  INDEX `TrainStationName_idx` (`TrainStationName` ASC) VISIBLE,
  CONSTRAINT `RoutId`
    FOREIGN KEY (`RouteId`)
    REFERENCES `ShmokersTravel`.`Route` (`RouteId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `TrainStationName`
    FOREIGN KEY (`TrainStationName`)
    REFERENCES `ShmokersTravel`.`TrainStation` (`Name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ShmokersTravel`.`Manager`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ShmokersTravel`.`Manager` ;

CREATE TABLE IF NOT EXISTS `ShmokersTravel`.`Manager` (
  `ManagerId` INT NOT NULL,
  `Discount` INT NULL,
  PRIMARY KEY (`ManagerId`),
  CONSTRAINT `ManagerId`
    FOREIGN KEY (`ManagerId`)
    REFERENCES `ShmokersTravel`.`User` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ShmokersTravel`.`Agent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ShmokersTravel`.`Agent` ;

CREATE TABLE IF NOT EXISTS `ShmokersTravel`.`Agent` (
  `AgentId` INT NOT NULL,
  `Discount` INT NULL,
  PRIMARY KEY (`AgentId`),
  CONSTRAINT `AgentId`
    FOREIGN KEY (`AgentId`)
    REFERENCES `ShmokersTravel`.`User` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
