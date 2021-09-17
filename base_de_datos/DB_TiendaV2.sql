-- MySQL Script generated by MySQL Workbench
-- Tue Sep 14 20:57:25 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Tienda_Virtual_V2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Tienda_Virtual_V2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Tienda_Virtual_V2` DEFAULT CHARACTER SET utf8 ;
USE `Tienda_Virtual_V2` ;

-- -----------------------------------------------------
-- Table `Tienda_Virtual_V2`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tienda_Virtual_V2`.`Usuarios` (
  `idUsuarios` INT NOT NULL AUTO_INCREMENT,
  `nombreUsuario` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `rolUsuario` VARCHAR(45) NOT NULL,
  `nombres` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `genero` VARCHAR(45) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `tipoIdentificacion` VARCHAR(45) NOT NULL,
  `numeroIdentificacion` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `correoPersonal` VARCHAR(45) NOT NULL,
  `ciudadDomicilio` VARCHAR(45) NULL,
  PRIMARY KEY (`idUsuarios`),
  UNIQUE INDEX `idUsuarios_UNIQUE` (`idUsuarios` ASC) VISIBLE,
  UNIQUE INDEX `nombreUsuario_UNIQUE` (`nombreUsuario` ASC) VISIBLE,
  UNIQUE INDEX `numeroIdentificacion_UNIQUE` (`numeroIdentificacion` ASC) VISIBLE,
  UNIQUE INDEX `correoPersonal_UNIQUE` (`correoPersonal` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tienda_Virtual_V2`.`Productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tienda_Virtual_V2`.`Productos` (
  `idProductos` INT NOT NULL AUTO_INCREMENT,
  `nombreProducto` VARCHAR(45) NOT NULL,
  `categoria` VARCHAR(45) NULL,
  `descripcion` VARCHAR(45) NULL,
  `stock` INT NULL,
  `vencimiento` DATE NULL,
  `proveedor` VARCHAR(45) NULL,
  `precioVentaUnitario` DOUBLE NULL,
  `valorUnitario` DOUBLE NULL,
  PRIMARY KEY (`idProductos`),
  UNIQUE INDEX `idInventario_UNIQUE` (`idProductos` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tienda_Virtual_V2`.`Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tienda_Virtual_V2`.`Factura` (
  `idFactura` INT NOT NULL AUTO_INCREMENT,
  `idUsuario` INT NOT NULL,
  `valorTotal` DOUBLE NOT NULL,
  `fechaCompra` DATE NOT NULL,
  `tipoFactura` VARCHAR(10) NULL,
  PRIMARY KEY (`idFactura`),
  UNIQUE INDEX `idProdutosFactura_UNIQUE` (`idFactura` ASC) VISIBLE,
  INDEX `FacturaUsuario_idx` (`idUsuario` ASC) VISIBLE,
  CONSTRAINT `FacturaUsuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `Tienda_Virtual_V2`.`Usuarios` (`idUsuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tienda_Virtual_V2`.`DetalleFactura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tienda_Virtual_V2`.`DetalleFactura` (
  `idDetalleFactura` INT NOT NULL AUTO_INCREMENT,
  `idFacturas` INT NOT NULL,
  `idProductos` INT NOT NULL,
  `cantidad` INT NULL,
  `iva` DOUBLE NULL,
  PRIMARY KEY (`idDetalleFactura`),
  UNIQUE INDEX `idFactura_UNIQUE` (`idDetalleFactura` ASC) VISIBLE,
  CONSTRAINT `ProductoFactuta`
    FOREIGN KEY (`idFacturas`)
    REFERENCES `Tienda_Virtual_V2`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FacturaProducto`
    FOREIGN KEY (`idProductos`)
    REFERENCES `Tienda_Virtual_V2`.`Productos` (`idProductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
