CREATE DATABASE  IF NOT EXISTS `disdb` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `disdb`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: disdb
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `displaydata`
--

DROP TABLE IF EXISTS `displaydata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `displaydata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(10000) NOT NULL,
  `start_date_millisec` bigint(20) NOT NULL,
  `end_date_millisec` bigint(20) NOT NULL,
  `time_interval_sec` int(11) NOT NULL,
  `valid` tinyint(1) NOT NULL DEFAULT '0',
  `notes` varchar(100) DEFAULT NULL,
  `image` longblob,
  `created_by` varchar(45) NOT NULL,
  `created_on` bigint(20) NOT NULL,
  `subject` varchar(45) NOT NULL,
  `the_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=321 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `displaydata`
--

LOCK TABLES `displaydata` WRITE;
/*!40000 ALTER TABLE `displaydata` DISABLE KEYS */;
INSERT INTO `displaydata` VALUES (228,'<h1><span style=\"color: #ff0000; font-size: 35pt;\">Nos objectifs:</span></h1>\n<ol>\n<li>Am&eacute;liorer <span style=\"color: #ff0000;\"><em>l\'employabilit&eacute;</em></span> des demandeurs d\'emploi dans le domaine de l\'informatique</li>\n<li>Am&eacute;liorer <span style=\"color: #ff0000;\"><em>l\'aptitude</em></span> &agrave; l\'emploi en d&eacute;veloppant le professionalisme</li>\n</ol>',1393542000000,4078335600000,3,0,'',NULL,'admin',1393596394114,'Objectifs',2),(239,'<p>Permanence coaching</p>\n<div>\n<h4>Afin de vous permettre, au cours de votre stage de :</h4>\n<ul>\n<li>poser des questions</li>\n<li>demander des conseils relatifs &agrave; votre recherche d\'emploi</li>\n<li>pr&eacute;parer des entretiens &agrave; venir, etc. ...</li>\n</ul>\n<p><br />Lab4Tech vous propose une permanence tous les mardis apr&egrave;s-midi.&nbsp;<br /><br /></p>\n<p>Comment proc&eacute;der ?</p>\n<ol>\n<li>Pr&eacute;parer et regrouper l\'ensemble de vos questions.</li>\n<li>S\'inscrire sur la feuille pr&eacute;vue &agrave; cet effet, &agrave; la r&eacute;ception.</li>\n</ol>\n<p>sddd</p>\n</div>',1393887600000,4078936800000,4,1,'',NULL,'admin',1393948763461,'Permanence coaching',4),(243,'<p style=\"text-align: center;\"><span style=\"color: #0000ff;\"><span style=\"font-size: 55pt;\">Nous vous </span><span style=\"font-size: 55pt;\">souhaitons&nbsp;</span><span style=\"font-size: 55pt;\">une bonne journ&eacute;e</span></span></p>\n<p style=\"text-align: center;\"><span style=\"font-size: 55pt; color: #0000ff;\">et</span><br /><span style=\"font-size: 55pt;\"><span style=\"color: #0000ff;\">une agr&eacute;able visite!</span>&nbsp;</span><img src=\"http://cdn.tinymce.com/4/plugins/emoticons/img/smiley-smile.gif\" alt=\"smile\" width=\"54\" height=\"54\" /></p>',1471989600000,1483138800000,10,1,'A remplacer avant la fin de l\'année',NULL,'alain',1394024837838,'Bonne journée',3),(247,'<div class=\"content\" style=\"font-family: Arial; font-size: 1.4em; color: #225bc2; text-align: center;\">\n<h1>Les moyens</h1>\n<span style=\"font-size: 1.4em;\">bilan compl&eacute;mentaire</span><br /><span style=\"font-size: 1.4em;\">stages pratiques</span><br /><span style=\"font-size: 1.4em;\">laboratoires</span><br /><span style=\"font-size: 1.4em;\">projets</span><br /><span style=\"font-size: 1.4em;\">workshops</span></div>',1393974000000,1483138800000,11,0,'',NULL,'alain',1394025961445,'Moyens',5),(262,'<h1><strong>maladie de toto</strong></h1>\n<p>toto est malade en <span style=\"color: #ff0000;\">avion</span> et aussi en <span style=\"color: #3366ff;\">voiture</span></p>',1471989600000,1483138800000,10,1,'dire à toto de ranger ses pantoufles',NULL,'admin',1472127507903,'toto est malade en avion',0),(281,'<h1><span style=\"font-size: 36pt;\"><strong><span style=\"color: #000000;\">Ouahhh</span></strong></span></h1>\n<p><span style=\"color: #000000; font-size: 26pt;\">c\'est des <strong>banannes</strong> <span style=\"background-color: #339966;\">vertes</span> et elles sont mures</span></p>\n<p><span style=\"color: #000000; font-size: 26pt;\"><span style=\"background-color: #ffff99;\">merci de penser aux phoques avant de les manger</span><br /><span style=\"background-color: #ffff99;\">et faite bien attention aux arr&ecirc;tes.</span><br /></span></p>\n<p><span style=\"color: #808080; font-size: 26pt;\"><em>Bande de branleurs</em></span></p>',1472076000000,1472594400000,10,1,'Information gratuite aux actionnaires',NULL,'admin',1472210923332,'toto popo coco',0),(282,'<p><span style=\"text-decoration: underline;\"><strong><span style=\"font-size: 26pt;\">Du nougat et des pommes</span></strong></span></p>\n<p><span style=\"font-size: 26pt;\">pour mon 4 heure car j\'aime les pommes et le nougat</span></p>\n<p><span style=\"font-size: 26pt;\">Ce m&eacute;lange va tr&egrave;s bien ensemble car il colle aux dents et rafraichis la laine</span></p>\n<p style=\"text-align: center;\"><span style=\"color: #ff0000; font-size: 26pt;\">Vive le mouton !!!</span></p>',1472076000000,1472594400000,8,1,NULL,NULL,'admin',1472214312770,'Donnez moi du nougat',0),(283,'<p style=\"text-align: center;\"><span style=\"font-size: 35pt;\">je veux</span></p>\n<p style=\"text-align: center;\"><span style=\"font-size: 35pt;\">des <span style=\"color: #99cc00;\">pommes</span>&nbsp;!!</span></p>\n<p style=\"text-align: center;\"><span style=\"font-size: 35pt;\">et</span></p>\n<p style=\"text-align: center;\"><span style=\"font-size: 35pt;\">des <span style=\"color: #ffcc00;\">caramels !!</span></span></p>\n<p style=\"text-align: center;\"><span style=\"font-size: 35pt; color: #000000;\">Sinon je retiens ma respiration jusqu\'&agrave; ce qu\'il y en aie</span></p>',1472076000000,1472594400000,6,1,NULL,NULL,'admin',1472214610399,'Donnez moi des pommes et des caramels',0),(284,'<p>Hey, how is it my dear ?</p>',1472421600000,1472594400000,5,1,NULL,NULL,'admin',1472460906963,'des caramels mous',0),(295,'<p>pk&eacute;lakd&eacute;asd</p>\n<p>asdasd</p>',1472508000000,1472594400000,1,1,NULL,NULL,'admin',1472564345955,'crotale',12),(296,'<p>ssdgfgdf</p>',1472508000000,1472594400000,1,1,NULL,NULL,'admin',1472564961711,'rotopourite',13),(297,'<p>sdfsdfsdf</p>',1472508000000,1472594400000,1,1,NULL,NULL,'admin',1472565162552,'crotte de nez',14),(298,'<p>adsasda</p>',1472508000000,1472594400000,1,1,NULL,NULL,'admin',1472565213411,'nobolonite',15),(299,'<p>asdasdasda</p>',1472508000000,1472594400000,1,1,NULL,NULL,'admin',1472565371914,'bolos',16),(301,'<p>&eacute;lk&eacute;l&eacute;lk</p>',1472508000000,1472594400000,1,1,NULL,NULL,'admin',1472565472524,'re conos',17),(302,'<p>sfsdfs</p>',1472508000000,1475186400000,1,1,NULL,NULL,'admin',1472629576690,'fsdfs',18),(303,'<p>asdasdasd</p>',1472508000000,1475186400000,1,1,NULL,NULL,'admin',1472629627127,'asdasd',19),(304,'<p>asdasd</p>',1472594400000,1475186400000,1,1,NULL,NULL,'admin',1472629640524,'asdasd',20),(305,'<p>asdasd</p>',1472508000000,1475186400000,1,1,NULL,NULL,'admin',1472629661107,'asd',21),(306,'<p>asdasd</p>',1472594400000,1475186400000,1,1,NULL,NULL,'admin',1472629679855,'asdasd',22),(307,'<p>asdasdasd</p>',1472508000000,1475186400000,1,1,NULL,NULL,'admin',1472629697953,'asdasd',23),(308,'<p>sdfsd</p>',1472508000000,1475186400000,1,1,NULL,NULL,'admin',1472630130164,'sdfsd',24),(309,'<p>sdfsdf</p>',1472508000000,1475186400000,1,1,NULL,NULL,'admin',1472630141379,'sdfsdf',25),(310,'<p>sdfsd</p>',1472508000000,1475186400000,1,1,NULL,NULL,'admin',1472630152021,'sdfsd',26),(311,'<p>sdfsdf</p>',1472508000000,1475186400000,1,1,NULL,NULL,'admin',1472630169329,'sdfsdf',27),(312,'<p>sdfs</p>',1472508000000,1475186400000,1,1,NULL,NULL,'admin',1472630182700,'sdfs',28),(313,'<p>eterte</p>',1472508000000,1475100000000,1,1,NULL,NULL,'admin',1472634313944,'retert',29),(314,'<p>ertertert</p>',1472594400000,1475100000000,1,1,NULL,NULL,'admin',1472634324118,'ertert',30),(315,'<p>erterter</p>',1472508000000,1475013600000,1,1,NULL,NULL,'admin',1472634337745,'ertert',31),(316,'<p>etert</p>',1472594400000,1475186400000,1,1,NULL,NULL,'admin',1472634350554,'tertert',32),(317,'<p>eterte</p>',1472508000000,1475100000000,1,1,NULL,NULL,'admin',1472634365045,'erter',33),(318,'<p>sdfsdfsdf</p>',1472594400000,1474408800000,1,1,NULL,NULL,'admin',1472637306394,'sdfsdf',34),(319,'<p style=\"text-align: center;\">Il est temps</p>\n<p style=\"text-align: center;\"><img src=\"https://si.wsj.net/public/resources/images/RV-AN914_BKRV_B_P_20140725085414.jpg\" alt=\"Wingsuitter\" width=\"749\" height=\"499\" /></p>\n<p style=\"text-align: center;\">Lance toi et affronte ton destin</p>',1472594400000,1474408800000,5,1,NULL,NULL,'admin',1472637383067,'sdfsdf',35),(320,'<p style=\"text-align: center;\"><strong><span style=\"color: #339966;\">Salut mon poulet</span></strong></p>\n<p style=\"text-align: center;\"><strong><span style=\"color: #339966;\">Tu vas te faire manger aujourd\'hui</span></strong></p>\n<p style=\"text-align: center;\"><img src=\"http://www.monpetitpoulet.com/img/logo.jpg?1460446958\" alt=\"petit poulet ne deviendra pas grand\" width=\"407\" height=\"181\" /></p>',1472508000000,1475100000000,5,1,NULL,NULL,'admin',1472641226875,'dfgdfg',36);
/*!40000 ALTER TABLE `displaydata` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`alain`@`%`*/ /*!50003 TRIGGER insert_order_number 
BEFORE INSERT 
	ON disdb.displaydata FOR EACH ROW
BEGIN
	DECLARE vOrder INT(11);

	set vOrder=( select max(the_order)+1 from disdb.displayData );
	set NEW.the_order = vOrder;
    
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `displaydatatest`
--

DROP TABLE IF EXISTS `displaydatatest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `displaydatatest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(2000) NOT NULL,
  `start_date_millisec` bigint(20) NOT NULL,
  `end_date_millisec` bigint(20) NOT NULL,
  `time_interval_sec` int(11) NOT NULL,
  `valid` tinyint(1) NOT NULL DEFAULT '0',
  `notes` varchar(100) DEFAULT NULL,
  `image` longblob,
  `created_by` varchar(45) NOT NULL,
  `created_on` bigint(20) NOT NULL,
  `subject` varchar(45) NOT NULL,
  `the_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=244 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `displaydatatest`
--

LOCK TABLES `displaydatatest` WRITE;
/*!40000 ALTER TABLE `displaydatatest` DISABLE KEYS */;
INSERT INTO `displaydatatest` VALUES (228,'Message #311',1467324000000,1483138800000,1,1,'',NULL,'alain',1393596394114,'Subject #1',1),(237,'Message #4 lll',1467324000000,1483138800000,1,1,'',NULL,'alain',1393942303810,'Subject #2',2),(238,'Message #3',1467324000000,1483138800000,1,1,'',NULL,'alain',1393948759136,'Subject #3',3),(239,'Message #5',1393887600000,1396562400000,1,1,'',NULL,'admin',1393948763461,'Subject #5',5),(240,'Message #4',1393887600000,1396562400000,1,1,'',NULL,'admin',1393948788123,'Subject #4',4),(241,'abcdefghijklmnopqrstuvwxyz',1393974000000,1394060400000,2,1,'abcdefghijklmnopqrstuvwxyzd',NULL,'admin',1394006535890,'Subject #7',7),(242,'Message #6',1393974000000,1396648800000,1,1,'',NULL,'admin',1394008584740,'Subject #6',6),(243,'Message #8',1393974000000,1396648800000,1,1,'',NULL,'admin',1394019540542,'Subject #8',8);
/*!40000 ALTER TABLE `displaydatatest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (3,'ROLE_ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identity` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `login` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'admin','admin','$2a$10$6w4pZTEZEibqqTfhRo18TeuGEsYD6yf49zyiaMkdK7vdpZk5CG4Nm');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` int(11) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_777tey2suldskv0nuy69r2q54` (`ROLE_ID`),
  KEY `FK_vt6s6gnj0o1ocigu9mwf0x9d` (`USER_ID`),
  CONSTRAINT `FK_777tey2suldskv0nuy69r2q54` FOREIGN KEY (`ROLE_ID`) REFERENCES `roles` (`id`),
  CONSTRAINT `FK_vt6s6gnj0o1ocigu9mwf0x9d` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,3,2);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'disdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-06 15:02:50
