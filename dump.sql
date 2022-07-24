-- MySQL dump 10.13  Distrib 5.7.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_api
-- ------------------------------------------------------
-- Server version	5.7.36

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
-- Table structure for table `ide`
--

DROP TABLE IF EXISTS `ide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ide` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `caracteristiques` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `langage_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKflavm4j7uq46rnk3512sq34fb` (`langage_id`),
  CONSTRAINT `FKflavm4j7uq46rnk3512sq34fb` FOREIGN KEY (`langage_id`) REFERENCES `langage` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ide`
--

LOCK TABLES `ide` WRITE;
/*!40000 ALTER TABLE `ide` DISABLE KEYS */;
INSERT INTO `ide` VALUES (1,'bien','Pycharm',1),(2,'bien','IntelliJ',2),(3,'douleur visuelle','NetBeans',2),(4,NULL,'PhpStorm',3),(5,NULL,'WebStorm',6);
/*!40000 ALTER TABLE `ide` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `langage`
--

DROP TABLE IF EXISTS `langage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `langage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `caracteristiques` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `langage`
--

LOCK TABLES `langage` WRITE;
/*!40000 ALTER TABLE `langage` DISABLE KEYS */;
INSERT INTO `langage` VALUES (1,'nouveau','Python'),(2,'old','Java'),(3,'avec beaucoup de frameworks','Php'),(4,NULL,'C'),(5,'descendant de C','C++'),(6,'popur le web','JS');
/*!40000 ALTER TABLE `langage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-24 17:14:31
