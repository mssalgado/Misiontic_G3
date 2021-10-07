-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: tienda_virtual_v2
-- ------------------------------------------------------
-- Server version	5.7.35-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `detallefactura`
--

DROP TABLE IF EXISTS `detallefactura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detallefactura` (
  `idDetalleFactura` int(11) NOT NULL AUTO_INCREMENT,
  `idFacturas` int(11) NOT NULL,
  `idProductos` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `iva` double DEFAULT NULL,
  PRIMARY KEY (`idDetalleFactura`),
  UNIQUE KEY `idFactura_UNIQUE` (`idDetalleFactura`),
  KEY `ProductoFactuta` (`idFacturas`),
  KEY `FacturaProducto` (`idProductos`),
  CONSTRAINT `FacturaProducto` FOREIGN KEY (`idProductos`) REFERENCES `productos` (`idProductos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ProductoFactuta` FOREIGN KEY (`idFacturas`) REFERENCES `factura` (`idFactura`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallefactura`
--

LOCK TABLES `detallefactura` WRITE;
/*!40000 ALTER TABLE `detallefactura` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallefactura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `idFactura` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `valorTotal` double NOT NULL,
  `fechaCompra` date NOT NULL,
  `tipoFactura` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idFactura`),
  UNIQUE KEY `idProdutosFactura_UNIQUE` (`idFactura`),
  KEY `idusuarios_idx` (`idUsuario`),
  CONSTRAINT `UsuariosFactura` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `idProductos` int(11) NOT NULL AUTO_INCREMENT,
  `nombreProducto` varchar(45) NOT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `vencimiento` date DEFAULT NULL,
  `precioVentaUnitario` double DEFAULT NULL,
  PRIMARY KEY (`idProductos`),
  UNIQUE KEY `idInventario_UNIQUE` (`idProductos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idUsuarios` int(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(45) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `rolUsuario` varchar(45) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `genero` varchar(45) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `tipoIdentificacion` varchar(45) NOT NULL,
  `numeroIdentificacion` varchar(45) NOT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `correoPersonal` varchar(45) NOT NULL,
  `ciudadDomicilio` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUsuarios`),
  UNIQUE KEY `idUsuarios_UNIQUE` (`idUsuarios`),
  UNIQUE KEY `nombreUsuario_UNIQUE` (`nombreUsuario`),
  UNIQUE KEY `numeroIdentificacion_UNIQUE` (`numeroIdentificacion`),
  UNIQUE KEY `correoPersonal_UNIQUE` (`correoPersonal`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'salgadito','carro098','Vendedor','sebastian','salgado','Masculino','2000-01-03','CC','1007351912','calle 23','2032652','sebassalgado098@gmail.com','bogota'),(2,'evelyn','evelyn','Vendedor','evelyn','evelyn','Femenino','2000-01-03','CC','10075552','evelyn','evelyn','evelyn@gmai.com','evelyn'),(6,'juan','juan123','Administrador','juan','sanchez','Masculino','1998-03-01','CC','100089621','calle 22 #19-22','2093654','juan123@gmail.com','bogota');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vistadetallefactura`
--

DROP TABLE IF EXISTS `vistadetallefactura`;
/*!50001 DROP VIEW IF EXISTS `vistadetallefactura`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vistadetallefactura` AS SELECT 
 1 AS `idDetalleFacturas`,
 1 AS `idFacturasEnDetalle`,
 1 AS `idProductosEnDetalle`,
 1 AS `cantidad`,
 1 AS `iva`,
 1 AS `idFacturas`,
 1 AS `idUsuarioFactura`,
 1 AS `valorTotal`,
 1 AS `fechaCompra`,
 1 AS `tipoFactura`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vistadetallefactura`
--

/*!50001 DROP VIEW IF EXISTS `vistadetallefactura`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vistadetallefactura` AS select 1 AS `idDetalleFacturas`,1 AS `idFacturasEnDetalle`,1 AS `idProductosEnDetalle`,1 AS `cantidad`,1 AS `iva`,1 AS `idFacturas`,1 AS `idUsuarioFactura`,1 AS `valorTotal`,1 AS `fechaCompra`,1 AS `tipoFactura` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-06 21:11:16
