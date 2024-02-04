-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: assignment
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `assignment`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `assignment` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `assignment`;

--
-- Table structure for table `allocation_size_one_generator`
--

DROP TABLE IF EXISTS `allocation_size_one_generator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `allocation_size_one_generator` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allocation_size_one_generator`
--

LOCK TABLES `allocation_size_one_generator` WRITE;
/*!40000 ALTER TABLE `allocation_size_one_generator` DISABLE KEYS */;
INSERT INTO `allocation_size_one_generator` VALUES (9);
/*!40000 ALTER TABLE `allocation_size_one_generator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_articles`
--

DROP TABLE IF EXISTS `user_articles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_articles` (
  `user_article_id` int NOT NULL,
  `user_information_id` int DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `content` text,
  `author` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_article_id`),
  KEY `user_information_id_idx` (`user_information_id`),
  CONSTRAINT `user_information_id` FOREIGN KEY (`user_information_id`) REFERENCES `user_information` (`user_information_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_articles`
--

LOCK TABLES `user_articles` WRITE;
/*!40000 ALTER TABLE `user_articles` DISABLE KEYS */;
INSERT INTO `user_articles` VALUES (1,1,'Day 1','Day 1 diary ..............................','Tony'),(2,1,'Day 2','Day 2 diary ..............................','Tony'),(3,1,'Day 3','Day 3 diary ..............................','Tony'),(4,1,'Day 4','Day 4 diary ..............................','Tony'),(5,1,'Day 5','Day 5 diary ..............................','Tony'),(6,1,'Day 6','Day 6 diary ..............................','Tony'),(7,1,'Day 7','Day 7 diary ..............................','Tony'),(8,2,'Day 1','Day 1 diary ..............................','Jack'),(9,2,'Day 2','Day 2 diary ..............................','Jack'),(10,2,'Day 3','Day 3 diary ..............................','Jack'),(11,2,'Day 4','Day 4 diary ..............................','Jack'),(12,2,'Day 5','Day 5 diary ..............................','Jack'),(13,2,'Day 6','Day 6 diary ..............................','Jack'),(14,2,'Day 7','Day 7 diary ..............................','Jack'),(15,2,'Day 8','Day 8 diary ..............................','Jack'),(16,3,'Day 3','Day 3 diary ..............................','Jane'),(17,3,'Day 4','Day 4 diary ..............................','Jane'),(18,3,'Day 5','Day 5 diary ..............................','Jane'),(19,3,'Day 6','Day 6 diary ..............................','Jane'),(20,3,'Day 7','Day 7 diary ..............................','Jane'),(21,3,'Day 8','Day 8 diary ..............................','Jane'),(22,4,'Day 1','Day 1 diary ..............................','Bevis'),(23,4,'Day 2','Day 2 diary ..............................','Bevis'),(24,4,'Day 3','Day 3 diary ..............................','Bevis'),(25,4,'Day 4','Day 4 diary ..............................','Bevis'),(26,4,'Day 5','Day 5 diary ..............................','Bevis'),(27,4,'Day 6','Day 6 diary ..............................','Bevis'),(28,5,'Day 1','Day 1 diary ..............................','Wilson'),(29,5,'Day 2','Day 2 diary ..............................','Wilson'),(30,5,'Day 3','Day 3 diary ..............................','Wilson'),(31,5,'Day 5','Day 4 diary ..............................','Wilson'),(32,8,'test','test','test');
/*!40000 ALTER TABLE `user_articles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_information`
--

DROP TABLE IF EXISTS `user_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_information` (
  `user_information_id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_information_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_information`
--

LOCK TABLES `user_information` WRITE;
/*!40000 ALTER TABLE `user_information` DISABLE KEYS */;
INSERT INTO `user_information` VALUES (1,'Tony@gmail.com','123'),(2,'Jack@gmail.com','123'),(3,'Jane@gmail.com','123'),(4,'Bevis@gmail.com','123'),(5,'Wilson@gmail.com','123'),(6,'Belinda@gmail.com','123'),(7,'Peggy@gmail.com','123'),(8,'wayne@gmail.com','123');
/*!40000 ALTER TABLE `user_information` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-05  3:30:20
