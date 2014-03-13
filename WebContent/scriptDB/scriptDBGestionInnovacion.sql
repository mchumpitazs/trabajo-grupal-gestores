SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `GestionInnovacion` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `GestionInnovacion` ;

-- -----------------------------------------------------
-- Table `GestionInnovacion`.`TIPOUSUARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestionInnovacion`.`TIPOUSUARIO` ;

CREATE TABLE IF NOT EXISTS `GestionInnovacion`.`TIPOUSUARIO` (
  `idTIPOUSUARIO` INT NOT NULL,
  `TxDescripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`idTIPOUSUARIO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestionInnovacion`.`TIPODOC`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestionInnovacion`.`TIPODOC` ;

CREATE TABLE IF NOT EXISTS `GestionInnovacion`.`TIPODOC` (
  `TipoDocUSUARIO` VARCHAR(1) NOT NULL,
  `NoDescripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`TipoDocUSUARIO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestionInnovacion`.`TIPOCENTROFORMACION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestionInnovacion`.`TIPOCENTROFORMACION` ;

CREATE TABLE IF NOT EXISTS `GestionInnovacion`.`TIPOCENTROFORMACION` (
  `TipCentroFormacion` VARCHAR(1) NOT NULL,
  `NoTipoCentroFormacion` VARCHAR(45) NULL,
  PRIMARY KEY (`TipCentroFormacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestionInnovacion`.`CENTROFORMACION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestionInnovacion`.`CENTROFORMACION` ;

CREATE TABLE IF NOT EXISTS `GestionInnovacion`.`CENTROFORMACION` (
  `idCentroFormacion` VARCHAR(11) NOT NULL,
  `NoCentroFormacion` VARCHAR(45) NOT NULL,
  `TxUrlCentroFormacion` VARCHAR(45) NOT NULL,
  `LogoURLCentroFormacion` VARCHAR(255) NOT NULL,
  `TipCentroFormacion` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`idCentroFormacion`),
  INDEX `fk_CENTROFORMACION_TIPOCENTROFORMACION1_idx` (`TipCentroFormacion` ASC),
  UNIQUE INDEX `NoCentroFormacion_UNIQUE` (`NoCentroFormacion` ASC),
  UNIQUE INDEX `TxUrlCentroFormacion_UNIQUE` (`TxUrlCentroFormacion` ASC),
  CONSTRAINT `fk_CENTROFORMACION_TIPOCENTROFORMACION1`
    FOREIGN KEY (`TipCentroFormacion`)
    REFERENCES `GestionInnovacion`.`TIPOCENTROFORMACION` (`TipCentroFormacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestionInnovacion`.`USUARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestionInnovacion`.`USUARIO` ;

CREATE TABLE IF NOT EXISTS `GestionInnovacion`.`USUARIO` (
  `idUSUARIO` INT NOT NULL,
  `NoNombre` VARCHAR(45) NULL,
  `NoApellidoPaterno` VARCHAR(45) NULL,
  `NoApellidoMaterno` VARCHAR(45) NULL,
  `FlSexo` VARCHAR(1) NULL,
  `NroDocUSUARIO` VARCHAR(8) NULL,
  `emailUSUARIO` VARCHAR(45) NULL,
  `numcelularUSUARIO` VARCHAR(45) NULL,
  `TIPOUSUARIO_idTIPOUSUARIO` INT NOT NULL,
  `TxPassword` VARCHAR(12) NULL,
  `TIPODOC_TipoDocUSUARIO` VARCHAR(1) NOT NULL,
  `CENTROFORMACION_idCentroFormacion` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`idUSUARIO`),
  INDEX `fk_USUARIO_TIPOUSUARIO1_idx` (`TIPOUSUARIO_idTIPOUSUARIO` ASC),
  INDEX `fk_USUARIO_TIPODOC1_idx` (`TIPODOC_TipoDocUSUARIO` ASC),
  INDEX `fk_USUARIO_CENTROFORMACION1_idx` (`CENTROFORMACION_idCentroFormacion` ASC),
  CONSTRAINT `fk_USUARIO_TIPOUSUARIO1`
    FOREIGN KEY (`TIPOUSUARIO_idTIPOUSUARIO`)
    REFERENCES `GestionInnovacion`.`TIPOUSUARIO` (`idTIPOUSUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USUARIO_TIPODOC1`
    FOREIGN KEY (`TIPODOC_TipoDocUSUARIO`)
    REFERENCES `GestionInnovacion`.`TIPODOC` (`TipoDocUSUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USUARIO_CENTROFORMACION1`
    FOREIGN KEY (`CENTROFORMACION_idCentroFormacion`)
    REFERENCES `GestionInnovacion`.`CENTROFORMACION` (`idCentroFormacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestionInnovacion`.`TIPOESTADOIDEA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestionInnovacion`.`TIPOESTADOIDEA` ;

CREATE TABLE IF NOT EXISTS `GestionInnovacion`.`TIPOESTADOIDEA` (
  `CoESTADO` INT NOT NULL,
  `TxDescripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`CoESTADO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestionInnovacion`.`IDEA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestionInnovacion`.`IDEA` ;

CREATE TABLE IF NOT EXISTS `GestionInnovacion`.`IDEA` (
  `idIDEA` INT NOT NULL,
  `NoTitulo` VARCHAR(45) NULL,
  `TxDescripcion` VARCHAR(45) NULL,
  `TxReferencia` VARCHAR(45) NULL,
  `FeCreacion` DATETIME NULL,
  `FePublicacion` DATETIME NULL,
  `TIPOESTADO_CoESTADO` INT NOT NULL,
  `USUARIO_idESTUDIANTE` INT NOT NULL,
  `USUARIO_idASESOR` INT NOT NULL,
  PRIMARY KEY (`idIDEA`),
  INDEX `fk_IDEA_TIPOESTADO1_idx` (`TIPOESTADO_CoESTADO` ASC),
  INDEX `fk_IDEA_USUARIO1_idx` (`USUARIO_idESTUDIANTE` ASC),
  INDEX `fk_IDEA_USUARIO2_idx` (`USUARIO_idASESOR` ASC),
  CONSTRAINT `fk_IDEA_TIPOESTADO1`
    FOREIGN KEY (`TIPOESTADO_CoESTADO`)
    REFERENCES `GestionInnovacion`.`TIPOESTADOIDEA` (`CoESTADO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_IDEA_USUARIO1`
    FOREIGN KEY (`USUARIO_idESTUDIANTE`)
    REFERENCES `GestionInnovacion`.`USUARIO` (`idUSUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_IDEA_USUARIO2`
    FOREIGN KEY (`USUARIO_idASESOR`)
    REFERENCES `GestionInnovacion`.`USUARIO` (`idUSUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestionInnovacion`.`USRPERMITIDOS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestionInnovacion`.`USRPERMITIDOS` ;

CREATE TABLE IF NOT EXISTS `GestionInnovacion`.`USRPERMITIDOS` (
  `QtPuntaje` INT NOT NULL,
  `USUARIO_idUSUARIO` INT NOT NULL,
  `IDEA_idIDEA` INT NOT NULL,
  INDEX `fk_IDEAPERMITIDOS_USUARIO1_idx` (`USUARIO_idUSUARIO` ASC),
  PRIMARY KEY (`USUARIO_idUSUARIO`, `IDEA_idIDEA`),
  INDEX `fk_IDEAPERMITIDOS_IDEA1_idx` (`IDEA_idIDEA` ASC),
  CONSTRAINT `fk_IDEAPERMITIDOS_USUARIO1`
    FOREIGN KEY (`USUARIO_idUSUARIO`)
    REFERENCES `GestionInnovacion`.`USUARIO` (`idUSUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_IDEAPERMITIDOS_IDEA1`
    FOREIGN KEY (`IDEA_idIDEA`)
    REFERENCES `GestionInnovacion`.`IDEA` (`idIDEA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestionInnovacion`.`REUNIONES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestionInnovacion`.`REUNIONES` ;

CREATE TABLE IF NOT EXISTS `GestionInnovacion`.`REUNIONES` (
  `IdReunion` INT NOT NULL,
  `IDEA_idIDEA` INT NOT NULL,
  `FeReunion` DATETIME NOT NULL,
  `TxObservacion` TEXT NOT NULL,
  `TxCalificacion` TINYTEXT NOT NULL,
  INDEX `fk_ASESORIAS_IDEA1_idx` (`IDEA_idIDEA` ASC),
  PRIMARY KEY (`IdReunion`),
  CONSTRAINT `fk_ASESORIAS_IDEA1`
    FOREIGN KEY (`IDEA_idIDEA`)
    REFERENCES `GestionInnovacion`.`IDEA` (`idIDEA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = cp1250;


-- -----------------------------------------------------
-- Table `GestionInnovacion`.`TARIFA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestionInnovacion`.`TARIFA` ;

CREATE TABLE IF NOT EXISTS `GestionInnovacion`.`TARIFA` (
  `idTARIFA` INT NOT NULL,
  `TxDescripcion` VARCHAR(50) NULL,
  `SsPrecio` DOUBLE NULL,
  PRIMARY KEY (`idTARIFA`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestionInnovacion`.`FACTURA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestionInnovacion`.`FACTURA` ;

CREATE TABLE IF NOT EXISTS `GestionInnovacion`.`FACTURA` (
  `idFACTURA` VARCHAR(8) NOT NULL,
  `CENTROFORMACION_idCentroFormacion` VARCHAR(11) NOT NULL,
  `TARIFA_idTARIFA` INT NOT NULL,
  `SsSubTotal` DOUBLE NOT NULL,
  `FeFactura` DATE NOT NULL,
  PRIMARY KEY (`idFACTURA`, `CENTROFORMACION_idCentroFormacion`, `TARIFA_idTARIFA`),
  INDEX `fk_FACTURA_TARIFA1_idx` (`TARIFA_idTARIFA` ASC),
  INDEX `fk_FACTURA_CENTROFORMACION1_idx` (`CENTROFORMACION_idCentroFormacion` ASC),
  CONSTRAINT `fk_FACTURA_TARIFA1`
    FOREIGN KEY (`TARIFA_idTARIFA`)
    REFERENCES `GestionInnovacion`.`TARIFA` (`idTARIFA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FACTURA_CENTROFORMACION1`
    FOREIGN KEY (`CENTROFORMACION_idCentroFormacion`)
    REFERENCES `GestionInnovacion`.`CENTROFORMACION` (`idCentroFormacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
