-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: javaquizdb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `Admin_ID` int NOT NULL,
  `Admin_Name` varchar(45) DEFAULT NULL,
  `Admin_UserName` varchar(45) DEFAULT NULL,
  `Admin_Pwd` varchar(45) DEFAULT NULL,
  `Admin_Email` varchar(45) DEFAULT NULL,
  `Admin_Mobile` varchar(45) DEFAULT NULL,
  `Admin_Designation` varchar(45) DEFAULT NULL,
  `Regi_Date` varchar(45) DEFAULT NULL,
  `Admin_DOB` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Admin_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Vikram','vicky','vics','vicky@gmail.com','8787878787','','0','0'),(2,'sourabh','saurabh','saurabh','saurabh@gmail.com','8789765645','it','0','0'),(6,'raj','raj','raj','raj@g.com','6675765676','hgsdsad','0','0');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `javaquiz`
--

DROP TABLE IF EXISTS `javaquiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `javaquiz` (
  `id` int DEFAULT NULL,
  `java_question` varchar(4000) DEFAULT NULL,
  `optionA` varchar(400) DEFAULT NULL,
  `optionB` varchar(400) DEFAULT NULL,
  `optionC` varchar(400) DEFAULT NULL,
  `option_yes` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `javaquiz`
--

LOCK TABLES `javaquiz` WRITE;
/*!40000 ALTER TABLE `javaquiz` DISABLE KEYS */;
INSERT INTO `javaquiz` VALUES (1,'Who invented Java Programming?','Guido van Rossum','Bjarne Stroustrup','Dennis Ritchie','James Gosling'),(2,'Which component is used to compile, debug and execute the java programs?','JRE','JIT','JVM','JDK'),(3,'Which of the following is not an OOPS concept in Java?','Polymorphism','Inheritance','Encapsulation','Compilation'),(4,'Which exception is thrown when java is out of memory?','MemoryError','MemoryFullException','MemoryOutOfBoundsException','OutOfMemoryError');
/*!40000 ALTER TABLE `javaquiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz`
--

DROP TABLE IF EXISTS `quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quiz` (
  `studentName` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` int DEFAULT NULL,
  `mobilenum` mediumtext,
  `emailId` varchar(255) DEFAULT NULL,
  `score` int DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `id` int DEFAULT NULL,
  `wrong_ans` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz`
--

LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
/*!40000 ALTER TABLE `quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `studentName` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `mobilenum` mediumtext,
  `emailId` varchar(255) DEFAULT NULL,
  `score` int DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `id` int DEFAULT NULL,
  `wrong_ans` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('ashwini gaikwad','ashwini','ash','6756453423','ash@g.com',4,'A',1,0),('Sweety Gaikwad','Sweety','sweets','2345678978','sweets@g.com',3,'A',1,1),('Pushkar Balwadkar','Pushkar','push','2654356780','push@b.com',4,'A',1,0),('santosh','san','san','4545454567','san@as.c',1,'c',1,3);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-07 12:00:08
