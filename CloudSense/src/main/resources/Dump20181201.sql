-- MySQL dump 10.13  Distrib 8.0.12, for macos10.13 (x86_64)
--
-- Host: localhost    Database: cloudsensedb
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cluster_node`
--

DROP TABLE IF EXISTS `cluster_node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cluster_node` (
  `cluster_id` int(11) NOT NULL AUTO_INCREMENT,
  `cluster_name` varchar(45) DEFAULT NULL,
  `cluster_desc` varchar(255) DEFAULT NULL,
  `cluster_latitude` varchar(45) DEFAULT NULL,
  `cluster_longitude` varchar(45) DEFAULT NULL,
  `cluster_address` varchar(255) DEFAULT NULL,
  `cluster_city` varchar(45) DEFAULT NULL,
  `cluster_state` varchar(45) DEFAULT NULL,
  `cluster_country` varchar(45) DEFAULT NULL,
  `cluster_zip` varchar(45) DEFAULT NULL,
  `installed_by` int(11) DEFAULT NULL,
  `installation_date` datetime DEFAULT NULL,
  `last_maintained_by` int(11) DEFAULT NULL,
  `last_maintained_date` datetime DEFAULT NULL,
  `cluster_status` varchar(45) DEFAULT NULL,
  `cluster_block` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cluster_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cluster_node`
--

LOCK TABLES `cluster_node` WRITE;
/*!40000 ALTER TABLE `cluster_node` DISABLE KEYS */;
INSERT INTO `cluster_node` VALUES (3,'Node Ashland',NULL,'41.97539','-87.66996999999999','5134 N ashland ave','Chicago','IL',NULL,'60640',NULL,'2017-12-31 21:11:00',NULL,'2017-12-31 21:11:00','1',NULL);
/*!40000 ALTER TABLE `cluster_node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cluster_node_mapping`
--

DROP TABLE IF EXISTS `cluster_node_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cluster_node_mapping` (
  `cluster_node_id` int(11) NOT NULL AUTO_INCREMENT,
  `cluster_id` int(11) NOT NULL,
  `node_id` int(11) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`cluster_node_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cluster_node_mapping`
--

LOCK TABLES `cluster_node_mapping` WRITE;
/*!40000 ALTER TABLE `cluster_node_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `cluster_node_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `node_sensor_mapping`
--

DROP TABLE IF EXISTS `node_sensor_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `node_sensor_mapping` (
  `node_sensor_id` int(11) NOT NULL AUTO_INCREMENT,
  `node_id` int(11) NOT NULL,
  `sensor_id` int(11) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`node_sensor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `node_sensor_mapping`
--

LOCK TABLES `node_sensor_mapping` WRITE;
/*!40000 ALTER TABLE `node_sensor_mapping` DISABLE KEYS */;
INSERT INTO `node_sensor_mapping` VALUES (18,1,7,1,'2018-11-19 00:00:00'),(19,1,7,1,'2018-11-19 00:00:00'),(27,2,16,1,'2018-11-21 00:00:00'),(28,5,9,1,'2018-11-21 00:00:00'),(29,5,10,1,'2018-11-21 00:00:00'),(30,5,11,1,'2018-11-21 00:00:00'),(31,5,16,1,'2018-11-21 00:00:00'),(32,5,9,1,'2018-11-21 00:00:00'),(33,5,9,1,'2018-11-21 00:00:00'),(34,5,9,1,'2018-11-21 00:00:00'),(35,5,9,1,'2018-11-21 00:00:00'),(36,6,9,1,'2018-11-21 00:00:00'),(37,6,10,1,'2018-11-21 00:00:00'),(38,6,11,1,'2018-11-21 00:00:00');
/*!40000 ALTER TABLE `node_sensor_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `permission` (
  `permission_id` varchar(10) NOT NULL,
  `permission_name` varchar(45) DEFAULT NULL,
  `created_by` varchar(10) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(10) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` int(11) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permission_mapping`
--

DROP TABLE IF EXISTS `role_permission_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role_permission_mapping` (
  `role_permission_id` varchar(10) NOT NULL,
  `permission_id` varchar(10) NOT NULL,
  `role_id` varchar(10) NOT NULL,
  `created_by` varchar(10) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`role_permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission_mapping`
--

LOCK TABLES `role_permission_mapping` WRITE;
/*!40000 ALTER TABLE `role_permission_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_permission_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor`
--

DROP TABLE IF EXISTS `sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sensor` (
  `sensor_id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` varchar(45) DEFAULT NULL,
  `sensor_name` varchar(45) DEFAULT NULL,
  `sensor_desc` varchar(255) DEFAULT NULL,
  `sensor_status` varchar(50) DEFAULT NULL,
  `sensor_type` varchar(45) DEFAULT NULL,
  `sensor_frequency` varchar(45) DEFAULT NULL,
  `sensor_provider_name` varchar(45) DEFAULT NULL,
  `sensor_start_time` datetime DEFAULT NULL,
  `sensor_end_time` datetime DEFAULT NULL,
  `sensor_data_queue_name` varchar(45) DEFAULT NULL,
  `sensor_data_format` varchar(45) DEFAULT NULL,
  `sensor_latitude` varchar(45) DEFAULT NULL,
  `sensor_longitude` varchar(45) DEFAULT NULL,
  `sensor_address` varchar(255) DEFAULT NULL,
  `sensor_city` varchar(45) DEFAULT NULL,
  `sensor_state` varchar(45) DEFAULT NULL,
  `sensor_country` varchar(45) DEFAULT NULL,
  `sensor_zip` varchar(45) DEFAULT NULL,
  `installed_by` int(11) DEFAULT NULL,
  `installation_date` datetime DEFAULT NULL,
  `last_maintained_by` int(11) DEFAULT NULL,
  `last_maintained_date` datetime DEFAULT NULL,
  `device_type` varchar(45) DEFAULT NULL,
  `sensor_block` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sensor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor`
--

LOCK TABLES `sensor` WRITE;
/*!40000 ALTER TABLE `sensor` DISABLE KEYS */;
INSERT INTO `sensor` VALUES (9,'ABC111111334','Oak Street Weather',NULL,'0','Air Temperature',NULL,NULL,NULL,NULL,NULL,NULL,'41.9007199','-87.6274937','Oak Street','Chicago','IL',NULL,'60610',0,'2018-11-06 21:00:00',0,'2018-11-07 21:00:00','Station',NULL),(10,'SUN2345655','65th foster Ave Station',NULL,'1','Wet Bulb Temperature',NULL,NULL,NULL,NULL,NULL,NULL,'41.976263','-87.6635477','65th Foster Ave','Chicago','IL',NULL,'60640',0,'2018-07-03 21:00:00',0,'2018-10-31 21:00:00','Station',NULL),(11,'NEW124567','N ashland ave station',NULL,'1','Pressure',NULL,NULL,NULL,NULL,NULL,NULL,'41.97539','-87.66996999999999','5134 N ashland ave','Chicago','IL',NULL,'60640',0,'2018-05-01 21:00:00',0,'2018-11-27 21:00:00','Station',NULL),(16,'ABC111111334','100th St weather station',NULL,'1','Pressure',NULL,NULL,NULL,NULL,NULL,NULL,'41.713669','-87.5715543','2132 E 100th St','Chicago','IL',NULL,'60617',0,'2018-11-28 21:00:00',0,'2018-11-21 21:00:00','Station',NULL);
/*!40000 ALTER TABLE `sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `smart_node`
--

DROP TABLE IF EXISTS `smart_node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `smart_node` (
  `node_id` int(11) NOT NULL AUTO_INCREMENT,
  `node_name` varchar(45) DEFAULT NULL,
  `node_desc` varchar(255) DEFAULT NULL,
  `node_latitude` varchar(45) DEFAULT NULL,
  `node_longitude` varchar(45) DEFAULT NULL,
  `node_address` varchar(255) DEFAULT NULL,
  `node_city` varchar(45) DEFAULT NULL,
  `node_state` varchar(45) DEFAULT NULL,
  `node_country` varchar(45) DEFAULT NULL,
  `node_zip` varchar(45) DEFAULT NULL,
  `installed_by` int(11) DEFAULT NULL,
  `installation_date` datetime DEFAULT NULL,
  `last_maintained_by` int(11) DEFAULT NULL,
  `last_maintained_date` datetime DEFAULT NULL,
  `node_status` varchar(50) DEFAULT NULL,
  `node_block` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`node_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `smart_node`
--

LOCK TABLES `smart_node` WRITE;
/*!40000 ALTER TABLE `smart_node` DISABLE KEYS */;
INSERT INTO `smart_node` VALUES (5,'Node 1st',NULL,'41.97539','-87.66996999999999','5134 N ashland ave','Chicago','IL',NULL,'60640',NULL,'2017-12-31 21:11:00',NULL,'2017-12-31 21:11:00','1',NULL),(6,'Node 1st',NULL,'41.97539','-87.66996999999999','5134 N ashland ave','Chicago','IL',NULL,'60640',NULL,'2017-12-31 21:11:00',NULL,'2017-12-31 21:11:00','1',NULL);
/*!40000 ALTER TABLE `smart_node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` varchar(10) NOT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `user_pwd` varchar(45) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_phone` varchar(10) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_city` varchar(45) DEFAULT NULL,
  `user_state` varchar(45) DEFAULT NULL,
  `user_country` varchar(45) DEFAULT NULL,
  `user_zip` varchar(45) DEFAULT NULL,
  `user_role_id` varchar(10) DEFAULT NULL,
  `created_by` varchar(10) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(10) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-01 22:35:34
