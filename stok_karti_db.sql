-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: localdb
-- ------------------------------------------------------
-- Server version	5.5.62

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `stok_karti`
--

DROP TABLE IF EXISTS `stok_karti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stok_karti` (
  `STOK_KODU` char(50) NOT NULL,
  `STOK_ADI` varchar(100) DEFAULT NULL,
  `STOK_TIPI` int(2) DEFAULT NULL,
  `BIRIMI` varchar(10) DEFAULT NULL,
  `BARKODU` varchar(30) DEFAULT NULL,
  `KDV_TIPI` double DEFAULT NULL,
  `ACIKLAMA` text,
  `OLUSTURMA_TARIHI` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`STOK_KODU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stok_karti`
--

LOCK TABLES `stok_karti` WRITE;
/*!40000 ALTER TABLE `stok_karti` DISABLE KEYS */;
INSERT INTO `stok_karti` VALUES ('KOD1','AD1',11,'Birim 1','BARKOD1',11.1,'ACIKLAMA1','2021-12-31 21:00:00'),('KOD2','AD2',12,'Birim 2','BARKOD2',12.1,'ACIKLAMA2','2021-12-31 21:00:00'),('KOD3','AD3',13,'Birim 3','BARKOD3',13.1,'ACIKLAMA3','2021-12-31 21:00:00'),('KOD4','AD4',14,'Birim 4','BARKOD4',14.1,'ACIKLAMA4','2021-12-31 21:00:00'),('KOD5','AD5',15,'Birim 5','BARKOD5',15.1,'ACIKLAMA5','2022-01-16 11:20:00'),('KOD6','AD6',16,'Birim 6','BARKOD6',16.1,'ACIKLAMA6','2022-01-16 11:17:13'),('KOD7','AD7',17,'Birim 7','BARKOD7',17.1,'ACIKLAMA7','2022-01-16 11:44:52'),('KOD8','AD8',18,'Birim 8','BARKOD8',18.1,'ACIKLAMA8','2022-01-16 12:46:52');
/*!40000 ALTER TABLE `stok_karti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-18 15:44:56
