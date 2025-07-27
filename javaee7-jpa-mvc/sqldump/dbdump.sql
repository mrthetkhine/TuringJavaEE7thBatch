-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: localhost    Database: javaee7_jpa
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `actor`
--

DROP TABLE IF EXISTS `actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(128) DEFAULT NULL,
  `last_name` varchar(128) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `gender` smallint DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor`
--

LOCK TABLES `actor` WRITE;
/*!40000 ALTER TABLE `actor` DISABLE KEYS */;
INSERT INTO `actor` VALUES (1,'Leonardo','DiCaprio','1974-11-11 00:00:00',0,'2025-06-24 20:57:39','2025-06-24 21:12:04'),(2,'Kate','Winslet','1975-11-11 00:00:00',1,'2025-06-24 21:01:37','2025-06-24 21:12:25'),(3,'FirstName','LastName','1974-11-11 00:00:00',1,'2025-06-28 18:41:16','2025-06-28 18:41:16'),(4,'Actor ','Three','2025-07-22 19:58:10',0,'2025-07-22 19:59:46','2025-07-22 19:59:46'),(5,'Actor ','Four','2005-07-22 19:58:10',1,'2025-07-22 20:00:36','2025-07-22 20:00:36'),(6,'Actor ','Five','2005-07-22 19:58:10',0,'2025-07-22 20:01:01','2025-07-22 20:01:01');
/*!40000 ALTER TABLE `actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actor_in_movie`
--

DROP TABLE IF EXISTS `actor_in_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actor_in_movie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `movie_id` int DEFAULT NULL,
  `actor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor_in_movie`
--

LOCK TABLES `actor_in_movie` WRITE;
/*!40000 ALTER TABLE `actor_in_movie` DISABLE KEYS */;
INSERT INTO `actor_in_movie` VALUES (1,2,1),(2,2,2),(3,3,1),(4,1,1),(5,1,2);
/*!40000 ALTER TABLE `actor_in_movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank_account`
--

DROP TABLE IF EXISTS `bank_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank_account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_name` varchar(255) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_account`
--

LOCK TABLES `bank_account` WRITE;
/*!40000 ALTER TABLE `bank_account` DISABLE KEYS */;
INSERT INTO `bank_account` VALUES (1,'Aung Aung',700,NULL,'2025-07-13 18:55:52'),(2,'Maung Maung',300,NULL,'2025-07-13 18:55:52');
/*!40000 ALTER TABLE `bank_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(150) DEFAULT NULL,
  `author` varchar(150) DEFAULT NULL,
  `description` varchar(150) DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Man\'s search for meaning','Victor Frankl','Book on survival and meaning of life',200),(2,'What is Life?: With Mind and Matter and Autobiographical Sketches','Erwin Schrodinger','Update on life',100),(4,'Title 3','Author 3','Description 3',300);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `movie_id` int DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (5,1,'Comment 1 for Movie1','2025-06-29 19:03:33','2025-06-29 19:03:33'),(6,1,'Comment 2 for Movie1','2025-06-29 19:03:33','2025-06-29 19:03:33'),(9,2,'Comment 1 for Movie 2','2025-06-29 20:05:07','2025-06-29 20:05:07'),(10,2,'Comment 2 for Movie 2','2025-06-29 20:05:07','2025-06-29 20:05:07'),(11,3,'Comment 3','2025-06-29 20:05:07','2025-06-29 20:05:07'),(12,4,'Comment 4','2025-06-29 20:05:07','2025-06-29 20:05:07'),(13,1,'COmment 3 for Movie 1','2025-06-29 20:05:07','2025-06-29 20:05:07');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `director`
--

DROP TABLE IF EXISTS `director`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `director` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(128) DEFAULT NULL,
  `last_name` varchar(128) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `gender` smallint DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `director`
--

LOCK TABLES `director` WRITE;
/*!40000 ALTER TABLE `director` DISABLE KEYS */;
/*!40000 ALTER TABLE `director` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `director_in_movie`
--

DROP TABLE IF EXISTS `director_in_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `director_in_movie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `movie_id` int DEFAULT NULL,
  `director_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `director_in_movie`
--

LOCK TABLES `director_in_movie` WRITE;
/*!40000 ALTER TABLE `director_in_movie` DISABLE KEYS */;
/*!40000 ALTER TABLE `director_in_movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `genre` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Forrest Gump',2009,'Drama','2025-06-28 19:22:48','2025-06-28 19:22:48'),(2,'Titanic',2010,'Drama','2025-06-28 19:23:48','2025-06-28 19:23:48'),(3,'Inspection',2009,'Sci-Fi','2025-06-28 19:56:14','2025-06-28 19:56:14'),(6,'Movie 4',2009,'Drama','2025-07-05 18:42:01','2025-07-05 18:42:01'),(7,'Movie 5',2005,'Sci-Fi','2025-07-05 18:42:15','2025-07-05 18:42:15'),(11,'Movie 6',2006,'Sci-Fi','2025-07-05 20:13:35','2025-07-05 20:13:35'),(12,'Movie 7',2007,'Drama','2025-07-05 20:13:35','2025-07-05 20:13:35'),(13,'Movie 8',2010,'Drama','2025-07-05 20:13:35','2025-07-05 20:13:35'),(14,'Movie 9',1995,'Drama','2025-07-05 20:13:35','2025-07-05 20:13:35'),(15,'Movie 10',2005,'Drama','2025-07-05 20:13:35','2025-07-05 20:13:35'),(16,'Movie 11',2005,'Drama','2025-07-05 20:13:35','2025-07-05 20:13:35'),(17,'Movie 12',2005,'Drama','2025-07-05 20:13:35','2025-07-05 20:13:35'),(18,'Movie 13',2005,'Drama','2025-07-05 20:13:35','2025-07-05 20:13:35'),(19,'Movie 14',2005,'Drama','2025-07-05 20:13:35','2025-07-05 20:13:35'),(20,'Movie 15',2005,'Drama','2025-07-05 20:13:35','2025-07-05 20:13:35'),(21,'Movie 16',2005,'Drama','2025-07-05 20:13:35','2025-07-05 20:13:35'),(22,'Movie 17',2005,'Drama','2025-07-05 20:13:35','2025-07-05 20:13:35'),(23,'Movie 18',2005,'Drama','2025-07-05 20:13:35','2025-07-05 20:13:35'),(25,'Title 1',NULL,NULL,'2025-07-08 19:53:27',NULL),(26,'Title 2',NULL,NULL,'2025-07-08 19:53:27',NULL),(27,'Title 3',NULL,NULL,'2025-07-08 19:54:50',NULL),(28,'Title 4',NULL,NULL,'2025-07-08 19:54:50',NULL),(29,'Movie 29',2010,'Sci-Fi','2025-07-20 19:03:48','2025-07-20 19:03:48'),(32,'Movie 30',2010,'Sci-Fi','2025-07-20 19:09:49','2025-07-20 19:09:49'),(33,'Movie 31',2010,'Sci-Fi','2025-07-20 19:13:23','2025-07-20 19:13:23'),(36,'Test movie 36 updated',2010,'Sci-Fi','2025-07-20 19:25:11','2025-07-20 19:37:10');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_details`
--

DROP TABLE IF EXISTS `movie_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `movie_id` int DEFAULT NULL,
  `details` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_details`
--

LOCK TABLES `movie_details` WRITE;
/*!40000 ALTER TABLE `movie_details` DISABLE KEYS */;
INSERT INTO `movie_details` VALUES (1,1,'Forrest Gump Details','2025-06-28 19:22:48','2025-06-28 19:22:48'),(2,2,'About a ship','2025-06-28 19:23:48','2025-06-28 19:23:48'),(3,3,'Movie 3 Details Update','2025-06-28 19:56:14','2025-06-28 19:57:33'),(5,6,'Movie 4 details','2025-07-05 18:42:01','2025-07-05 18:42:01'),(6,7,'Movie 5 details','2025-07-05 18:42:15','2025-07-05 18:42:15'),(10,11,'Movie 6 details','2025-07-05 20:13:35','2025-07-05 20:13:35'),(11,12,'Movie 7 details','2025-07-05 20:13:35','2025-07-05 20:13:35'),(12,13,'Movie 8 details','2025-07-05 20:13:35','2025-07-05 20:13:35'),(13,14,'Movie 9 details','2025-07-05 20:13:35','2025-07-05 20:13:35'),(14,15,'Movie 10 details','2025-07-05 20:13:35','2025-07-05 20:13:35'),(15,16,'Movie 11 details','2025-07-05 20:13:35','2025-07-05 20:13:35'),(16,17,'Movie 12 details','2025-07-05 20:13:35','2025-07-05 20:13:35'),(17,18,'Movie 13 details','2025-07-05 20:13:35','2025-07-05 20:13:35'),(18,19,'Movie 14 details','2025-07-05 20:13:35','2025-07-05 20:13:35'),(19,20,'Movie 15 details','2025-07-05 20:13:35','2025-07-05 20:13:35'),(20,21,'Movie 16 details','2025-07-05 20:13:35','2025-07-05 20:13:35'),(21,22,'Movie 17 details','2025-07-05 20:13:35','2025-07-05 20:13:35'),(22,23,'Movie 18 details','2025-07-05 20:13:35','2025-07-05 20:13:35'),(23,24,'Movie 19 details','2025-07-05 20:13:35','2025-07-05 20:13:35'),(26,32,'Movie 30','2025-07-20 19:09:49','2025-07-20 19:09:49'),(27,33,'Movie 31','2025-07-20 19:13:23','2025-07-20 19:13:23'),(30,36,'Movie 31','2025-07-20 19:25:11','2025-07-20 19:25:11');
/*!40000 ALTER TABLE `movie_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` varchar(45) DEFAULT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN','1','2025-07-27 19:15:56','2025-07-27 19:15:56'),(2,'ROLE_USER','2','2025-07-27 19:21:52','2025-07-27 19:21:52'),(3,'ROLE_USER','3','2025-07-27 20:07:53','2025-07-27 20:07:53');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$10$PC9gikIYBiVZo/GvUys1Z.yWUzVO.T.nGgzolRoC.g/MVlyW/zWBK','2025-07-27 19:15:56','2025-07-27 19:15:56'),(2,'user','$2a$10$GFAsTaaTEPkUPWtpw3gkEOXFv2aTw5hxMuOAkxjXyZ0il9Ggmiewy','2025-07-27 19:21:52','2025-07-27 19:21:52'),(3,'user2','$2a$10$UlEGYvuXLUFUd0j5Fz1D3.zIAx5dO1poKwvWx0oxJC6fzDyLlO/IK','2025-07-27 20:07:53','2025-07-27 20:07:53');
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

-- Dump completed on 2025-07-27 20:26:05
