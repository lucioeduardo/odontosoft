-- MySQL dump 10.13  Distrib 5.7.13, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: odontosoft
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.19-MariaDB

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
-- Table structure for table `Consulta`
--

DROP TABLE IF EXISTS `Consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Consulta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idPaciente` int(11) NOT NULL,
  `idFuncionario` int(11) NOT NULL,
  `dataConsulta` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idPaciente` (`idPaciente`),
  KEY `idFuncionario` (`idFuncionario`),
  CONSTRAINT `Consulta_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `Paciente` (`id`),
  CONSTRAINT `Consulta_ibfk_2` FOREIGN KEY (`idFuncionario`) REFERENCES `Funcionario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Consulta`
--

LOCK TABLES `Consulta` WRITE;
/*!40000 ALTER TABLE `Consulta` DISABLE KEYS */;
INSERT INTO `Consulta` VALUES (7,71,3,'2017-12-04 09:16:44'),(8,78,2,'2017-06-07 05:35:02'),(9,78,3,'2017-10-19 13:01:43'),(10,91,3,'2017-03-13 21:28:22'),(11,56,3,'2017-06-06 17:34:53'),(12,69,2,'2017-05-18 02:09:22'),(13,72,2,'2017-02-02 18:22:15'),(14,99,3,'2017-05-01 07:33:55'),(15,65,3,'2017-02-16 22:03:56'),(16,69,2,'2017-02-07 11:25:20'),(17,85,2,'2017-03-23 09:04:00'),(18,53,2,'2017-10-23 18:50:02'),(19,65,2,'2017-01-09 23:33:01'),(20,101,2,'2017-06-26 23:31:12'),(21,100,2,'2017-02-08 18:56:33'),(22,101,3,'2017-03-09 06:12:39'),(23,96,3,'2017-05-07 14:47:55'),(24,95,2,'2017-02-16 17:50:37'),(25,68,2,'2017-04-29 04:33:47'),(26,84,2,'2017-09-22 06:15:47'),(27,87,3,'2017-06-04 10:18:41'),(28,94,2,'2017-02-12 10:49:04'),(29,66,3,'2017-06-26 23:27:26'),(30,96,3,'2017-01-08 09:59:07'),(31,65,2,'2017-04-04 08:49:35'),(32,56,3,'2017-06-10 03:28:00'),(33,52,2,'2017-06-19 02:00:30'),(34,99,2,'2017-01-11 23:54:50'),(35,86,2,'2017-08-11 05:43:40'),(36,57,3,'2017-11-19 05:36:51'),(37,94,3,'2017-12-05 04:35:57'),(38,69,2,'2017-02-11 01:52:18'),(39,58,2,'2017-09-18 22:29:51'),(40,71,3,'2017-11-18 11:52:58'),(41,93,3,'2017-08-27 08:10:49'),(42,62,3,'2017-02-18 11:33:10'),(43,87,3,'2017-05-02 05:17:21'),(44,80,3,'2017-02-03 09:30:04'),(45,66,3,'2017-04-11 11:21:16'),(46,55,2,'2017-11-04 15:34:47'),(47,87,3,'2017-02-07 20:57:41'),(48,79,2,'2017-01-29 12:03:05'),(49,92,2,'2017-11-24 09:13:02'),(50,99,3,'2017-03-16 14:35:28'),(51,59,3,'2017-11-03 16:11:23'),(52,67,2,'2017-06-23 17:38:34'),(53,64,2,'2017-07-30 16:14:08'),(54,77,3,'2017-07-30 05:43:12'),(55,81,2,'2017-04-05 03:19:20'),(56,93,3,'2017-12-30 08:09:09'),(57,65,3,'2017-06-23 21:48:47'),(58,79,3,'2017-07-20 11:37:21'),(59,73,3,'2017-06-17 07:51:05'),(60,96,2,'2017-09-19 23:10:59'),(61,91,3,'2017-06-15 19:10:43'),(62,75,2,'2017-11-07 08:37:36'),(63,58,2,'2017-06-17 14:09:53'),(64,96,2,'2017-11-01 13:55:50'),(65,87,2,'2017-08-27 12:01:00'),(66,72,3,'2017-10-03 04:42:36'),(67,101,2,'2017-05-21 07:03:16'),(68,97,2,'2017-01-23 10:19:35'),(69,74,2,'2017-06-25 11:56:06'),(70,68,3,'2017-02-10 22:12:09'),(71,70,3,'2017-07-12 10:16:57'),(72,58,3,'2017-02-26 00:55:57'),(73,53,3,'2017-08-21 18:19:33'),(74,80,3,'2017-06-04 10:04:48'),(75,82,2,'2017-07-16 06:24:52'),(76,73,3,'2017-05-01 10:53:11'),(77,96,2,'2017-10-11 08:56:55'),(78,101,2,'2017-07-26 02:07:02'),(79,95,2,'2017-05-12 19:47:34'),(80,62,2,'2017-09-08 16:22:15'),(81,84,3,'2017-05-21 14:17:56'),(82,93,3,'2017-05-24 21:02:06'),(83,85,2,'2017-09-08 03:39:26'),(84,61,2,'2017-09-08 09:58:49'),(85,76,2,'2017-10-12 13:54:52'),(86,71,3,'2017-03-21 11:09:54'),(87,75,3,'2017-05-31 15:20:06'),(88,80,2,'2017-06-21 12:50:37'),(89,63,3,'2017-08-08 11:11:56'),(90,55,3,'2017-02-06 19:43:36'),(91,94,2,'2017-10-08 07:41:03'),(92,91,3,'2017-03-21 23:16:43'),(93,88,2,'2017-03-10 13:57:12'),(94,78,3,'2017-12-13 15:42:05'),(95,83,3,'2017-08-18 14:37:19'),(96,93,3,'2017-03-17 20:49:13'),(97,95,3,'2017-09-01 13:07:15'),(98,70,2,'2017-03-18 16:05:45'),(99,69,2,'2017-03-27 03:56:13'),(100,93,3,'2017-12-11 14:55:00'),(101,74,2,'2017-05-28 23:44:46'),(102,90,3,'2017-05-14 13:49:54'),(103,88,2,'2017-06-22 17:09:38'),(104,95,3,'2017-06-25 19:04:53'),(105,59,3,'2017-10-17 16:49:25'),(106,82,2,'2017-03-12 20:58:50');
/*!40000 ALTER TABLE `Consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Consulta_has_Procedimento`
--

DROP TABLE IF EXISTS `Consulta_has_Procedimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Consulta_has_Procedimento` (
  `idConsulta` int(11) NOT NULL,
  `idProcedimento` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  PRIMARY KEY (`idConsulta`,`idProcedimento`),
  KEY `idProcedimento` (`idProcedimento`),
  CONSTRAINT `Consulta_has_Procedimento_ibfk_1` FOREIGN KEY (`idConsulta`) REFERENCES `Consulta` (`id`),
  CONSTRAINT `Consulta_has_Procedimento_ibfk_2` FOREIGN KEY (`idProcedimento`) REFERENCES `Procedimento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Consulta_has_Procedimento`
--

LOCK TABLES `Consulta_has_Procedimento` WRITE;
/*!40000 ALTER TABLE `Consulta_has_Procedimento` DISABLE KEYS */;
INSERT INTO `Consulta_has_Procedimento` VALUES (7,7,2),(8,5,5),(9,5,2),(10,4,2),(11,7,4),(12,6,5),(13,3,3),(14,6,5),(15,6,2),(16,6,4),(17,4,2),(18,7,5),(19,7,1),(20,4,4),(21,7,1),(22,3,2),(23,5,5),(24,7,3),(25,3,3),(26,4,2),(27,3,2),(28,6,1),(29,3,3),(30,5,3),(31,6,4),(32,5,5),(33,4,3),(34,7,2),(35,7,1),(36,5,1),(37,7,2),(38,4,1),(39,7,4),(40,6,4),(41,3,1),(42,4,3),(43,4,1),(44,6,5),(45,7,2),(46,6,3),(47,3,5),(48,5,3),(49,3,4),(50,3,3),(51,6,2),(52,6,2),(53,4,2),(54,7,3),(55,3,5),(56,3,5),(57,7,5),(58,4,3),(59,4,1),(60,7,5),(61,3,3),(62,3,5),(63,7,4),(64,6,4),(65,3,2),(66,4,1),(67,5,4),(68,4,4),(69,7,1),(70,6,4),(71,7,5),(72,6,2),(73,4,3),(74,6,5),(75,4,3),(76,3,5),(77,4,3),(78,3,3),(79,5,1),(80,4,1),(81,5,4),(82,3,3),(83,6,4),(84,4,3),(85,3,2),(86,4,3),(87,6,1),(88,7,3),(89,6,4),(90,3,4),(91,4,4),(92,6,3),(93,7,5),(94,7,3),(95,4,1),(96,5,1),(97,5,4),(98,6,3),(99,5,3),(100,4,1),(101,5,2),(102,6,5),(103,3,1),(104,4,2),(105,3,4),(106,4,2);
/*!40000 ALTER TABLE `Consulta_has_Procedimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Funcionario`
--

DROP TABLE IF EXISTS `Funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `dataNascimento` date NOT NULL,
  `rg` varchar(45) DEFAULT NULL,
  `salario` double NOT NULL,
  `isGerente` tinyint(1) NOT NULL,
  `isDentista` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`),
  UNIQUE KEY `telefone` (`telefone`),
  UNIQUE KEY `rg` (`rg`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Funcionario`
--

LOCK TABLES `Funcionario` WRITE;
/*!40000 ALTER TABLE `Funcionario` DISABLE KEYS */;
INSERT INTO `Funcionario` VALUES (1,'admin','0','0','2016-12-01','0',0,1,0),(2,'Jose Melo','192819281','3231983','2016-12-06','123982',2823,0,1),(3,'Lucas Alberto Mendes','237832323','12394842','1992-12-24','231234',8750,0,1);
/*!40000 ALTER TABLE `Funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Paciente`
--

DROP TABLE IF EXISTS `Paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Paciente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `dataNascimento` date NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`),
  UNIQUE KEY `telefone` (`telefone`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Paciente`
--

LOCK TABLES `Paciente` WRITE;
/*!40000 ALTER TABLE `Paciente` DISABLE KEYS */;
INSERT INTO `Paciente` VALUES (52,'Catherine Bradley','1907-02-08','72001905928','162474037'),(53,'Rebecca Black','1955-01-25','16861196827','542700723'),(54,'Lori Nelson','1941-07-22','17373310146','614062740'),(55,'Sean Nguyen','1978-08-23','29406939347','446854501'),(56,'Laura Lewis','1943-06-24','62309084946','880016692'),(57,'Cheryl Wheeler','1973-09-20','02621844697','411714165'),(58,'Charles Gibson','1995-07-25','64123654854','782060270'),(59,'Marilyn Russell','1924-09-22','00911663241','334091780'),(60,'Julia Fox','1924-08-21','06878773695','148374988'),(61,'Julia Gutierrez','1957-02-07','71725445870','439034470'),(62,'Bruce Rodriguez','1931-06-05','28921458963','705918139'),(63,'Michelle Gilbert','1945-02-13','41353845738','824518049'),(64,'Frank Marshall','1949-05-21','25277011159','429523889'),(65,'Juan Martin','1952-07-28','14655563768','673787843'),(66,'Jeremy Mills','1911-04-00','48627341452','462983171'),(67,'Katherine Welch','1963-02-21','46135324468','096266575'),(68,'Catherine Olson','1977-03-26','43687177404','161386445'),(69,'Benjamin Grant','1975-06-16','94575499995','311434994'),(70,'Gloria Hernandez','1919-07-27','91363003761','368513656'),(71,'Heather Rice','1931-03-08','19482753773','226597563'),(72,'Paula Simmons','1900-04-28','66445578437','727692266'),(73,'Phillip Burton','1948-01-24','74990396800','257804314'),(74,'Christina Gonzales','1953-06-26','54396484556','456181070'),(75,'Lisa Willis','1955-00-20','18285188941','317139094'),(76,'Gerald Elliott','1968-02-29','23273765050','197459462'),(77,'Henry Riley','1965-09-20','33389179187','004582178'),(78,'Kevin Bradley','1924-02-21','31172102313','092278672'),(79,'Katherine Gonzalez','1908-01-01','83398721988','048920311'),(80,'Douglas Hernandez','1976-01-16','96116217859','123066533'),(81,'William Bradley','1993-05-06','66327073244','366994575'),(82,'Matthew Sims','1917-06-26','90970953842','736123308'),(83,'Margaret Bryant','1929-03-27','53511439182','092803609'),(84,'Richard Dunn','1927-04-26','77795396006','288307059'),(85,'Patricia Peterson','1977-08-07','82728999796','337953523'),(86,'John Jacobs','1941-04-23','57741571171','721811164'),(87,'Roy Stewart','1910-00-27','71673814282','287165236'),(88,'Helen Crawford','1938-08-23','87755104399','862928678'),(89,'Rachel Taylor','1910-01-07','33222116794','850396489'),(90,'Thomas Roberts','1970-01-19','31080865585','568929375'),(91,'Michael Hunt','1965-08-00','80407355074','755201617'),(92,'Barbara Hanson','1973-04-09','72257890645','354240563'),(93,'Rachel Payne','1945-02-27','86867052756','163264577'),(94,'Larry Mccoy','1942-09-22','43082695404','923203113'),(95,'Raymond Campbell','1965-04-26','26027165107','766825542'),(96,'Lori Bradley','1932-04-21','96567982482','688264222'),(97,'Debra Wells','1940-05-06','02664984579','449302882'),(98,'William Palmer','1913-00-25','44842956243','258785573'),(99,'Shirley Powell','1965-05-25','74578406791','022137970'),(100,'Edward Austin','1959-04-19','74528670548','066278892'),(101,'Joe Jacobs','1982-06-18','79923307150','808648517');
/*!40000 ALTER TABLE `Paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Procedimento`
--

DROP TABLE IF EXISTS `Procedimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Procedimento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  `preco` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Procedimento`
--

LOCK TABLES `Procedimento` WRITE;
/*!40000 ALTER TABLE `Procedimento` DISABLE KEYS */;
INSERT INTO `Procedimento` VALUES (3,'Aplicação de flúor gel',80),(4,'Aplicação de verniz de flúor (2 arcadas)',150),(5,'Restauração de amálgama 01 face ',180),(6,'Restauração provisória',140),(7,'Controle de placa bacteriana',100);
/*!40000 ALTER TABLE `Procedimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `id` varchar(50) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `idFuncionario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idFuncionario` (`idFuncionario`),
  CONSTRAINT `Usuario_ibfk_1` FOREIGN KEY (`idFuncionario`) REFERENCES `Funcionario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES ('adm','',1),('lalberto','123',3),('sdkjshS','ASKJDHS',2);
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-29 12:21:06
